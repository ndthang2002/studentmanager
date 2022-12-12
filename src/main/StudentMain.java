package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;

import crudstudent.CRUDStu;
import crudstudent.WriteReadExcel;
import datastudent.Student;
import repository.IstudentRepository;
import service.StudentService;

public class StudentMain {
  
  
  public static void main (String[] args) {
    
    // tiem mot phat
 
    
   List<Student> lists = new ArrayList<>();
    lists.add(new Student(1, "thang", "12a"));
    lists.add(new Student(2, "hieu", "11a"));
    lists.add(new Student(3, "minh", "10d"));
    lists.add(new Student(4, "tai", "12a"));
    lists.add(new Student(5, "thien", "21d"));
    lists.add(new Student(6, "gian", "11f"));
    
    
  CRUDStu crud = new CRUDStu();
    Scanner nhap = new Scanner(System.in);
    System.out.println("xin moi chon mot chuc nang :  \n no 1:\t xem danh sach cac hoc sinh: \n no 2\t xem hoc sinh theo id: \n no 3:\tthem hoc sinh moi : \n no 4: \tsua thong tim hoc sinh \n"
        + "no 5: \tghi vao excel :\nno 6: \tdoc Excexcel :");
  
    System.out.println("lam viec voi database \n7\tadd:\n8\tdelete:\n9\tupdate:");
    int  chon= nhap.nextInt();
    nhap.nextLine();
    switch (chon) {
      case 1: {
         crud.getlistStudent(lists);
         break;
      }
      case 2: {
        System.out.println("moi nhap id hoc sinh: ");
        int idHocSinh = nhap.nextInt();
        crud.getStudentById(idHocSinh,lists);
        break;
      }
      case 3:{
        System.out.println("nhap thong tin hoc sinh :");
        System.out.println("nhap id hoc sinh: ");
        int idhocsinh = nhap.nextInt();
        nhap.nextLine();
        System.out.println("nhap ten hoc sinh: ");
        String name = nhap.nextLine();
        System.out.println("nhapp lop :");
        String lop = nhap.nextLine();
        lists.add(new Student(idhocsinh, name, lop));
        System.out.println("hoc sinh moi duoc them vao :");
        crud.getStudentById(idhocsinh, lists);
      }
      case 4:{
        
        System.out.println("nhap id hoc sinh muon sua :");
        int id = nhap.nextInt();
        nhap.nextLine();
        System.out.println("nhap thong tin sua \n nhap ten: ");
        String name = nhap.nextLine();
        System.out.println("nhap lop:");
        String lop= nhap.nextLine();
        lists.set(id, new Student(id, name, lop));
        System.out.println("hoc sinh sau khi sua:");
        System.out.println("id :"+lists.get(id).getIdStudent()+"\tname: "+lists.get(id).getName()+"\tlop: "+lists.get(id).getLop());
  
        break;
      }
      case 5:{
       WriteReadExcel ws = new WriteReadExcel();
       try {
        ws.writeExcel(lists);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
       break;
      }
      case 6:{
        WriteReadExcel wr = new WriteReadExcel();
        try {
          wr.readExcel();
        } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
        }
        break;
      }
      case 7 :{
        
        StudentService sv = new StudentService();
        sv.add();
        break;
      }
      case 8:{
        StudentService sv = new StudentService();
        sv.delete();
        break;
      }
      case 9:{
        StudentService sv = new StudentService();
        Student st = new Student(2,"hien", "10");
        sv.update(st);
        break;
      }
      default:
        System.out.println("rwe");
    }
  }

  
}
