package com.maven.value;

import java.util.ResourceBundle;

/**
 * @author: ly-wflei
 * @date: 2020/3/30
 * @version: 1.0
 */
public class ResourceBundleTest {

    //使用ResourceBundle读取properties
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.println(getBean("className"));
    }

    /** 读取bean.properties来创建对象 */
    public static Object getBean(String key){
        if(bundle==null) {
            //1.加载bean目录下的ResourceBundle.properties
            //getBundle: 传入properties文件的名称（不需要后缀），用于加载该文件
            bundle = ResourceBundle.getBundle("ResourceBundle.bean");

            // 一般情况下ResourceBundel读取文件方式默认的读取路径是classpath，( 在src根目录下的.properties文件)
            //2.加载ResourceBundle.properties
            //getBundle: 传入properties文件的名称（不需要后缀），用于加载该文件
            //bundle = ResourceBundle.getBundle("bean");

        }

        //2.根据传入的key找到vlaue(value:类的全名)
        String className = bundle.getString(key);

        //3.使用反射创建类的对象
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
            Object object = clazz.newInstance();
            //4.返回
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}