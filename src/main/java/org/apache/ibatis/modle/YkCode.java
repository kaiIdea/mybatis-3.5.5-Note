package org.apache.ibatis.modle;

import java.lang.annotation.*;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/22 18:31
 * @Description: TODO
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface YkCode {

  String value();
}
