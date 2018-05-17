package com.dreamer.bookcode.utj.chapter2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Java 方法区内存溢出
 * 
 * <pre>
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * </pre>
 * 
 * @author 高强
 */
public class JavaMethodAreaOOM {

    static class OOMObject {
        // null on purpose
    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {

                @Override
                public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }

            });
            enhancer.create();
        }

    }

}
