package com.cc.tips.thread.threadLocal;

import org.springframework.stereotype.Component;

/**
* threadLocal.
*
* @author Cc 2024/9/30 9:59
*/
@Component
public class ThreadLocalWarp {

    /**
     * 初始化ThreadLocal.
     */
    private static  final  ThreadLocal<Object> threadLocal=ThreadLocal.withInitial(Object::new);

    /**
     * 对当前线程设置数据.
     *
     * @param object 任意对象
     */
    public <T> void set(T object){
        threadLocal.set(object);
    }

    /**
     *
     *
     * @return Object
     */
    public Object get(){
      return threadLocal.get();
    }

    public void remove(){
        threadLocal.remove();
    }
}
