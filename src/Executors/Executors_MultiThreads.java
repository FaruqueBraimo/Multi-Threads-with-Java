package Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Executors_MultiThreads {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = null;
        List<Double> potencias  = new ArrayList<>();

        try {

          //  executor = Executors.newFixedThreadPool(4);    // Quantidade fixa de threads
            executor = Executors.newCachedThreadPool();
            Future<Double> future = executor.submit(new Tarefa());
            Future<Double> future2 = executor.submit(new Tarefa());
            Future<Double> future3 = executor.submit(new Tarefa());
            Future<Double> future4 = executor.submit(new Tarefa());

            potencias.add( future.get());
            potencias.add( future2.get());
            potencias.add( future3.get());
            potencias.add( future4.get());

            System.out.println(potencias.stream().collect(Collectors.toList()));
            executor.awaitTermination(5, TimeUnit.SECONDS);
            executor.shutdown();

        } catch (Exception e) {
            throw e;
        } finally {
            if (executor != null) {
                executor.shutdownNow();
            }
        }

    }

    public static double potenciar(int base, int expoente) {
        return Math.pow(base, 2);
    }

    public static class Tarefa implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            Double nomeAluno = Executors_MultiThreads.potenciar(new Random().nextInt(4), 2);
            return nomeAluno;
        }
    }
}
