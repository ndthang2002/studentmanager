package datastudent;

public class Result {

  private int student_id;
  private int subject_id;
  private double mark;
  public int getStudent_id() {
    return student_id;
  }
  public void setStudent_id(int student_id) {
    this.student_id = student_id;
  }
  public int getSubject_id() {
    return subject_id;
  }
  public void setSubject_id(int subject_id) {
    this.subject_id = subject_id;
  }
  public double getMark() {
    return mark;
  }
  public void setMark(double mark) {
    this.mark = mark;
  }
  public Result(int student_id, int subject_id, double mark) {
    super();
    this.student_id = student_id;
    this.subject_id = subject_id;
    this.mark = mark;
  }
  public Result() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  
}
