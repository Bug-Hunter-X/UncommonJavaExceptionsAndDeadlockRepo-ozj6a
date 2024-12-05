public class UncommonErrorSolution {
    public static void main(String[] args) {
        int[] array = new int[5];
        try {
            System.out.println(array[0]); // Accessing a valid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String str = "Hello";
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
        int x = 10;
        int y = 1;
        try{
            int z = x/y; 
            System.out.println(z); //Avoid division by zero
        }catch (ArithmeticException e){
            System.out.println("Error:" + e.getMessage());
        }
        //Avoid deadlock by ordering the lock acquisition consistently across threads.
        //Using Semaphore can prevent deadlock.
    }
}