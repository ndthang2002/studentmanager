package game;


import java.util.Random;
import java.util.Scanner;

public class GameDoanSo {
  static int count =1;
  public static void main(String[] args) {
    System.out.println("chao mung ban den voi tro choi:");
    System.out.println("hay du doan con so may may hom nay");
    doanso();
  }
  public static void doanso() {
    Scanner nhap = new Scanner(System.in);
    boolean condition= false;
   
    int DIEM=10;
    if(count>5) {
      condition=true;
      return;
    }
    do {
      
      if(count<=5){
        System.out.print("hay chon con so yeu thich cua ban: ");

        Random rd = new Random();
        int kq = rd.nextInt(5)+1;

        //xu li input
        int soUserChon = 0;
        try {
          soUserChon=  nhap.nextInt();
          nhap.nextLine();
       
        } catch (Exception e) {
           
          doanso();
        
          // TODO: handle exception
        }

        if(soUserChon==kq) {
          condition=true;
        }else {
          if(soUserChon>kq) {
            System.out.println("ban chon cao qua----");
            condition=false;
            count++;
            DIEM=DIEM-2;
          }
          else if(soUserChon<kq){
            System.out.println("ban chon thap qua----");
            condition=false;
            count++;
            DIEM-=2;
          }
        }

      }else {
        
        condition= true;
        
      }

    } while (condition==false);
    if(count>4) {
      System.out.println("qua so lan doan");
  
    }else {
      System.out.println("ban da doan dung");
      System.out.println("so diem cua ban la: "+DIEM+"/10");
    }
  }

}
