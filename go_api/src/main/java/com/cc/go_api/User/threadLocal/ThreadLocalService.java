package com.cc.go_api.User.threadLocal;

public interface ThreadLocalService {

    String getCurrentId();

    void setCurrentId(String id);

    void remove();
}
