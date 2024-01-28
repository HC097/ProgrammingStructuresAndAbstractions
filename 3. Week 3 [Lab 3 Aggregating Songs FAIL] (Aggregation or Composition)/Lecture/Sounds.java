 class Sounds {

    public static void main(String[] args){

        Animal myAnimal = new Animal(); //Create a Animal object

        Animal myPig = new Pig();

        Animal myDog = new Dog();

        myAnimal.animalSound();

        myPig.animalSound();

        myDog.animalSound();

        System.out.println(myPig.testnum);
    }
}