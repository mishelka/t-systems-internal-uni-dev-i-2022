package instanceOf.naive;

public class NaiveInstanceof {

	public void doSomething(Animal spider2) {
		if (spider2 instanceof Fish) {
			Fish fish = (Fish) spider2;
			fish.swim();
		} else if (spider2 instanceof Spider) {
			Spider spider = (Spider) spider2;
			spider.crawl();
		}
	}
}
