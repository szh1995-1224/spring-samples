package org.szh.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
/**
 * Aspect=Pointcut+Advice
 */

@Aspect
@Component
//这个相当于 <aop:aspectj-autoproxy/>，这个注解是用来识别项目中的 Aspect 的  里面有个属性 有接口的类如果想要CGlib代理  proxyTargetClass = true
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LogAspect {

    @Pointcut("execution(* org.szh.demo.CalculatorImpl.*(..))")
    public void pc() {

    }

    @Before("pc()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行啦..");
    }

    @After("execution(* org.szh.demo.CalculatorImpl.*(..))")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行完啦..");
    }

    @AfterThrowing(value = "pc()", throwing = "e")
    public void exception(JoinPoint jp, Exception e) {
        System.out.println(jp.getSignature().getName() + "方法执行异常：" + e.getMessage());
    }

    @AfterReturning(value = "pc()", returning = "result")
    public void returnAdvice(JoinPoint jp, Object result) {
        System.out.println(jp.getSignature().getName() + "方法执行结果：" + result);
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long starTime = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(pjp.getSignature().getName() + "方法执行" + (endTime - starTime) + "毫秒");
        return proceed;
    }

}
