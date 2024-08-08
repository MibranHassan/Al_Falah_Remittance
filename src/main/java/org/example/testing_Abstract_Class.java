package org.example;

abstract class ABstract_Class {
    public abstract void abstract_function();
}

public class testing_Abstract_Class extends ABstract_Class{

    @Override
    public void abstract_function() {
        System.out.println("Implemented Abstract Function");
    }

    public static void main(String[] args) {
        testing_Abstract_Class testAbs = new testing_Abstract_Class();
        testAbs.abstract_function();
    }
}
