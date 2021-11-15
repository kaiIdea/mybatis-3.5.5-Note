package org.apache.ibatis.modle;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/12 17:28
 * @Description: TODO
 */
public class User {

  private Integer id;

  private String userName;

  private Student student;
  public User() {
  }

  public User(Integer id, String userName,Student student) {
    this.id = id;
    this.userName = userName;
    this.student = student;
  }

  public void getUser(String userName){
    System.out.println("User:id="+id+",name="+userName);
  }
}
