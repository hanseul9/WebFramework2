package kr.ac.hansung.cse.animals;

import lombok.Setter;

@Setter
public class Dog implements AnimalType{

    String myName;

    @Override
    public void sound() {
        System.out.println("Dog name  " + myName + ": " + "Bow Wow");
    }


}
