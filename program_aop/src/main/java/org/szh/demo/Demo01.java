package org.szh.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class Demo01 {
    public static void main(String[] args) {
        //创建代理对象工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //设置被代理的对象
        proxyFactory.setTarget(new CalculatorImpl());
        //设置代理对象实现的接口，这个方法可以不设置，如果调用了这个方法，即被代理的对象有接口，那么底层就是用JDK动态代理，否则是CGLIB动态代理
        proxyFactory.setInterfaces(ICalculator.class);
        //设置通知/增强 ,本质上就是被代理的方法，要额外做的事情，在这个里边来完成
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                //获取被拦截的方法
                Method method = invocation.getMethod();
                long startTime = System.currentTimeMillis();
                //执行目标方法
                Object proceed = invocation.proceed();
                long endTime = System.currentTimeMillis();
                System.out.println(method.getName() + "方法执行耗时 " + (endTime - startTime) + "毫秒");
                return proceed;
            }
        });
        //获取代理对象，这里拿到的JDK动态代理对象
        ICalculator proxy = (ICalculator) proxyFactory.getProxy();
        proxy.add(3, 2);
    }
}
