import java.util.*;

/**
 * Day 2 collections in java
 * random access: support fast random access and retrieve and element in the collection at the same speed
 *
 * resize:
 * new capacity = old capacity * 1.5
 * old capacity >> 1 = 0010: 2 >> 0001: 1
 *
 * Arraylist<Integer> list = new ArrayList<>() -> at this moment, the capacity is 0
 *  list.add(1);
 *  .... list.add(11)
 *
 *  time complexity:
 *  add: O(1): O(N)
 *  add(index, element): O(N)
 *  get(): always O(1)
 *  remove() O(N)
 *  indexOf() O(N)
 *  contains() O(N)
 *
 *  stack + vector: first in and last out data structure
 *  they are thread safe
 *  capacityIncrement > 0 ? capacityIncrement : new Capacity -> old capacity = old capacity + capacity increment (if this is provided)
 *      if capacity increment is not provided, then new capacity = 2 * old capacity
 *      time complexity: stack: push O(1), pop O(1) size()O(1)
 *                      vector: add           remove       size
 *
 *  when you should use arraylist, when your system has a lot of operation: adding, accessing, please consider array list
 *  when you should use stack and vector: when your system has a lot of threads
 *
 *  linkedlist + deque
 *
 *  double linked list and not thread safe and does not support random access.
 *  add()
 *  offer() -> different between offer and add function? ->
 *     public boolean offer(E e) {
 *         return add(e);
 *     }
 *
 *     void linkLast(E e) {
 *         final Node<E> l = last;// current last node/element ->
 *         final Node<E> newNode = new Node<>(l, e, null);// create new last node: prev pointer points to current last, next pointer points to null
 *         last = newNode;// last -> new last node/element = new last / newNode
 *         if (l == null)// when there is not elements in your linked list: size of linked list is zero
 *             first = newNode;
 *         else
 *             l.next = newNode; // current last node/ element points to new node/ elememnt
 *         size++;
 *         modCount++;
 *     }
 *
 *     time complexity:
 *     add(): O(1)
 *     add(index,element):O(N)
 *     get(): O(N)
 *     remove(): O(N)
 *
 *
 *     deque:
 *     leetcode: create stack without using stack data strucuture
 *     double ended queue, you can have FIFO(first in first out) and FILO(firs in last out)::
 *
 *
 *  how does java implement priorityqueue? using array or tree?
 *   0
 *   /\
 *   1 2
 *   /\ /\
 *   34 56
 *   leftNode index = parentnode index * 2 + 1
 *   right node index = parent node index * 2 + 2
 *   parent node index = (node index - 1) / 2
 *
 *
 * do leetcode question: can you get top 5/10/2 element
 *
 * Hashmap
 * not thread safe
 * your hashmap -> [[tab1][tab2],.....[tab]..[tab16]]
 *                    \
 *                     node1
 *                     \
 *                     node2
 *                     .. node8 <- node9  ->change linked list to red- black tree
 *  when does hashmap change linked lis to red black tree
 *  when there is 8 elements in one table TREEIFY_THRESHOLD = 8;
 *  when does hashmap change red-black tree to linked list
 *  when there is 6 elements in one table: UNTREEIFY_THRESHOLD = 6;
 *
 *      static final int hash(Object key) {
 *         int h;
 *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *     }
 *
 *     h = key.hashcode(): 1111 1111 1111 1111 1111 0000 1110 1010
 *               h >>> 16: 0000 0000 0000 0000 1111 1111 1111 1111
 *
 *  (h) ^ (h >>> 16)     : 1111 1111 1111 1111 0000 1111 0001 0101 -> this value will be used somewhere else
 *  n-1                    0000 0000 0000 0000 0000 0000 0000 1111
 *  (n-1) & hash         : 1111 1111 1111 1111 0000 1111 0001 0101 -> 0101 = 5 -> table at index = 1
 *
 *
 *the process of putval
 * 1: calculating hash value and find the index where we should put
 * 2: if there is  null (no hash collision) then hashmap stores it
 * 3: if there exits hash collision (not null) then hashmap do the following steps:
 *  3.1: if hashmap is using red-black tree, then call tree insertion method to put value
 *  3.2 if not tree, then put the value. after inserting value, hashmap will check the len of linked list
 *      if the len of linked list is > 8. then change to tree
 *  4: if there exits duplicate key, then replace the value
 *  5: check the size, if the size > threshold, then resizing
 *
 *insert, delete, search in the best case: O(1)
 *                          in worst case: O(n)
 *
 *
 * treemap
 *
 * hashset ->
 *hash set vs treeset
 * O(1)     O(logn)
 * arbitrary  sorted
 * yes for null   no for null
 * 
 *
 *

 *
 *
 *
 *
 *
 */
public class Day2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // make array list to sync array list
        List<String> sync_list = Collections.synchronizedList(list);

        Deque<String> myDeque = new LinkedList<>();
        myDeque.addFirst("apple");
        myDeque.addLast("banana");
    }
}
