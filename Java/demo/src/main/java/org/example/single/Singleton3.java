package org.example.single;

import java.io.IOException;
import java.util.Properties;

public class Singleton3 {
    public static final Singleton3 INSTANCE;  // 唯一实例的静态常量
    private String info;  // 实例的信息

    static {
        try {
            Properties pro = new Properties();  // 创建Properties对象

            // 加载配置文件
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));

            INSTANCE = new Singleton3(pro.getProperty("info"));  // 根据配置文件中的信息创建实例
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Singleton3(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3 [info=" + info + "]";
    }
}
