package com.demo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

interface  Car{
    int drive();
}

final class BMW implements Car{
    @Inject BMW(){}
    @Override
    public  int drive(){
        return  55;
    }
    public static BMW create(){
        return new BMW();
    }
}

final class Tesla implements Car{
    @Inject Tesla(){}
    @Override
    public  int drive(){
        return  99;
    }
    public static Tesla create(){
        return new Tesla();
    }
}

@Singleton
final class Owner{
    private final  Car car;

    @Inject
    Owner(@Named("CarTesla") Car car){
        this.car=car;
    }
    public Car getCar(){
        return  car;
    }
}

final  class CarModule extends AbstractModule{
    @Provides
    @Named("CarBMW")
    Car provideCarBMWr(){
        return BMW.create();
    }
    @Provides
    @Named("CarTesla")
    Car provideCarTesla(){
        return Tesla.create();
    }
}

public class Example {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new CarModule());
        Owner owner = injector.getInstance((Owner.class));
        System.out.println("my cat speed "+owner.getCar().drive());
    }
}