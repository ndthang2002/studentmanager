package service;

import org.apache.poi.ss.formula.functions.EDate;

import datastudent.Student;
import repository.StudentRepository;

public class StudentService {

StudentRepository<Student> stuRes = new StudentRepository<>();  
  public void add() {
     stuRes.add();
  }
  public void delete() {
    stuRes.delete(1);
  }
  
  public Student update(Student stu) {
    try {
      stuRes.update(stu);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    
    return stu;
  }
}
