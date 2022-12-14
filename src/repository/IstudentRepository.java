package repository;

import java.util.List;

import data.Student;

public interface IstudentRepository<T> {

  public void add ();
  public boolean delete(int id);

  public Student get(int id);
  public List<T> getAll();
  public Student update(Student student);
  
  
}
