package com.interview.jvm.oom;



import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jason.yang
 * @Description 元空间oom
 * -XX:MetaspaceSize=8M -XX:MaxMetaspaceSize=8M
 * @Date 2021-04-29 17:59
 */
public class MetaSpaceOOM {

    public static void main(String[] args) {
        int i = 0;

        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj, args);
                    }
                });
                Object o = enhancer.create();
                System.out.println(o);
            }
        } catch (Throwable e) {
            System.out.println(i);
            throw e;
        }
    }

    static class OOMObject {
    }

}