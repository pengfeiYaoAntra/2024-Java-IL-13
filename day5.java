import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS in java
 * what is CAS
 * CAS stands for compare ans set(swap)
 * what is atomic operation
 * it is an unit of operation always execute together or none of the executes
 *
 * {
 *     int a = getValueFromSomewhereelese()
 *     int b = getValueFromSomewhereelese()
 *     int c = a + b
 * }
 * in CAS:
 * memory location (V): this address of the variable to update
 * expected old value (A): the value that is need to be expected
 * new value (B): the value to be written to the variable
 * CAS: if the current value of variable matches (read it from memory location V) with the expected old value (B), then update the
 * variable to B, otherwise, does not update it.
 *
 * ABA problem
 * ----------------------------time line------------------------------------
 * --thread 1 get the value: A at the time 1-----------------------------------------------------------------------------thread 1 is finished BL and update the value from A to D----------
 * -------thread 2 get the value: A the time 2--thread 2: update the value to C--- thread 2 update value from C to A and thread 2 is finished-------------
 *
 * AtomicStampedReference - > sovle ABA problem
 *
 * concurrent hashmap ->
 * we could not have null value as key and value, we will receive null pointer exception
 * in putVal() we have synchronized block for linkedlist and tree insertion
 * not all methods are synchronized, like get() function does not have synchronized keyword
 *
 * blocking queue:
 * thread safe jave collection
 * and used by producer consumer model
 * producers
 *  thread 1 producer 1 --->                     ---> consumer 1 thread 4
 *  thread 2 producer 2 ---> [blocking queue]      >consumer 2 thread 5
 *  thread 3 producer 3 --->                    --->consumer 3 thread 6
 *
 *  in blocking queue
 *  take index pointer: take values from queue at index x
 *  put index pointer: put values at index x
 *
 * the drawbacks of synchronized keyword ->
 * decreased performance:
 * deadlock: if two or more threads are waiting for each other to release a lock, then deadlock can occur.
 * thread A holding resouces A and wait resource B to released
 * thread B holding resource B and wait resource A to released. -> dead lock
 *
 *
 * pessimistic locker: only one thread can have shared resource(read, modify)
 *
 * optimistic locker: only one thread can modify, can have multiple thread to read. ->
 *
 *
 * thread pool
 * what is thread pool
 * thread pool is pre-defined thread that are available to perform a set of works
 * your system does not need to delete and create threads
 *
 * executor:
 * we only have one method in this interface, used to execute runnable task asynchronously on a new thread
 *
 * executor service: is used to manage tasks
 *
 * executors: create thread pool
 *
 *
 * in java we have
 * fixed thread pool: the number of threads in this pool are fixed
 *
 * cached thread pool: unlimited threads in this pool. if a thread is idle for some time, thread pool will terminate this idle thread
 *  if you have a lot of idle threads in your system, you will have a negative impact on performance
 *
 *  single-thread pool:
 *      only one thread
 *  fork - join thread pool:
 *   is  used for dividing large tasks into smaller sub-tasks that can be executed in parallel.
 *      in the fork-join pool, it uses work-stealing pool
 *
 */
public class day5 {
    public static void main(String[] args) {
//        AtomicInteger atomicInteger  = new AtomicInteger(0);// assume this value is V
//        int expectedValue = 0;
//        int newValue = 3;
//        System.out.println("result is: " + atomicInteger.compareAndSet(expectedValue,newValue));
//        AtomicInteger atomicInteger1  = new AtomicInteger(0);// assume this value is V
//        int expectedValue1 = 3;
//        int newValue1 = 5;
//        System.out.println("result is: " + atomicInteger1.compareAndSet(expectedValue1,newValue1));

        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread producerThread = new Thread(()->{
            try{
                producerConsumer.produce();
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        });
        Thread consumerThread = new Thread(()->{
            try{
                producerConsumer.consumer();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        producerThread.start();
        consumerThread.start();

    }
}

class ProducerConsumer{
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() throws InterruptedException{
        int value = 0;
        while(true){
            System.out.println("current value is " + value);
            queue.put(value++);
        }
    }

    public void consumer() throws InterruptedException{
        while (true){
            if(queue.size() == 10){
                int value = queue.take();
                System.out.println("consumed: " + value);
                Thread.sleep(1000);
            }
        }
    }
}
