package datastudent;

public class Subject {

  private int subject_id;
  private String name_subject;
  public int getSubject_id() {
    return subject_id;
  }
  public void setSubject_id(int subject_id) {
    this.subject_id = subject_id;
  }
  public String getName_subject() {
    return name_subject;
  }
  public void setName_subject(String name_subject) {
    this.name_subject = name_subject;
  }
  public Subject(int subject_id, String name_subject) {
    super();
    this.subject_id = subject_id;
    this.name_subject = name_subject;
  }
  public Subject() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  
}
