package proba.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Java Generics Interview Questions (+Answers)
 * https://www.baeldung.com/java-generics-interview-questions
 */

class Animal
{
}

class Cat extends Animal
{
}

class Dog extends Animal
{
}

class Farm
{
  private List<Animal> animals;

//  public void addAnimals(Collection<Animal> newAnimals)
  public void addAnimals(Collection<? extends Animal> newAnimals) // OK
//  public void addAnimals(Collection<? super Animal> newAnimals) // NOK
  {
    // newAnimals.add( new Cat()); // capture of "? extends Animal" required, provided "Cat"
    animals.addAll(newAnimals);
  }
}

public class Wildcard
{
  public static void main(String[] args)
  {
    Cat cat = new Cat();
    Dog dog = new Dog();

    List<Object> objects = new ArrayList<>();
    List<Cat>    cats    = new ArrayList<>();
    List<Dog>    dogs    = new ArrayList<>();


    Farm farm = new Farm();

//    farm.addAnimals( objects); // if ^ OK -> this is NOK (and vice versa)
    farm.addAnimals( cats);
    farm.addAnimals( dogs);
  }
}