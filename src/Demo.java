import java.util.UUID;


public class Demo {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.out.println(System.currentTimeMillis());
			System.out.println(UUID.randomUUID().toString());
		}
	}

}
