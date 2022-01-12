package com.example.myapplication.javakotlinpractical;

abstract class Shape{
    abstract void draw();
}

class Rectangle extends Shape{
    void draw(){System.out.println("drawing rectangle");}
}

class Circle extends Shape{
    void draw(){System.out.println("drawing circle");}
}
//In real scenario, method is called by programmer or user
class TestAbstraction1{
    public static void main(String args[]){
        Shape s=new Circle();//In a real scenario, object is provided through method, e.g., getShape() method
        s.draw();
    }
}

interface Drawable{
    void draw();
}
//Implementation: by second user
class Rectangles implements Drawable {
    public void draw() {
        System.out.println("drawing rectangle");}
}

class Circles implements Drawable {
    public void draw() {
        System.out.println("drawing circle");}
}
//Using interface: by third user
class TestInterface1 {
    public static void main(String args[]) {
        Drawable d=new Circles();//In real scenario, object is provided by method e.g. getDrawable()
        d.draw();
    }
}