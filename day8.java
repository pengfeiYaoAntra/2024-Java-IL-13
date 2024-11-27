import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *Java reflection
 *allows you to create/change/ modify/access object's behaviour and structure at the runtime environment
 *
 * in java, we have Class class -> belongs to Java.lang.Class
 * every class we defined is  an instance of java.lang.Class class. every object in jvm have Class object
 *
 * where Class object store?
 * the JVM contains many instances, and each class has a unique Class object
 *
 * Do we need to create Class by yourself
 * No, Class object are created automatically by JVM when a class is loaded
 *
 * what  information can we gather from the Class obeject?
 *
 * the class object is used to provide information about the class itself, such as how many constructors
 * how many attributes(fields) it has and how many methods it has
 *
 *getField vs getDeclaredField
 * getField -> can only retrieve public fields, including those inherited from the parent class
 *
 *
 * getDeclaredField
 * can retrieve all fields defined in the current class, including private, but cannot retrieve inherited ones
 * for private one, you have to use serAccessible to true
 *
 *
 * why sue reflection
 * you can get name, package information, attributes, methods, annotations, types, contructors...
 *
 * you can access/modify a lot of properties
 *
 *
 * after you writing a java object, the .java file are compiled to .class file
 *
 * these .class file are loaded into the JVM by class loader during program execution.
 * once a class is loaded, the JVM will automatically create a Class object in memeory
 *
 * using the Class object, you can obtain information about its fields, methods and contrustcor
 *
 * new keyword to create an object, you are using Class object to create.
 *
 *
 */
public class day8 {
    public static void main(String[] args) {
       // Teacher teacher = new Teacher();
        // 3 ways
        String classPath = "Teacher";
        Teacher teacher = new Teacher();
        teacher.setFirstName("Matthew");
        System.out.println(teacher.getFirstName());
        teacher.setSalary(100000.00);

        try{
            // first way and common way
            Class teacher1 = Class.forName(classPath);
//            System.out.println(teacher);
//            //second way
//            Class teacher1 = Teacher.class;
//            System.out.println(teacher == teacher1);
//            //3rd way
//            Class teacher2 = new Teacher().getClass();
//            System.out.println(teacher == teacher2);

            // how to get constructor with java reflection
            // case 1

//            Constructor[] constructors = teacher.getConstructors();
//            for(Constructor c : constructors){
//                System.out.println(c);
//            }
//            System.out.println("***************************************");
//            //case 2
//            Constructor[] constructors1 = teacher.getDeclaredConstructors();
//            for (Constructor c : constructors1){
//                System.out.println(c);
//            }
//            System.out.println("***************************************");
//
//            // case 3 get none param constructor
//            Constructor constructor2 = teacher.getConstructor(null);
//            System.out.println(constructor2);
//            System.out.println("***************************************");
//            // case 4 I want to only get the private one
//            constructor2 = teacher.getDeclaredConstructor(boolean.class);
//            System.out.println(constructor2);

            Field firstName = teacher1.getDeclaredField("firstName");
            firstName.set(teacher, "Will");
            System.out.println(teacher.getFirstName());

            // java reflectiion with private variable

            Field salary = teacher1.getDeclaredField("salary");
            salary.setAccessible(true);// if your variable is private, you have to use this and set it to true
            salary.set(teacher, 99.00);
            System.out.println(teacher.getSalary());


            // get methods
            Method getFirstName = teacher1.getMethod("getFirstName");
            String first_Name = (String) getFirstName.invoke(teacher);
            System.out.println(first_Name);


            Method setFirstName = teacher1.getMethod("setFirstName", String.class);
            setFirstName.invoke(teacher,"Rocky");
            System.out.println(teacher.getFirstName());

            Method getSalary = teacher1.getDeclaredMethod("getSalary");
            getSalary.setAccessible(true);
            double salary_teacher = (double) getSalary.invoke(teacher);
            System.out.println(salary_teacher);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
