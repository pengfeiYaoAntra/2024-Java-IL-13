import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * java 8 new features
 * functional interface
 * you need to used @functionalInterface annotation to create a functional interface that only has one function
 * example: runnable, callable, Function<>, predicate, consumer, supplier, comparator
 *
 * lambda function
 * () -> System.out.print("Hi")
 * (a) -> System.out.print(a)
 *  (a,b) -> a+b;
 *
 *
 *  stream api
 *
 *  intermediate function:
 *  filter(): select some elements in stream that match your condition
 *  map():  transform elements in the stream to a new type
 *  limit()
 *  skip()
 *  flatmap()
 *  ...
 *  terminal function:
 *  foreach:performs some actions on each elements in stream
 *  reduce:  aggregates all elements in the stream into one result
 *  collect: return
 *  min/ max
 *  count
 *  anymatch, all match, nonmatch()
 *
 *collections vs stream api
 * 1: collections does store data in the memory, stream api just process data and doesn't store data the memory
 * 2: collection can be changed/modified by adding, removing functions, stream api does not change/ modify the original collection
 *
 *optional:
 * why do we use optional?
 * to avoid null pointer exception
 *
 *
 *
 * method reference:
 * syntax: class :: method
 * use it to reference to a static method
 *  class::staticMethod
 *  we can use to reference to a constructor
 *  class::new
 *  we can call a method of an object
 *  object::method
 *
 *  completable future
 *   task1 takes 100 ms
 *   task2 take 100 ms --> at least 300 ms without completable future
 *   task3 take  100 ms --> less than 300 ms with completable future
 *
 *   consumer:  void accept(T t); does not return and take one input
 *   supplier: T get(); does not take input and return result
 *
 *
 *
 *********email me your github link before 1 PM CDT*********
 *
 * solve with stream api
 *  // homework: there are few questions: find the first non-repeated character in a string
 *         // top K frequency words
 *         // Sum of unique elements
 *
 *
 *
 */
public class Day3 {

    public static void main(String[] args) {
        MyFirstFunctionalInterface cal = (a,b) -> a+b;
        int result = cal.add(1,2);
        System.out.println(result);// 3


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this way to create a thread before java 8");
            }
        });
        // java 8
        new Thread(()-> System.out.println("this is after java 8")).start();

// max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);

        List<String> list1 = Arrays.asList("a1","a2","b1","c1","c3","c2");
        list1.stream()
                .filter(s->s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        // find string that has lower case and print it
        List<String> list2 = Arrays.asList("This","IS","A","STRiNG");
        List<String> list3 = list2.stream()
                .filter(s->s.chars().anyMatch(Character::isLowerCase))
                .collect(Collectors.toList());
        list2.stream()
                .filter(s->s.chars().anyMatch(Character::isLowerCase))
                .forEach(System.out::println);


        // you need to find all even number and sum  them
        List<Integer> list4 = Arrays.asList(1,2,3,4,5,6,7,22,33,44,55);
        int sum = list4.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println(sum);



        // find the longest string in the list and using lambda function
        List<String> words = Arrays.asList("cat","dog", "elephant", "giraffe");
        String word = words.stream().reduce((a,b) -> a.length() > b.length() ? a: b).orElse("");
        System.out.println(word);

        // count the frequency of each character in a string
        String input = "hello world";
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .filter((c-> c!=' ')).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencyMap);

        BankAccount bankAccount1 = new BankAccount("12345", 1000.0, Optional.empty());
        BankAccount bankAccount2 = new BankAccount("3546", 234.1, Optional.of("my password"));

        Optional<String> password2 = bankAccount2.getPassword();
        if(password2.isPresent()){
            System.out.println(password2.get());
        }

        Optional<String> password1 = bankAccount1.getPassword();
        if(password1.isEmpty()){
            System.out.println("no password");
        }

    }




}
class BankAccount{
    private String accountNumber;
    private double balance;
    private Optional<String> password;
    public BankAccount(String accountNumber, double balance, Optional<String> password){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    //getters and setters


    public Optional<String> getPassword(){
        return password;
    }
}