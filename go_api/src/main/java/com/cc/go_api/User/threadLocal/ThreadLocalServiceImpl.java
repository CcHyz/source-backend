package com.cc.go_api.User.threadLocal;

import org.springframework.stereotype.Service;

@Service
public class ThreadLocalServiceImpl implements ThreadLocalService {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public String getCurrentId() {
        return threadLocal.get();
    }

    @Override
    public void setCurrentId(String id) {
        threadLocal.set(id);
    }

    @Override
    public void remove() {
        threadLocal.remove();
    }
}
