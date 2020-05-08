package com.carrot.testspring.aop;
import com.carrot.testspring.annotation.OperateLog;
import com.carrot.testspring.annotation.OperateLog;
import com.carrot.testspring.entities.OperationLog;
import com.carrot.testspring.entities.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: carrot
 * @Date: 2020/5/5 9:28
 */
@Aspect
@Component
public class OperateLogAspect {



    private static final Logger LOG = LoggerFactory.getLogger(OperateLogAspect.class);
    /*    private OperationLogService operationLogService;*/

    @Pointcut("@annotation(com.carrot.testspring.annotation.OperateLog)")
    public void operateLogPointCut() {

    }

/*    @Pointcut()
    public void operateExceptionLogPointCut() {
    }*/


    @Around(value = "@annotation(com.carrot.testspring.annotation.OperateLog)")
    public void saveOperateLog(JoinPoint joinPoint) {

        OperationLog systemLog = new OperationLog();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object user=request.getSession().getAttribute("loginUser");


        systemLog.setUserid("001");

//        systemLog.setUsername(user.toString());
        String ip =request.getRemoteAddr();
        systemLog.setIp(ip);

        systemLog.setCreatime(new Date());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        Method method=signature.getMethod();
        systemLog.setMethod(name);
        OperateLog annotation = method.getAnnotation(OperateLog.class);
        if (annotation != null) {
            String operModul = annotation.operateModule();
            String operType = annotation.operateType();
            String operDesc = annotation.operateDescription();
            systemLog.setOperModul(operModul);
            systemLog.setOperType(operType);
            systemLog.setOperDesc(operDesc);
        }
        LOG.info("记录日志:" + systemLog.toString());
    }
}
