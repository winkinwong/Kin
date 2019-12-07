package com.kin.test.springboot.global.util;

import com.kin.test.springboot.model.User;

/**
 * @program: springboot0918
 * @description: 线程工具类
 * @author: 黄永健
 * @create: 2019-10-22 10:46
 **/
public class ThreadLocalHelper {
    public static final ThreadLocal<String> requestIdStore = new ThreadLocal<>();
    public static final ThreadLocal<User> sessionUserStore = new ThreadLocal<>();

    public static void setRequestId(String requestId) {
        requestIdStore.set(requestId);
    }

    public static String getRequestId() {
        return requestIdStore.get();
    }

    public static void removeRequestId() {
        requestIdStore.remove();
    }

    public static void setSessionUser(User user) {
        sessionUserStore.set(user);
    }

    public static User getSessionUser() {
        return sessionUserStore.get();
    }

    public static void removeSessionUser() {
        sessionUserStore.remove();
    }
}
