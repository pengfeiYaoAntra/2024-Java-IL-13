public class Day1 {
    /**
     * Day 1
     * @param args
     *what is an object in java?
     *  object: 1: state: like your bank account current balance, or integer, string, double,..,
     *       2: behaviors: methods or functions in your object
     * where can we find an object?
     *  heap -> memory
     *  what is OOP?
     *  1: polymorphsim:
     *      a same method/function can performed in a different way
     *      overloading and overriding
     *      overloading(compiletime): the same method name, but different variables: such as the # of variables, the types of variabel
     *                  run(int i), run (double i)
     *      overrding (runtime polymorphsim): it happends in a child class, child class inheritance some parent's features/functions
     *
     *  2: encapsulation: it means protects and manages its own information
     *
     *  3: abstraction: using the abstract keyword and hide some info
     *      interface vs abstraction class
     *
     *   4: inheritance: code reusability.
     *
     *
     *
     *   primitive type vs wrapper type
     *   primitive type:
     *   6 types are number:  byte, short, int:0, 4 byte, long ,float, double
     *   1: boolean -> false, len: 1 bit, 1: char: 2 byte
     *
     *   wrapper type
     *   Integer, Boolean...
     *   why do we need wrapper type?
     *   wrapper type offer more functions that we can directly use.
     *
     *
     *  String vs StringBuilder vs String Buffer
     *  string is immutable class
     *  String Builder and Stringbuffer can be changed
     *  StringBuffer has sync keyword
     *
     *  String str1 = "a"
     *  String str2 = "b"
     *  String full =  str1 + str2; ->  String full =  String (str1) + String(str2)
     *
     *
     *  access modifiers
     *  modifier  class   package  subclass  global
     *  public      yes    yes       yes      yes
     *  protected   yes    yes       yes     No
     *  default      yes   yes        No     No
     *  private      yes   No        NO      No
     *
     *does Java use "pass by value" or "pass by reference"?
     * pass by value
     * int i = 1
     * void changeInt(int a){a = 2}
     * main{
     *
     *      int i = 1 // java just pass value of i -> 1 into changeInt method
     *      changeInt(int a){a = 2}
     *      print(i)-> 1 or 2? -> 1
     *
     *      Car car = new Car("BMW");// java pass value of car object: Ox12345678 into changeCar method
     *      changeCar(Car car1){ car1.setBrand("Toyota")}
     *      print(car.getBrand()) -> BMW : toyota? -> toyota
     *
     *     car1  -> heap [object car: Ox12345678 ] <- car
     *
     *
     * }
     *
     * shallow copy vs deep copy
     *
     * shallow copy: original object and copied object point to the same address
     *
     * deep copy: original object and copied object point to the different address
     *
     * how to implement clone() function in your class -> implements cloneable interface -> override function: clone()
     *
     *
     * static:
     * what does static mean?
     *  static means something (variable, method, blcok and classes) belongs to itself, not an object
     *
     *  non static: belongs to an object
     *
     *  non static variable cannot be accessed within the static class
     *  all static classes are nested classes
     *  static variable cannot be used on local variable
     *  constants are often declared using static
     *  a static method or class is always shared, it may has concurrence problem
     *
     *two types of exceptions
     * checked: happens in compile time
     * unchecked: happens in runtime
     *
     * try catch finally  block -> can try and finally block without catch block?  -> yes
     * throw and throws
     *
     * exception vs error
     * exception is some errors you want to see
     * error is some errors you do not want to see
     *
     * Generic:
     * T - type
     * E - element
     * K - key
     * V - value
     * N - number
     *
     *
     * this vs super
     *
     * how many ways we can use "this" keyword in java
     *  "this" can be used to reference current object
     *  "this" can be used to call constructor
     *  "this" can be used to as parameter
     *  "this" can be used as constructor parameter
     *
     *
     *  super:
     *  call parent's functions: super.clone()
     *  call parent's constructor: super()/ super("name", 122)
     *  call parent's fields
     *  class Animal{
     *      int age;
     *  }
     *  class Dog extends Animal{
     *      int age;
     *      Dog(int superAge, int subAge){
     *          super.age = super.age
     *          this.age = subAge;
     *      }
     *
     *  }
     *
     *
     */
    public static void main(String[] args) {
        // when you compare two value of wrapper type, use equal() , DO NOT USE "=="
        // range for integer wrapper type [-128,127]
        Integer i1 = 12;
        Integer i2 = 12;
        System.out.println(i1 == i2);// true;
        Integer i3 = 222;
        Integer i4 = 222;
        System.out.println(i3 == i4);// false
        //Integer i5 = new Integer(12);
        //System.out.println(i5 == i1); // false
        Student student1 = new Student("asd",18);//
        //student1.out();//null 0
    }


}

abstract class myFirstAbsClass{
    String myName="";// in an abstract class,  public static final  is not default
    void thisIsMethod(){
        System.out.println("Hi, this a method in abstract class");
    }
    abstract void thisIsAbstractMethod();// you donot need method body here in abstract class
}
interface myFirstInterClass{
    public static final String myName="";// in an interface,  public static final is default
     void thisIsMethod();// default is abstract and public, not body needed
    default void thisIsMethodwithBody(){// if you want to have method body, you have to change access modifier from public to default
        System.out.println("Hi, I am a method in interface with body");
    }
    // static method in interface?
    static int add(int a, int b){// after java 8, you can have static keyword in interface class
        return a + b;
    }
    // private
    private int multiply(int a , int b){// yes, but it only happends above java 9
        return a *b;
    }
}
class Student{
    private String name;
    private int age;

    public Student() {
        System.out.println("constructor without values");
    }


    public Student(String name, int age){
        this();
        this.name = name;
        this.age = age;
    }
    void out(){
        System.out.println(name + "  " + age);
    }
}

class ThisAsParameter{
    void method1(ThisAsParameter p){
        System.out.println(p);
    }
    void method2(){// this" can be used to as parameter
        method1(this);
    }
}

class ThisAsConstructorParam{
    int count = 10;
    ThisAsConstructorParam(){
        Data data = new Data(this);
        data.out();
    }
}
class Data{
    ThisAsConstructorParam param;
    Data(ThisAsConstructorParam param){
        this.param = param;
    }
    void out(){
        System.out.println(param.count);
    }
}



