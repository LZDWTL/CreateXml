package cn.annotation;

/**
 * @author 10237
 * @date 2021-03-14 16:26
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解就是一个标识
 */

@Target(ElementType.TYPE)    //TYPT是作用在类上，METHOD是作用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
