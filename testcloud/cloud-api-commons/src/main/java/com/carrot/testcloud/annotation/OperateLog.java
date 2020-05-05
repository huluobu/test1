package com.carrot.testcloud.annotation;

import java.lang.annotation.*;

/**
 * create by: carrot
 * classname: OperLog
 * description: use to  记录操作类型
 * create time: 2020/5/5 9:19
 * @author carrot
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {
    String operateModule() default  "";
    String operateType() default  "";
    String operateDescription() default  "";
}
