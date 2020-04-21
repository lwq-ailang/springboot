package com.maven.event;

import org.springframework.context.ApplicationEvent;

/**
 * Spring的事件为Bean与Bean之间的消息通信提供了支持，当一个Bean处理完一个任务之后，
 * 希望另外一个Bean知道并能做相应的处理，这时我们就需要让一个Bean监听当前Bean所发送的事件。
 * <p>
 * 　Spring的事件需要遵循如下流程：
 * 1.自定义事件，继承ApplicationEvent。
 * 2.定义事件监听器，实现ApplicationListener。
 * 3.使用容器发布事件。
 */
// 1.自定义事件，继承ApplicationEvent。
public class EventDemo extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private String msg;

    public EventDemo(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}