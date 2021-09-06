package tech.rpish.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    //前置通知
    public void myBefore(JoinPoint joinPoint) {
        System.out.print("BEFORE前置通知:模拟执行权限检查,");
        System.out.print("目标类是:" + joinPoint.getTarget());
        System.out.println("置入增强处理的目标方法为" + joinPoint.getSignature().getName());
    }

    //后置通知
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.print("AFTER RETURINING后置通知:模拟记录日志,");
        System.out.println("被置入增强处理的目标方法为:" + joinPoint.getSignature().getName());
    }

    //    环绕通知
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始:执行目标方法之前,模拟开始事务");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束:执行目标方法之后,模拟关闭事务");
        return obj;
    }

    //异常通知
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("AFTER THROWING异常通知:出错了" + e.getMessage());
    }

    //    最终通知
    public void myAfter() {
        System.out.println("AFTER最终通知:模拟方法结束后释放资源");
    }
}
