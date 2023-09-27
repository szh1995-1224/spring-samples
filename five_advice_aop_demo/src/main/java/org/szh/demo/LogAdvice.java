package org.szh.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvice {

    /**
     * 前置通知，在被拦截下来的方法之前触发
     *
     * @param jp
     */
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行啦...");
    }

    /**
     * 后置通知 在目标方法执行之后执行
     *
     * @param jp
     */
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束啦...");
    }

    /**
     * 异常通知 在目标方法执行出错时触发（如果目标方法trycatch捕获异常 不抛出的话 不会进异常通知）
     * 异常通知要求方法抛出的异常类型必须和异常通知的参数的异常类型相匹配或者级别小于参数的异常类型，才会进入到这个方法中
     * 最大的异常类型是 Throwable
     *
     * @param jp
     * @param e
     */
    public void exception(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛出" + e.getMessage() + "异常");
    }

    /**
     * 这个是返回通知，被拦截下来的目标方法执行完毕后，会触发这个方法。
     *
     * @param jp
     * @param result 目标方法的返回值，如果是void,则这里是null
     *               目标方法的返回值必须和这里的参数相匹配，该方法才会触发
     */
    public void returnAdvice(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回：" + result);
    }

    /**
     * 环绕通知 包含了上面的所有情况 集大成者 平常开发的时候用环绕通知较多
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(pjp.getSignature().getName() + "方法执行耗时" + (endTime - startTime) + "毫秒");
        return proceed;
    }

}
