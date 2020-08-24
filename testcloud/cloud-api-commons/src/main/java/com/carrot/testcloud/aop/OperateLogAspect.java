package com.carrot.testcloud.aop;
import com.carrot.testcloud.annotation.OperateLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: carrot
 * @Date: 2020/5/5 9:28
 */
@Aspect
@Component
public class OperateLogAspect {



    /*    private OperationLogService operationLogService;*/

    @Pointcut("@annotation(com.carrot.testcloud.annotation.OperateLog)")
    public void operateLogPointCut() {

    }

/*    @Pointcut()
    public void operateExceptionLogPointCut() {
    }*/

    public void saveOperateLog(JoinPoint joinPoint, Object keys) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();// 获取切入点所在的方法
        Method method = signature.getMethod();  // 获取操作
        OperateLog opLog = method.getAnnotation(OperateLog.class);
        if (opLog != null) {
            String operModul = opLog.operateModule();
            String operType = opLog.operateType();
            String operDesc = opLog.operateDescription();
/*          operlog.setOperModul(operModul); // 操作模块
            operlog.setOperType(operType); // 操作类型
            operlog.setOperDesc(operDesc); // 操作描述*/
        }
    }
}
