import java.util.List;

public class Consumer  implements  Runnable{

    private final List<Integer> arrayList;

    Consumer( List<Integer> list)
    {
      this.arrayList=list;
    }

    @Override
    public void run() {

        try {
            while (true) {

                consume();

            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    private void consume () throws InterruptedException {
        synchronized (arrayList)
        {
            if (arrayList.isEmpty()) {
                System.out.println("List empty for thread"+Thread.currentThread().getName());
            arrayList.wait();
            }
            Thread.sleep(1000);
            int i=arrayList.remove(0);
            System.out.println("Consumed i" + i);
            arrayList.notifyAll();
        }

    }

}
