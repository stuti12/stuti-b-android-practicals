package com.example.myapplication.javakotlinpractical;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Collection {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);

        System.out.println("Linklist");
        LinkedList<String> cars1 = new LinkedList<String>();
        cars1.add("Volvo");
        cars1.add("BMW");
        cars1.add("Ford");
        cars1.add("Mazda");
        System.out.println(cars1);

        System.out.println("Hashmap");

        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
    }
}