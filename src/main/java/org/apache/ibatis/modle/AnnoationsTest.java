package org.apache.ibatis.modle;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/22 18:34
 * @Description: TODO
 */
public class AnnoationsTest {

    @YkCode("1111")
    public void getMessage(){

    }


  public static void main(String[] args) throws NoSuchMethodException {
    Method method = AnnoationsTest.class.getMethod("getMessage");
    Annotation[] annotation = method.getAnnotations();
    String aa = ((YkCode)annotation[0]).value();
    System.out.println();
  }
}
