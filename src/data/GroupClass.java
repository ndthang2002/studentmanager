package data;

public class GroupClass {

  private int class_id;
  private int student_id;
  public int getClass_id() {
    return class_id;
  }
  public void setClass_id(int class_id) {
    this.class_id = class_id;
  }
  public int getStudent_id() {
    return student_id;
  }
  public void setStudent_id(int student_id) {
    this.student_id = student_id;
  }
  public GroupClass(int class_id, int student_id) {
    super();
    this.class_id = class_id;
    this.student_id = student_id;
  }
  public GroupClass() {
    // TODO Auto-generated constructor stub
  }
  
}
