public class UncommonErrorExample {
    public static void main(String[] args) {
        int[] array = new int[5];
        try {
            System.out.println(array[5]); // IndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String str = null;
        try {
            System.out.println(str.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        int x = 10;
        int y = 0;
        try{
            int z = x/y; // ArithmeticException
        }catch (ArithmeticException e){
            System.out.println("Error:" + e.getMessage());
        }
        
        //Deadlock example
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock1 and lock2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock2 and lock1");
                }
            }
        });
        t1.start();
        t2.start();
        
    }
}