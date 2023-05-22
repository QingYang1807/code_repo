package org.example.single;

/*
 * 懒汉式：
 * 	延迟创建这个实例对象
 *
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一的实例
 * (3)提供一个静态方法，获取这个实例对象
 */
public class Singleton4 {
    private static Singleton4 instance;  // 保存唯一实例的静态变量

    private Singleton4() {
        // 私有化构造器，防止外部类直接实例化对象
    }

    public static Singleton4 getInstance() {
        if (instance == null) {  // 第一次获取实例时，判断实例是否为空
            try {
                Thread.sleep(100);  // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Singleton4();  // 创建实例对象
        }
        return instance;  // 返回唯一实例
    }
}
