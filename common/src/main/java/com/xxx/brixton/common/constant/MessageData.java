package com.xxx.brixton.common.constant;

import com.alibaba.fastjson.JSONObject;

/**
 * mq传输数据协议
 */
public class MessageData<T> {
    // 标题
    private String title;
    // 发送者
    private String issuer;
    // 内容
    private T data;

    private static final String DEFAULT_TITLE = "默认消息";

    private static final String DEFAULT_ISSUER = "default_server";

    private MessageData(String title, String issuer, T data) {
        this.title = title;
        this.issuer = issuer;
        this.data = data;
    }

    public static <T> MessageData<T> of(T data) {
        return new MessageData<>(DEFAULT_TITLE, DEFAULT_ISSUER, data);
    }

    public static <T> MessageData<T> of(T data, String title) {
        return new MessageData<>(title, DEFAULT_ISSUER, data);
    }

    public static <T> MessageData<T> of(T data, String title, String issuer) {
        return new MessageData<>(title, issuer, data);
    }

    public static  <T> MessageData<T> parse(String json, Class<T> tClass) {
        MessageData md = JSONObject.parseObject(json, MessageData.class);
        Object o = md.getData();
        if (tClass.isInstance(o)) {
            md.setData(tClass.cast(o));
            return md;
        }
        return null;
    }

    public String toJson() {
        return JSONObject.toJSONString(this);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
