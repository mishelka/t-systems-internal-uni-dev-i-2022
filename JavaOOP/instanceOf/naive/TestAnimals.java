package instanceOf.naive;

public class TestAnimals {
	public static void main(String[] args) {
		Animal spider = new Spider();
		NaiveInstanceof nio = new NaiveInstanceof();
		nio.doSomething(spider);
	}
}
