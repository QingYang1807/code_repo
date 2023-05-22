package org.example.single;

/*
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 因为是在内部类加载和初始化时，创建的，因此是线程安全的
 */
public class Singleton6 {
    private Singleton6() {
        // 私有化构造器，防止外部类直接实例化对象
    }

    private static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();  // 内部类中的唯一实例，通过静态常量获取
    }

    public static Singleton6 getInstance() {
        return Inner.INSTANCE;  // 通过静态方法返回唯一实例
    }
}
