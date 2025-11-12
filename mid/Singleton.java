package mid;
import java.util.*;
import java.lang.*;
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {
    }
    private Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
