package org.example.single;

/*
 * 懒汉式：
 *   延迟创建这个实例对象
 *
 * (1) 构造器私有化
 * (2) 用一个静态变量保存这个唯一的实例
 * (3) 提供一个静态方法，获取这个实例对象
 */
public class Singleton5 {
    private static Singleton5 instance;  // 保存唯一实例的静态变量

    private Singleton5() {
        // 私有化构造器，防止外部类直接实例化对象
    }

    // 提供静态方法，用于获取唯一的实例对象。
    public static Singleton5 getInstance() {
        if (instance == null) {  // 第一次获取实例时，判断实例是否为空
            synchronized (Singleton5.class) {  // 使用同步块，保证线程安全
                if (instance == null) {  // 在同步块中再次判断实例是否为空，防止多个线程同时通过第一层判断进入同步块后，再次创建实例
                    try {
                        Thread.sleep(1000);  // 模拟耗时操作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    instance = new Singleton5();  // 创建实例对象
                }
            }
        }
        return instance;  // 返回唯一实例
    }
}
