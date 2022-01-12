package com.example.myapplication.javakotlinpractical;
//single
class Employee{
    float salary=40000;
}
class Programmer extends Employee{
    int bonus=10000;
    public static void main(String args[]){
        Programmer p=new Programmer();
        System.out.println("Programmer salary is:"+p.salary);
        System.out.println("Bonus of Programmer is:"+p.bonus);
    }
}

//multi-level
class Animal{
    void eat(){System.out.println("eating...");}
}
class Dog extends Animal{
    void bark(){System.out.println("barking...");}
}
class BabyDog extends Dog{
    void weep(){System.out.println("weeping...");}
}
class TestInheritance2{
    public static void main(String args[]){
        BabyDog d=new BabyDog();
        d.weep();
        d.bark();
        d.eat();
    }
}

//hirerchical
class Animals{
    void eats(){System.out.println("eating...");}
}
class Dogs extends Animals{
    void barks(){System.out.println("barking...");}
}
class Cats extends Animals{
    void meows(){System.out.println("meowing...");}
}
class TestInheritance3{
    public static void main(String args[]){
        Cats c=new Cats();
        c.meows();
        c.eats();
    }
}