package com.bruce.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-26 11:56
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String value() default "hi";
}
