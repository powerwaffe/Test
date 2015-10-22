package Demo;

/**
 * Created by Sean on 9/29/2015.
 */

abstract class Pet { //abstract locks an object from being created
    protected String name;

    Pet (String newName) { //constructor
        name=newName;
    }

    public String toString() {
        return "Your new pet's name is " + getName();
    }

    public String getName() {
        return name;
    }
}

abstract class Dog extends Pet {

    Dog(String newName) { //constructor
        super(newName); //super goes up one level
    }

    public String toString() {
        return super.toString() + "\nYour pet may bark";
    }

    public void setName(String arg) {
        super.name=arg;
    }
}

class Boxer extends Dog {

    Boxer(String newName) { //constructor
        super(newName);
    }

    public String toString() {
        return super.toString() + "\nYour dog may drool alot";
    }
}

class Lab extends Dog {

    Lab (String newName) {
        super(newName);
    }

    public String toString() {
        return super.toString() + "\nYour dog may want to play a lot";
    }
}

abstract class Cat extends Pet {

    Cat(String newName) { //constructor
        super(newName);
    }

    public String toString() {
        return super.toString() + "\nYour pet may meow";
    }

    public void setName(String arg) {
        super.name=arg;
    }
}

class Siamese extends Cat {

    Siamese(String newName) { //constructor
        super(newName);
    }

    public String toString() {
        return super.toString() + "\nYour cat may be plotting to kill you";
    }
}

class Savannah extends Cat {

    Savannah(String newName) {
        super(newName);
    }

    public String toString() {
        return super.toString() + "\nYour cat may be overwhelmingly expensive";
    }
}

public class ObjectDemo2 { //main
    public static void main(String[] Duck) {
        Pet myBoxer = new Boxer("Belle");
        Pet myLab = new Lab("Duper");
        Pet mySiamese = new Siamese("Buttercup");
        Pet mySavannah = new Savannah("Dudley");

        /*
        myBoxer.name="Destroyer";
        mySiamese.name="Sir clarence";
        myServal.name="Dudley";
        */
        System.out.println(myBoxer+ "\n");
        System.out.println(mySiamese +"\n");
        System.out.println(myLab + "\n");
        System.out.println(mySavannah);

    }
}


