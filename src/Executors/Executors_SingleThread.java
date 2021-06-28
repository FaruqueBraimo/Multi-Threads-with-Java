package Executors;

import java.util.Random;
import java.util.concurrent.*;

public class Executors_SingleThread {

    public static String atribuirNumeroAoLuno(String nome) {
        return "O numero do aluno " + nome + " é : " + new Random().nextInt(50);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = null;
        String tarefa = "";
        try {

            executor = Executors.newSingleThreadExecutor();

            Future<String> future = executor.submit(new Tarefa());
            executor.shutdown();
            System.out.println(future.isDone());
            executor.awaitTermination(15, TimeUnit.SECONDS);
            System.out.println(future.isDone());
            tarefa = future.get();
            System.out.println(tarefa);
        } catch (Exception e) {
            throw e;
        } finally {
            if (executor != null) {
                executor.shutdownNow();
            }
        }

    }

    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            String nomeAluno = Executors_SingleThread.atribuirNumeroAoLuno("Faruque");
            return nomeAluno;
        }
    }


}
