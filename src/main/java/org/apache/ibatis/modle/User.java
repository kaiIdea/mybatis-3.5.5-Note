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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public void selectUserMessage(String userName){
    System.out.println("User:id="+id+",name="+userName);
  }
}
