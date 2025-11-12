package mid;
import java.util.*;
import java.lang.*;
public class Printer {
    public static int start = 1;
    public static final Object lock = new Object();
    public static void main(String[] args){
         Runnable printOdd = ()->{
             while (start <= 10) {
                 synchronized(lock){
                     if(start % 2 == 1){
                         System.out.println(Thread.currentThread().getName()+start++);
                         lock.notify();
                     }else{
                         try{
                             lock.wait();
                         }catch(InterruptedException e){
                             System.out.println(e);
                         }
                     }
                 }
             }
         };
         Runnable printEven = ()->{
             while(start <= 10){
                 synchronized(lock){
                     if(start % 2 == 0){
                         System.out.println(Thread.currentThread().getName()+start++);
                         lock.notify();
                     }else{
                         try{
                             lock.wait();
                         }catch(InterruptedException e){
                             System.out.println(e);
                         }
                     }
                 }
             }
         };

         new Thread(printEven,"偶数").start();
         new Thread(printOdd,"奇数").start();
    }
}
