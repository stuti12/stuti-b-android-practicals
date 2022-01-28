package com.example.myapplication.javakotlinpractical;

public class FlowControl {
    public static void main(String arg[]) {
        //ifelse ladder
        int time = 22;
        if (time < 10) {
            System.out.println("Good morning.");
        } else if (time < 20) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        int i = 0;
        //while
        while (i < 5) {
            System.out.println(i);
            i++;
        }
        //for loop
        for (int j = 0; j <= 10; j = j + 2) {
            System.out.println(j);
        }
        //int i = 0;
        while (i < 10) {
            if (i == 4) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}


