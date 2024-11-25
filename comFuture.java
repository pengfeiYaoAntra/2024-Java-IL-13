import java.util.concurrent.*;

/**
 * get vs getnow vs join
 * getNow(): you need an immediate fallback
 * get: you have to wait task(s) to finish, you need to handle exception
 * join: you have to wait task(s) to finish, you DO NOT need to handle exception
 *
 *
 *task A and task B
 * thenRun(): to do task B regardless task A computation's result
 * thenAccept(): to do task B when finish task A, add task B needs the result of A, but no need to return value after task B finish
 * thenApply(): has return, task B depends on task A
 *
 *
 * thencompose
 * whencomplete
 * thenCombine
 *
 * in real project
 * we don't use Executors to create thread pool
 *
 *
 */
public class comFuture {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
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
//        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//
//        });
//        System.out.println(completableFuture1.get());
//
//        // thread pool for run Async
//
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName() + "this is a fixed thread pool");
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//
//        }, executorService);
//        System.out.println(completableFuture2.get());
//        executorService.shutdown();
//
//        // supply async
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "this is a fixed thread pool");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "Hello";
        });

        System.out.println(completableFuture3.join());


        // functions

//        public T join() {
//            Object r;
//            if ((r = result) == null)
//                r = waitingGet(false);
//            return (T) reportJoin(r);
//        }
//        public T get() throws InterruptedException, ExecutionException {
//            Object r;
//            if ((r = result) == null)
//                r = waitingGet(true);
//            return (T) reportGet(r);
//        }
//        public T getNow(T valueIfAbsent) {
//            Object r;
//            return ((r = result) == null) ? valueIfAbsent : (T) reportJoin(r);
//        }


        CompletableFuture<String> getNowFunctionTest=  CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "finish getNow task";
        });
        System.out.println(getNowFunctionTest.getNow("This is getNow default value"));


        // assume we are sending an email to someone, someone will receive it and process it
        CompletableFuture<Integer> emailtasks = CompletableFuture.supplyAsync(()->{
            // task A is send an email to someone
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("step 1: email is sending");
            return 1;
        }).thenApply(r ->{
            System.out.println("step 2: receiving an email");
            return 1 + r;
        }).thenApply( r ->{
            System.out.println("step 3: processing an email");
            return 1 + r;
        });
        System.out.println("final result: " + emailtasks.join());


        CompletableFuture<Void> thenRunTest = CompletableFuture.supplyAsync(()->{
           try{
               TimeUnit.SECONDS.sleep(1);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
            System.out.println("task 1: doing something here");
           return 1;
        }).thenRun(()->{
            System.out.println("task 2 doing something here");
        });

        thenRunTest.join();
        CompletableFuture<Void> thenAcceptTask = CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("task 1: doing something here");
            return 1;
        }).thenAccept(result ->{
            System.out.println("task 2: printing my result from task 1: " + result);
        });
        thenAcceptTask.join();

         CompletableFuture<String> exceptionTask = CompletableFuture.supplyAsync(()->{
             try{
                 TimeUnit.SECONDS.sleep(1);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
             int i = 5;
             if(i > 3){
                 int a =  i / 0;
             }
             return "hello";
         }).exceptionally(e->{
             e.printStackTrace();
             System.out.println("exception happens here");
             return null;
         });
         exceptionTask.join();
    }
}
