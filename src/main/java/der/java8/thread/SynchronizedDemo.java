package der.java8.thread;
/**
* @FileName:SynchronizedDemo
* @Description: every java object has an intrinsic lock (or monitor lock)
 *                 associated with it
* @Author: Derrick Ye
*/
public class SynchronizedDemo {

    /**
     * lock class object
     */
    public void SynchronizedDemoClass() {
        synchronized (SynchronizedDemo.class) {
            System.out.println("To lock class! "+Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * lock method
     */
    public synchronized void synchronizedMethod() {
        try {
            System.out.println("To lock Method! "+Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * lock block
     */
    public void synchronizedThis() {
        synchronized (this) {
            System.out.println("To lock block! "+Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
