/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multithread;
import java.util.*;

/**
 *
 * @author ashwi
 */
public class Multithread {

       class thread1 extends Thread{
    
    int n;
    thread1(int n){
        this.n=n;
    }
    @Override
    public void run(){
        Random r=new Random();
        for(int i =0; i<n; i++){
            int randomnumber=r.nextInt(50);
            System.out.println("generated random number"+randomnumber);
            thread2 t2=new thread2(randomnumber);
            t2.start();
            thread3 t3=new thread3(randomnumber);
            t3.start();
             try {
                Thread.sleep(1000);
                } catch (InterruptedException e) {
                        System.out.println(e);
                    }
        }
    }
}
class thread2 extends Thread{
    int y;
            
    thread2(int y){
        this.y=y;
    }
    @Override
    public void run(){
        System.out.println("Square of the number :"+(y*y));
                
    }
}
class thread3 extends Thread{
    int z;
            
    thread3(int z){
        this.z=z;
    }
    @Override
    public void run(){
        System.out.println("cube of the number :"+(z*z*z));
    }
}
public class multithread {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in); 
       System.out.println("enter the required number of random integers");
       int n=sc.nextInt();
       thread1 t1=new thread1(n);
       t1.start();
    }
}
}
