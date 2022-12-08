package datastudent;

public class Student {

  private int idStudent;
  private String name;
  private String lop;
  
  public Student() {
    
  }
  
  public Student(int id , String name , String lop) {
    this.idStudent=id;
    this.name= name;
    this.lop=lop;
  }
  
  public int getIdStudent() {
    return this.idStudent;
  }
  public void setIdStudent(int id) {
    this.idStudent=id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLop() {
    return lop;
  }

  public void setLop(String lop) {
    this.lop = lop;
  }
  
  
}
