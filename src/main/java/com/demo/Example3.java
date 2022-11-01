package com.demo;

import com.google.inject.*;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.METHOD;

interface Computer{
    String system();
}

final class Apple implements Computer{
    @Inject Apple(){}
    @Override
    public String system(){return "MACOS";}
    public static Apple set(){return new Apple();}
}

final class  Lenovo implements Computer{
    @Inject Lenovo(){}
    @Override
    public  String system(){return "window";}
    public static Lenovo set(){return  new Lenovo();}
}

final class User{
    private final Computer computer;
    @Inject
    User(@ComputerApple Computer computer){
        this.computer=computer;
    }
    public Computer getComputer(){return  computer;}
}

final class ComputerModule extends AbstractModule{
    @Provides
    @ComputerApple
    Computer provideComputerApple(){return  Apple.set();}
    @Provides
    @ComputerLenovo
    Computer provideComputerLenovo(){return  Lenovo.set();}
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, PARAMETER, METHOD })
@interface ComputerApple{}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, PARAMETER, METHOD })
@interface ComputerLenovo{}

public class Example3 {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new ComputerModule());
        User user = injector.getInstance((User.class));
        System.out.println("My computer system is "+ user.getComputer().system());
    }
}