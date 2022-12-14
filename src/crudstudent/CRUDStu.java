package crudstudent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import data.Student;

public class CRUDStu{
 
 
  public static StringBuilder getlistStudent(List<Student> stu){
    StringBuilder sb = new StringBuilder();
    sb.append("hoc sinh : \n");
    for (Student st :stu) {
      sb.append(st.getName()+"\t");
    }
     sb.append("\n");
     System.out.println(sb);
     return sb;
  } 
  
  public static Student getStudentById(int id, List<Student> list) {
  
    for (int i=0;i<list.size();i++) {
      if(list.get(i).getIdStudent()==id) {
        System.out.println("hoc sinh : "+list.get(i).getName()+"\tlop :"+list.get(i).getLop()+"\tid == "+list.get(i).getIdStudent());
        return list.get(i);
      }
    }
    return null;
  }
  
  public static List<Student> reLoadList(List<Student> list){
    ArrayList<Student> arr = new ArrayList<>(list.size());
    for(int i=0; i<list.size();i++) {
      arr.add(list.get(i));
    }
    list.addAll(arr);
    
    return list;
  }





 
  
}
