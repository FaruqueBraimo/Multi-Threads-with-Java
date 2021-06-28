public class Threads_1 {


    public static void main(String[] args) {

        // Thread actual
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        Thread thread1 = new Thread(new MeuRunnable());
        // thread1.run(); // apenas executa na mesma thread

        // cria uma nova thread
        thread1.start();

        // Runnable como lambda
        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread2.start();


    }
}
