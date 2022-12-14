package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import data.Student;

public class StudentRepository<T> implements IstudentRepository<T>{

  Connection conn;
  String username = "thang";
  String url = "jdbc:postgresql://localhost:5432/tera";
  
  @Override
  public void add() {
    // TODO Auto-generated method stub
    try {
      String sql ="INSERT INTO student (name ,lop) values(?,?)";
      conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tera","thang","");
      PreparedStatement pmts = conn.prepareStatement(sql);
      pmts.setString(1, "thuy");
      pmts.setString(2, "11");
      pmts.execute();
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
      
  }

  @Override
  public boolean delete(int id) {
    // TODO Auto-generated method stub
    try {
      conn = DriverManager.getConnection(url,username, "");
      String sql = "delete from student where student_id="+id;
      Statement  st = conn.createStatement();
     int row = st.executeUpdate(sql);
     System.out.println(row);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Student update(Student student) {
    // TODO Auto-generated method stub

    try {
      conn = DriverManager.getConnection(url,username, "");
      
       String  sql = "update student set name=? ,lop=? where student_id=?";
   
    PreparedStatement ptms = conn.prepareStatement(sql);
    
    ptms.setString(1, student.getName());
    ptms.setString(2, student.getLop());
    ptms.setInt(3, student.getIdStudent());
    ptms.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
    return student; 
  }

  @Override
  public Student get(int id) {
    // TODO Auto-generated method stub
    Student stu=null;
    try {
      conn = DriverManager.getConnection(url,username, "");
      String sql =" select * from student where student_id="+id;
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      rs.next();
       stu =  getResult(rs);
   
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return stu;
  }
  
  public Student getResult(ResultSet rs) throws SQLException {
    Student st = new Student(rs.getInt("student_id"),rs.getString("name"),rs.getString("lop"));
    return st;
  }

  @Override
  public List<T> getAll() {
    // TODO Auto-generated method stub
    
    return null;
  }


}
