package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import data.ClassStudy;
import data.Student;
import repository.ClassRepository;

public class ClassService {

  ClassRepository repoClas = new ClassRepository();
      
  public void add(String clas) throws SQLException {
    repoClas.add(clas);
  }
  
  public int delete(String tenlop) throws SQLException {
    return repoClas.delete(tenlop);
  }
  

  public List<Student> getstudent(int idlop) throws SQLException {
    
    return repoClas.getstudent(idlop);
  }
}
