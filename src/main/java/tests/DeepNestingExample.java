package tests;

public class DeepNestingExample {
    public void process() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 5; j++) {
                    if (j > 2) {
                        System.out.println("Hello");
                    }
                }
            }
        }
    }
}
