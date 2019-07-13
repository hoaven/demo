package com.afei.camerademo.eventbus;

/**
 * author : wangyya
 * date   : 2019/3/25
 */
public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
