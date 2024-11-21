import java.util.concurrent.*;

public class comFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
//        try{
//            //task 1
//            TimeUnit.MILLISECONDS.sleep(100);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        try{
//            //task 2
//            TimeUnit.MILLISECONDS.sleep(100);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        try{
//            //task 3
//            TimeUnit.MILLISECONDS.sleep(100);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

//        FutureTask<String> task1 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(100);
//
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 1";
//        });
//        Thread thread1 = new Thread(task1, "thread 1"); //  java create,
//        thread1.start();
//        FutureTask<String> task2 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(100);
//
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 2";
//        });
//        Thread thread2 = new Thread(task2, "thread 2");
//        thread2.start();
//        FutureTask<String> task3 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(100);
//
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 3";
//        });
//        Thread thread3 = new Thread(task3, "thread 3");
//        thread3.start();

        // thread pool here -> fixed thread pool -> 3
//        ExecutorService threadpool = Executors.newFixedThreadPool(3);
//        FutureTask<String> task1 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(100);
//
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 1";
//        });
//        threadpool.submit(task1);
//        FutureTask<String> task2 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(100);
//
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 2";
//        });
//        threadpool.submit(task2);
//        FutureTask<String> task3 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(100);
//
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 3";
//        });
//        threadpool.submit(task3);
//        try{
//            task1.get();
//            task2.get();
//            task3.get();
//        }catch (InterruptedException | ExecutionException e){
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("total time is :  " + (end - start));
//    threadpool.shutdown();
        // no thread pool for run Async
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        });
        System.out.println(completableFuture1.get());

        // thread pool for run Async

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName() + "this is a fixed thread pool");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }, executorService);
        System.out.println(completableFuture2.get());
        executorService.shutdown();

        // supply async
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "this is a fixed thread pool");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "Hello";
        });

        System.out.println(completableFuture3.get());


        // functions
    }
}
