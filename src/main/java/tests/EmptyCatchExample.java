package tests;

public class EmptyCatchExample {
    public void loadData() {
        try {
            int a = 10 / 0;
        } catch (Exception e) {
        }
    }
}
