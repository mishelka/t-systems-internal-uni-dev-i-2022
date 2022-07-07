public class Precision {
	public static void main(String[] args) {
		double f = 1E6f;
		for (int i = 0; i < 1000000; i++) {
			f += 0.01f;
		}
		System.out.println(f);

		f = 1E6f;
		System.out.println(f + 1000000 * 0.01);
	}
}
