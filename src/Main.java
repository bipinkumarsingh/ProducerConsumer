import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Integer> list= new ArrayList<Integer>();

        Thread prod=new Thread(new Producer(list,5),"Prodcer");
        Thread cons=new Thread(new Consumer(list),"consumer1");
        Thread cons1=new Thread(new Consumer(list),"consumer2");

        cons1.start();
       prod.start();
       cons.start();



    }
}
