package com.maven.test;

import java.util.ResourceBundle;

/**
 * @author: ly-wflei
 * @date: 2020/3/30
 * @version: 1.0
 */
public class HelloWorld {

    //使用ResourceBundle读取properties
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.say();
    }

    public void say(){
        System.out.println("helloworld");
    }
}