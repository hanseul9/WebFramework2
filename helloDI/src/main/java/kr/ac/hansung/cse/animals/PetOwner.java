package kr.ac.hansung.cse.animals;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@AllArgsConstructor //생성자 만들어줌
public class PetOwner {

    @Autowired // string by type
    @Qualifier("qf_cat")
    public AnimalType animal;

//    public PetOwner(AnimalType animal) {
//        this.animal = animal;
//    }

    public void play() {
        animal.sound();
    }
}
