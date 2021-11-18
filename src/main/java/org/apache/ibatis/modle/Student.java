package org.apache.ibatis.modle;

import org.apache.ibatis.reflection.TypeParameterResolver;

import java.lang.reflect.Type;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/12 17:38
 * @Description: TODO
 */
public class Student extends BaseUser<Number>{
  private String address;

  public Student(String address) {
    this.address = address;
  }
  public void setAddress(String address) {
    this.address = address;
  }


  public static void main(String[] args) throws NoSuchMethodException {
    Type type = TypeParameterResolver.resolveReturnType(BaseUser.class.getMethod("getInfo"),BaseUser.class);
    System.out.println(type);

    Type type1 = TypeParameterResolver.resolveReturnType(Student.class.getMethod("getInfo"),Student.class);
    System.out.println(type1);
  }
}
