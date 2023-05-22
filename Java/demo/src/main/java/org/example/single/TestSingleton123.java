package org.example.single;

public class TestSingleton123 {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.INSTANCE;  // 使用静态常量 INSTANCE 访问单例实例
        System.out.println(s1);  // 打印单例实例

        Singleton2 s2 = Singleton2.INSTANCE;
        System.out.println(s2);

        Singleton3 s3 = Singleton3.INSTANCE;
        System.out.println(s3);
    }
}
