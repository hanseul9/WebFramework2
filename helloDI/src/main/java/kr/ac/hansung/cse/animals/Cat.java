package kr.ac.hansung.cse.animals;

import lombok.Setter;

@Setter
public class Cat implements AnimalType {

    String myName;

    @Override
    public void sound() {
        System.out.println("Cat name  " + myName + ": " + "Meow!");
    }
}
