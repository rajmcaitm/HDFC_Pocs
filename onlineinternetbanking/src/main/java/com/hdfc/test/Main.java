package com.hdfc.test;

public class Main implements DefaultStaticExampleInterface {
  public static void main(String args[]) {
      // Call interface static method on Interface
      DefaultStaticExampleInterface.display();
      //DefaultStaticExampleClass defaultStaticExampleClass = new DefaultStaticExampleClass();
     Main test = new Main();
      // Call default method on Class
      test.show();
   }
}