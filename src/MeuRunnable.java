public class MeuRunnable  implements Runnable{
    @Override
    public void run() {
        System.out.println("Ola mundo, a partir do Runnable:" + Thread.currentThread().getName() );


    }
}
