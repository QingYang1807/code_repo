package org.example.single;

/*
 * 饿汉式：
 * 	在类初始化时直接创建实例对象，不管你是否需要这个对象都会创建
 *
 * （1）构造器私有化
 * （2）自行创建，并且用静态变量保存
 * （3）向外提供这个实例
 * （4）强调这是一个单例，我们可以用final修改
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();  // 唯一实例，通过静态常量获取

    private Singleton1() {
        // 私有化构造器，防止外部类直接实例化对象
    }
}