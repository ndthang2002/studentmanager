package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.ClassStudy;
import data.Student;
import service.StudentService;

public class ClassRepository {
  Connection conn;
  String username = "thang";
  String url = "jdbc:postgresql://localhost:5432/tera";
  StudentService stuService = new StudentService();
  public void add(String cla) throws SQLException {
    conn=DriverManager.getConnection(url,username,"");
    String sql= "INSERT INTO classstudy (class_name) VALUES(?)";
    PreparedStatement ptsm = conn.prepareStatement(sql);
    ptsm.setString(1, cla);
    ptsm.execute();
    
  }  
  
  public int delete(String tenlop) throws SQLException{
    conn=DriverManager.getConnection(url,username,"");
    String sql= "DELETE FROM classstudy WHERE class_name LIKE "+"'%"+tenlop+"%'";
    Statement  stm = conn.createStatement();
    int row = stm.executeUpdate(sql);
    return row;
  }
  
  //truy van hoc sinh trong lop
  public List<Student> getstudent(int idlop) throws SQLException {
    List<Student> list = new ArrayList<>();
    conn=DriverManager.getConnection(url,username,"");
     String sql =" SELECT studen_id FROM group_class WHERE class_id = "+idlop;
     Statement stm = conn.createStatement();
     ResultSet rs = stm.executeQuery(sql);
     while(rs.next())
     {
     list.add(stuService.get(rs.getInt("studen_id")));
     }
     return list;
  }
  
  
  

}
