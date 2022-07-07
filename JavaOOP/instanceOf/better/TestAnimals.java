package instanceOf.better;

public class TestAnimals {
	public static void main(String[] args) {
		NaiveInstanceofFixed nio = new NaiveInstanceofFixed();

		System.out.println("Starting...");
		Animal animal = new Animal();
		nio.doSomething(animal);

		// repoint the same 'animal' reference to other objects:

		animal = new Fish();
		nio.doSomething(animal);

		animal = new Spider();
		nio.doSomething(animal);

		System.out.println("Done.");
	}
}
