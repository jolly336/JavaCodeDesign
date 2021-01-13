package pattern.visitor.section3;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class ConcreteElement2 extends Element {

    //完善业务逻辑
    @Override
    public void doSomething() {
        //业务处理
    }

    //允许那个访问者访问
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}