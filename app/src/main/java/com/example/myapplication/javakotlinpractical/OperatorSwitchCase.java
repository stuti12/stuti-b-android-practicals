package com.example.myapplication.javakotlinpractical;

// Java program for simple calculator

import java.io.*;
import java.lang.*;
import java.lang.Math;
import java.util.Scanner;
class BasicCalculator {

    public static void main(String[] args)
    {
        // stores two numbers
        double num1=10.0, num2=2.0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the numbers");

        num1 = sc.nextDouble();
        num2 = sc.nextDouble();

        System.out.println("Enter the operator (+,-,*,/)");
        char op = sc.next().charAt(0);
        double o = 0;

        switch (op) {

            // case to add two numbers
            case '+':

                o = num1 + num2;
                break;

            // case to subtract two numbers
            case '-':
                o = num1 - num2;
                break;

            // case to multiply two numbers
            case '*':
                o = num1 * num2;
                break;
            // case to divide two numbers
            case '/':
                o = num1 / num2;
                break;

            default:
                System.out.println("You enter wrong input");
                break;
        }

        System.out.println("The final result:");

        System.out.println();

        // print the final result
        System.out.println(num1 + " " + op + " " + num2 + " = " + o);

        System.out.println("Shift operator");
        System.out.println(10<<2);//10*2^2=10*4=40
        System.out.println(10<<3);//10*2^3=10*8=80

        int a=10;
        int b=5;
        int c=20;

        System.out.println("Bitwise and logical &");
        System.out.println(a<b&&a<c);//false && true = false
        System.out.println(a<b&a<c);//false & true = false
    }
}

