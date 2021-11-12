package org.apache.ibatis.reflection;

import org.apache.ibatis.modle.Student;
import org.apache.ibatis.modle.User;
import org.apache.ibatis.reflection.property.PropertyCopier;
import org.junit.Test;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/12 17:27
 * @Description:
 */
public class PropertyCopierTest {


  @Test
  public void copyBeanProperties() {
    Student student = new Student("shanghai");
    User user = new User(1,"lili",student);
    User user1 = new User();
    PropertyCopier.copyBeanProperties(User.class,user,user1);
    student.setAddress("shanxi");
    System.out.println();
  }
}
