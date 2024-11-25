/**
 * step 1: [System.out.println("hello word");] ->
 * step 2: Java complier -> complies my code into bytecode and generate .class file
 * step 3: JVM[class loader, runtime data areas, execution engine ]
 * step 4: machine code
 * final step: hello word
 * class loader: after you compile .java file, you will receive the  .class file, and class load will load .class file into memoey areas
 *
 * execution engine: will execute your bytecode
 *
 * runtime data areas: this is a memory that contains bytecode, objects, variables, return values, class info and method info
 *
 * runtime data areas
 * 1: *memory area: store class and method data, this is shared
 * 2: ****heap:100% objects are stored here, this is shared
 * 3: **stack:  method arguments, return value, local variable... this is not shared
 *
 * heap ->
 *  1: young generation: 99.9999999999999% (all) new created objects are stored here
 *      eden space: all new created objects are stored here
 *      survivor space: S0, S1, we have two spaces here, after few GC, all objects are moved to here
 *
 *
 *  2: old generation: after few more GC, all objects moved from young generation to this space
 *
 *  3: metaspace: class definitions, method definitions....
 *
 *
 * the referencing counting method ->
 * objA.instance = objB
 * objB.instance = objA
 * objA = null
 * objB = null
 *
 * GC roots method(we are using this)
 *              GC roots
 *              /\/\/\/\
 *          local variables, method parameters
 *          /\
 *          thread stack, classes, class loader
 *
 *
 *  garbage collection algorithm
 *  STW: stop the world -> your system/application need to be stopped for marking phase
 *
 *  GC algorithm:
 *  1: normal deletion
 *      [[object],[object],[object],[object],[object],[object],[][][][]] -> delete ->  [[object],[],[object],[],[],[object],[][][][]]
 *      if you want to create a big object takes 6 spaces
 *  2:normal deletion - mark and sweep
 *   [[object],[object],[object],[object],[object],[object],[][][][]] -> delete ->  [[object],[],[object],[],[],[object],[][][][]]
 *   --> sweep --->[[object],[object],[object],[][][][][][][]]
 *  if you want to create a big object takes 6 spaces -> [[object],[object],[object],[][ big object takes 6 spaces]]
 *
 *  3: concurrent mark and sweep
 *      initial mark: (STW) gc will find  objects that can be reached directly from GC roots
 *      concurrent mark and sweep: (no STW) your application is running at the same time. GC will mark all objects that can be reached from GC roots
 *      remark: (STW)during step 2, there arr some object could be dead. (GC couldn't reach from GC root)
 *      concurrent sweep: sweeping phase, make all object together.
 *      concurrent reset: reset your algorithm
 *
 *      G1(optional)
 *
 *
 *
 *  thread
 *
 *  how many ways we can create a thread?
 *  in total, we have three ways
 *  1: we can extend Thread class
 *  2: we can implement runnable
 *  3: we can implement callable
 *
 *  what are thread states?
 *  6 states:
 *      1: new: create, but not start yet
 *      2: runnable: using so far
 *      3: blocked: our thread is blocked for monitor lock (synchronized keyword)
 *      4: waiting: thread is waiting due to some methods is calling: join wait()
 *      5: timed-waiting: a thread is waiting with a specified waiting time
 *      6: terminated: thread is finished.
 *      NEW A thread that has not yet started is in this state.
     * RUNNABLE A thread executing in the Java virtual machine is in this state.
     * BLOCKED A thread that is blocked waiting for a monitor lock is in this state.
     * WAITING A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
     * TIMED_WAITING A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
     * TERMINATED A thread that has exited is in this state.
 *
 * wait() vs sleep()
 * wait(): a thread will give up its hold on a shared resources, you can call notify or notifyAll() to wake up wait thread
 *
 * sleep(): a thread is suspend, it does NOT release shared resources(CPU)
 *
 *
 * run() vs start()
 *
 * 1:run method will not create a new thread to execute your code, however, start) will create a new thread to execute your code
 * 2: you can call run() function as much as you want, but you only could call start() function one time(bc, start function change
 *          thread state from new to runnable).
 if (threadStatus != 0)
 *         3: with run() function, your code will be executed immediately, start() function will wait CPU resources.
 *
 *
 *
 *
 *
 *
 *  *************volatile********************
 *
 *  what volatile?
 *  when you use volatile keyword for your resources(variable): this resources can be seen by other thread(read, update)
 *
 *                  thread A                                        thread B
 *                  |                                                   |
 *                  shared resource(replica) ----- local memory  ------shared resource(replica)
 *                  |                                                   |
 *                  | --------- -------------JMM-----------------------|
 *                  |--------------   this is your main memory------------|
 *                  |                shared resources                       |
 *                  __________________________________________________________
 *                  JMM will help us to manange the communication between different threads
 *                  all operations on shared variable must be performed in its local memory, you cannot
 *                  directly read from the main memory
 *
 *
 *
 */
public class Day4 {
    public static void main(String[] args) {
        System.out.println("hello word");
        // how many thread(s) we are using now
//        Thread.run();// why is 1 for run() function: we are using main thread here
//        thread.start();// we are using main thread and one thread create by start() function = 2
    }
}
