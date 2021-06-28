import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Synchronized_1 {

    private static List<String> professores = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t0.start();
        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(professores.stream().collect(Collectors.toList()));
    }


    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                professores.add("Emilio Mosse");
            }
        }
    }


}
