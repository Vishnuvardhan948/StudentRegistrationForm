import java.util.*;
abstract class Person{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public abstract void displayRole();
}

interface Printable{
    void printDetails();
}

class Student extends Person implements Printable{
    int rollNo;
    String course;
    int[] marks;
    double average;
    char grade;

    public Student(String name,int age,int rollNo,String course,int[] marks){
        super(name,age);
        this.rollNo=rollNo;
        this.course=course;
        this.marks=marks;
        calculateResult();
    }

    public void calculateResult(){
        int total=0;
        for (int i=0;i< marks.length;i++) {
            total += marks[i];
        }
        average= total /marks.length;

        if(average>=90)
            grade='A';
        else if(average>=75)
            grade='B';
        else if(average>=50)
            grade='C';
        else
            grade='D';
    }

    @Override
    public void printDetails() {
        System.out.println("Student Name: "+getName());
        System.out.println("Student Age: "+getAge());
        System.out.println("Student RollNo: "+rollNo);
        System.out.println("Student Course: "+course);
        System.out.println("Student Average: "+average);
        System.out.println("Student Grade: "+grade);
    }

    @Override
    public void displayRole() {
        System.out.println("Role : Student");
    }
}

class DayScholar extends Student{
    String transportMode;

    public DayScholar(String name,int age,int rollNo,String course,int[] marks,String transportMode){
        super(name,age,rollNo,course,marks);
        this.transportMode=transportMode;
    }

    @Override
    public void displayRole() {
        System.out.println("Role : DayScholar");
    }

    @Override
    public void printDetails() {
        displayRole();
        super.printDetails();
        System.out.println("TransportMode : "+transportMode);
    }
}

class Hosteler extends Student{
    String hostelName;
    int roomNo;
    public Hosteler(String name,int age,int rollNo,String course,int[] marks,String hostelName,int roomNo){
        super(name,age,rollNo,course,marks);
        this.hostelName=hostelName;
        this.roomNo=roomNo;
    }

    @Override
    public void displayRole() {
        System.out.println("Role : Hosteler");
    }

    @Override
    public void printDetails() {
        displayRole();
        super.printDetails();
        System.out.println("Hostel Name : "+hostelName);
        System.out.println("Room No : "+roomNo);
    }
}

class StudentManagementSystem{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students=new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Day Scholar\n2. Add Hosteler\n3. Display All Students\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter Name: ");
                String name = sc.next();

                System.out.println("Enter Age: ");
                int age = sc.nextInt();

                System.out.println("Enter Roll No: ");
                int rollNo = sc.nextInt();

                System.out.println("Enter Course: ");
                String course = sc.next();

                System.out.println("Enter no of marks:");
                int n = sc.nextInt();
                int[] marks = new int[n];

                System.out.println("Enter Marks: ");
                for (int i = 0; i < n; i++) {
                    marks[i] = sc.nextInt();
                }

                System.out.println("Enter Transport Mode: ");
                String transportMode = sc.next();

                students.add(new DayScholar(name, age, rollNo, course, marks, transportMode));
                System.out.println("Day Scholar added successfully!");
            }

            else if (choice == 2) {
                System.out.println("Enter Name: ");
                String name = sc.next();

                System.out.println("Enter Age: ");
                int age = sc.nextInt();

                System.out.println("Enter Roll No: ");
                int rollNo = sc.nextInt();

                System.out.println("Enter Course: ");
                String course = sc.next();

                System.out.println("Enter no of marks:");
                int n = sc.nextInt();
                int[] marks = new int[n];

                System.out.println("Enter Marks: ");
                for (int i = 0; i < n; i++) {
                    marks[i] = sc.nextInt();
                }

                System.out.println("Enter Hostel Name: ");
                String hostelName = sc.next();

                System.out.println("Enter Room No: ");
                int roomNo = sc.nextInt();

                students.add(new Hosteler(name, age, rollNo, course, marks, hostelName, roomNo));
                System.out.println("Hosteler added successfully!");
            }

            else if (choice == 3) {
                System.out.println("--- Displaying All Students ---");

                for (int i=0;i<students.size();i++) {
                    students.get(i).printDetails();
                }
            }

            else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }
    }
}