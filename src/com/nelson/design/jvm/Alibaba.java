package com.nelson.design.jvm;

/**
 * Jvm: loading、linking、initialization.
 * Loading: classLoader .class -> bytercode -> Method area
 * Linking: verification -> preparation(static init) -> resolution
 * Initialization: 代码块（static与static）、构造函数、变量显式赋值
 * 原则：
 * 1、有static先初始化static，然后是非static的
 * 2、显式初始化，构造块初始化，最后调用构造函数进行初始化
 */
public class Alibaba {
    public static int k = 0;
    public static Alibaba t1 = new Alibaba("t1");
    public static Alibaba t2 = new Alibaba("t2");
    public static int i = print("i");
    public static int n = 99;
    private int a = 0;
    public int j = print("j");

    {
        print("构造块");
    }

    static {
        print("静态块");
    }

    public Alibaba(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String args[]) {
        Alibaba t = new Alibaba("init");
    }
}
