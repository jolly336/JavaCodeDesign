[TOC]
# observer 观察者模式

> 观察者模式可以用生活中警察和小偷的例子来说明，当小偷（被观察者）偷东西时，通知警察（观察者）发生了违法事件。但是生活中小偷可不会主动报告警察的~：）

## Java 观察者实现

API: 

* observer: 观察者，比如：警察
* observable: 被观察者，内部维护所有观察者，比如：小偷

Observer是一个interface，只有一个update方法，两个参数，参数1位被观察者，参数2为被观察者额外传递的参数。

```
/** * A class can implement the <code>Observer</code> interface when it * wants to be informed of changes in observable objects. * * @author Chris Warth * @see java.util.Observable * @since JDK1.0 */
public interface Observer {
    /** * This method is called whenever the observed object is changed. An * application calls an <tt>Observable</tt> object's * <code>notifyObservers</code> method to have all the object's * observers notified of the change. * * @param o the observable object. * @param arg an argument passed to the <code>notifyObservers</code> * method. */
    void update(Observable o, Object arg);
}
```

Observable是一个普通Java类，维护两个成员变量：

* 状态改变标记位：changed；
* observers维护所有观察者 内部操作observers的代码都采用了同步机制，不会有线程安全问题

```
public class Observable {
    private boolean changed = false;
    private final ArrayList<Observer> observers;

    /** Construct an Observable with zero Observers. */

    public Observable() {
        observers = new ArrayList<>();
    }

    /** * Adds an observer to the set of observers for this object, provided * that it is not the same as some observer already in the set. * The order in which notifications will be delivered to multiple * observers is not specified. See the class comment. * * @param o an observer to be added. * @throws NullPointerException if the parameter o is null. */
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    /** * Deletes an observer from the set of observers of this object. * Passing <CODE>null</CODE> to this method will have no effect. * @param o the observer to be deleted. */
    public synchronized void deleteObserver(Observer o) {
        observers.remove(o);
    }

    /** * If this object has changed, as indicated by the * <code>hasChanged</code> method, then notify all of its observers * and then call the <code>clearChanged</code> method to * indicate that this object has no longer changed. * <p> * Each observer has its <code>update</code> method called with two * arguments: this observable object and <code>null</code>. In other * words, this method is equivalent to: * <blockquote><tt> * notifyObservers(null)</tt></blockquote> * * @see java.util.Observable#clearChanged() * @see java.util.Observable#hasChanged() * @see java.util.Observer#update(java.util.Observable, java.lang.Object) */
    public void notifyObservers() {
        notifyObservers(null);
    }

    /** * If this object has changed, as indicated by the * <code>hasChanged</code> method, then notify all of its observers * and then call the <code>clearChanged</code> method to indicate * that this object has no longer changed. * <p> * Each observer has its <code>update</code> method called with two * arguments: this observable object and the <code>arg</code> argument. * * @param arg any object. * @see java.util.Observable#clearChanged() * @see java.util.Observable#hasChanged() * @see java.util.Observer#update(java.util.Observable, java.lang.Object) */
    public void notifyObservers(Object arg) {
        /* * a temporary array buffer, used as a snapshot of the state of * current Observers. */
        Observer[] arrLocal;

        synchronized (this) {
            /* We don't want the Observer doing callbacks into * arbitrary Observables while holding its own Monitor. * The code where we extract each Observable from * the ArrayList and store the state of the Observer * needs synchronization, but notifying observers * does not (should not). The worst result of any * potential race-condition here is that: * * 1) a newly-added Observer will miss a * notification in progress * 2) a recently unregistered Observer will be * wrongly notified when it doesn't care */
            if (!hasChanged())
                return;

            arrLocal = observers.toArray(new Observer[observers.size()]);
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            arrLocal[i].update(this, arg);
    }

    /** * Clears the observer list so that this object no longer has any observers. */
    public synchronized void deleteObservers() {
        observers.clear();
    }

    /** * Marks this <tt>Observable</tt> object as having been changed; the * <tt>hasChanged</tt> method will now return <tt>true</tt>. */
    protected synchronized void setChanged() {
        changed = true;
    }

    /** * Indicates that this object has no longer changed, or that it has * already notified all of its observers of its most recent change, * so that the <tt>hasChanged</tt> method will now return <tt>false</tt>. * This method is called automatically by the * <code>notifyObservers</code> methods. * * @see java.util.Observable#notifyObservers() * @see java.util.Observable#notifyObservers(java.lang.Object) */
    protected synchronized void clearChanged() {
        changed = false;
    }

    /** * Tests if this object has changed. * * @return <code>true</code> if and only if the <code>setChanged</code> * method has been called more recently than the * <code>clearChanged</code> method on this object; * <code>false</code> otherwise. * @see java.util.Observable#clearChanged() * @see java.util.Observable#setChanged() */
    public synchronized boolean hasChanged() {
        return changed;
    }

    /** * Returns the number of observers of this <tt>Observable</tt> object. * * @return the number of observers of this object. */
    public synchronized int countObservers() {
        return observers.size();
    }
}
```

## 示例

NumObserable是一个被观察者，当它的成员变量data的数值发生变化时，会通知所有的观察者。 NumObserable.java

```
package com.zj.observer;
import java.util.Observable;
 
public class NumObservable extends Observable {
    private int data = 0;
 
    public int getData() {
       return data;
    }
 
    public void setData(int i) {
       data = i;
       setChanged();
       notifyObservers();
    }
}
```

NumObserver是观察者。当它的被观察者(NumObserable)执行了notifyObservers()后，它会执行update()方法。 NumObserver.java

```
package com.zj.observer;
import java.util.Observable;
import java.util.Observer;
 
public class NumObserver implements Observer{
    public void update(Observable o, Object arg) {
       NumObservable myObserable=(NumObservable) o;
       System.out.println("Data has changed to " +myObserable.getData());
    }
}
```

测试类SingleTest，在这里将观察者加入到被观察者的观察列表中。

```
package com.zj.observer;
 
public class SingleTest {
    public static void main(String[] args) {
       NumObservable number = new NumObservable();
       number.addObserver(new NumObserver());
       number.setData(1);
       number.setData(2);
       number.setData(3);
    }
}
```

结果：

```
Data has changed to 1
Data has changed to 2
Data has changed to 3
```

## 参考

* [Java中的Observer接口实践Observer模式](https://yuanfentiank789.github.io/2017/09/19/observer/)