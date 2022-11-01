package com.demo;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Injector;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

interface Animal{
    String sayHi();
}

final class Cat implements Animal{
    @Inject Cat(){}

    @Override
    public  String sayHi(){ return "喵喵喵~";}
    public static Cat create(){
        return  new Cat();
    }
}

final class Dog implements Animal{
    @Inject  Dog(){}

    @Override
    public  String sayHi(){ return "旺旺旺~";}
    public static Dog create(){
        return  new Dog();
    }
}


final class MyPet{
    private final Animal animal;
    @Inject
    MyPet(@PetDog Animal animal){
        this.animal=animal;
    }
    public Animal getAnimal(){
        return  animal;
    }
}

final class AnModule extends AbstractModule {
    @Provides
    @PetCat
    Animal provideAnimalCat(){
        return Cat.create();
    }

    @Provides
    @PetDog
    Animal provideAnimalDog(){
        return Dog.create();
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, PARAMETER, METHOD })
@interface PetCat{}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, PARAMETER, METHOD })
@interface PetDog{}

public class Example2 {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new AnModule());
        MyPet myPet =injector.getInstance((MyPet.class));
        System.out.println("mypet can say "+ myPet.getAnimal().sayHi());
    }
}