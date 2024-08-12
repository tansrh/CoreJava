
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread = Thread.currentThread();
		thread.setName("abc");
		thread.setPriority(11);
		System.out.println(thread);
	}

}
