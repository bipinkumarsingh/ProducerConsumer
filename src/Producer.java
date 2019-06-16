import java.util.ArrayList;
import java.util.List;

public class Producer implements  Runnable {

     private final List<Integer> arrayList;
     private final int MAX_SIZE;

     Producer( List<Integer> list,int max_size )
     {
         this.arrayList=list;
         this.MAX_SIZE=max_size;
     }

    @Override
    public void run() {
        int i=0;
         while (true)
         {
             try
             {
                produce(i++);
             }catch (InterruptedException e)
             {
                 e.printStackTrace();
             }


         }

    }

    private void produce(int i) throws  InterruptedException{
            synchronized (arrayList)
            {
                if(arrayList.size()==MAX_SIZE)
                {
                    System.out.println("Max SIZE Reached "+Thread.currentThread().getName());
                    arrayList.wait();

                }
                Thread.sleep(1000);
                arrayList.add(i);
                System.out.println("Produced "+i);
                arrayList.notifyAll();
            }
    }
}
