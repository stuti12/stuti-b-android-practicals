package com.example.myapplication.javakotlinpractical;

public class ExceptionHandle {

    public static void main(String[] args) {
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }

    }
}

class TestThrow1 {
        //function to check if person is eligible to vote or not
        public static void validate(int age) throws ArithmeticException {
            if(age<18) {
                //throw Arithmetic exception if not eligible to vote
                throw new ArithmeticException("Person is not eligible to vote");
            }
            else {
                System.out.println("Person is eligible to vote!!");
            }
        }
        //main method
        public static void main(String args[]) {
            //calling the function
            validate(13);
            System.out.println("rest of the code...");
        }
}