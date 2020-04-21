package com.maven.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//实现ApplicationListener接口，并指定监听的事件类型
@Component
public class ListenerDemo implements ApplicationListener<EventDemo> {

    //使用onApplicationEvent方法对消息进行接收处理
    @Override
    public void onApplicationEvent(EventDemo demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("(bean-Listener)接收到了bean-Publisher发布的消息:" + msg);
    }
}