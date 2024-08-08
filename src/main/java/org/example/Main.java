package org.example;

import java.time.LocalDate;

// Inheritance
// Encapsulation
// Polymorphism
// Abstraction
public class Main extends test{
//Constructor
    public Main(){
        System.out.println("This is Main Class");
    }

    //Overridding BAHL Class Method
    public void Total_Branches(){
        System.out.println("Total branches are 1000");
    }
    public static void main(String[] args) {

        Main demo = new Main();

        System.out.println(demo.name);
        System.out.println(demo.Bank_Name);

        //Overriding method declaration
       demo.Total_Branches();
        //Overloading method declaration
        int result = demo.add(2,2);
        System.out.println("First Method call of test class & result is"+" "+result);
        int result1 = demo.add(2,2,3);
        System.out.println("Second Method call of test class & result is"+" "+result);

        // Date
        LocalDate date = LocalDate.now();
        System.out.println(date);

    }
}