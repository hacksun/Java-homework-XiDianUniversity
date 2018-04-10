/*
sunhui
15130120141
*/

import java.util.*;

class Student{
    private String Sid = "15130120141";
    String goal;

    Student(){
		System.out.println("");

    }

    Student(String Sid){

        System.out.println("PLEASE INPUT THE STUDENT'S SELECTED COURSES!");
    }

    Student(String Sid, String CourseName){
        this.Sid=Sid;
        Course ex = new Course(CourseName);
        goal = Sid + " select " + ex.getCourseName()+" .";
    }

    Student(String Sid, String CourseName1, String CourseName2){
        this.Sid=Sid;
        Course ex1 = new Course(CourseName1);
        Course ex2 = new Course(CourseName2);
        goal = Sid + " select " + ex1.getCourseName() + "; and " + ex2.getCourseName()+" .";
    }
    public String getSid(){
        return goal;
    }
}

class Course{
    private String CourseName;

    public Course(String name){
        Book ex = new Book(name);
        this.CourseName = name + " with "+ex.getBook();

    }

    public String getCourseName(){
        return this.CourseName;
    }
}

class Book{
    private String BookName;
    String Java[] = {"Thinking in Java","Java 8"};
    String Math[] ={"Advanced Mathematics","Math"};
    String WebEngineering[] ={"Web Engineering"};

    public Book(String name){
        if(name.equals("Java")){
            for(int i=0; i<Java.length;i++){
                BookName = Java[i]+BookName;
                if(i>=0&&i<Java.length-1){
                    BookName = ","+BookName;
                }
            }
            BookName = "books "+BookName;
        }

        if(name.equals("Math")){
            for(int i=0; i<Math.length;i++){
                BookName = Math[i]+BookName;
                if(i>=0&&i<Math.length-1){
                    BookName = ","+BookName;
                }
            }
            BookName = "books "+BookName;
        }

        if(name.equals("WebEngineering")){
            for(int i=0; i<WebEngineering.length;i++){
                BookName = WebEngineering[i]+BookName;
                if(i>=0&&i<WebEngineering.length-1){
                    BookName = ","+BookName;
                }
            }
            BookName = "books "+BookName;
        }
    }
    public String getBook(){
        return BookName;
    }

}

public class CRS{
    public static void main (String[] args){
        if(args.length==0){
            Student ex1 = new Student();
            System.out.println(ex1.getSid());
        }else if(args.length==2){
            Student ex2 = new Student(args[0],args[1]);
            System.out.println(ex2.getSid());
        }else if(args.length==3){
            Student ex3 = new Student(args[0],args[1],args[2]);
            System.out.println(ex3.getSid());
        }else{
            System.out.println("IT'S INPOSSIBLE!");
        }
    }
}