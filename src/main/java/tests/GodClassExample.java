package tests;

public class GodClassExample {

    public void connectToDb(String url) {
        if (url == null) return;
        if (url.isEmpty()) return;
        System.out.println("Подключение...");
    }

    public void saveUser(int id, String name) {
        if (id < 0) return;
        if (name == null) return;
        if (name.isEmpty()) return;
        System.out.println("Сохранение...");
    }

    public void deleteUser(int id) {
        if (id < 0) return;
        if (id == 0) System.out.println("Root");
        System.out.println("Удаление...");
    }

    public void updateUser(int id) {
        if (id > 0) {
            if (id == 1) System.out.println("Admin");
        }
    }

    public void calculateSalary(int hours, double rate) {
        if (hours < 0) return;
        if (rate < 0) return;
        if (hours > 40) rate *= 1.5;
        if (hours > 60) rate *= 2;
    }

    public void calculateTaxes(double income) {
        if (income < 1000) return;
        if (income > 5000) income -= 100;
        if (income > 10000) income -= 500;
        if (income > 50000) income -= 1000;
    }

    public void generateReport(int type) {
        switch (type) {
            case 1: System.out.println("PDF"); break;
            case 2: System.out.println("Excel"); break;
            case 3: System.out.println("Word"); break;
            case 4: System.out.println("CSV"); break;
        }
    }

    public void auditLogs(String log) {
        if (log != null) {
            if (log.contains("error")) System.out.println("Error found");
        }
    }

    public void sendEmail(String to) {
        if (to == null) return;
        if (!to.contains("@")) return;
        if (to.endsWith(".ru")) System.out.println("RU");
        if (to.endsWith(".com")) System.out.println("COM");
    }

    public void sendPush(int deviceId) {
        if (deviceId == 0) return;
        if (deviceId < 100) System.out.println("Old device");
        if (deviceId > 1000) System.out.println("New device");
    }

    public void fetchApiData(String endpoint) {
        if (endpoint == null) return;
        if (endpoint.startsWith("http")) System.out.println("Secure");
        if (endpoint.startsWith("ftp")) System.out.println("File");
        if (endpoint.isEmpty()) return;
    }

    public void parseJsonResponse(String json) {
        if (json != null) {
            if (json.startsWith("{")) System.out.println("Object");
            if (json.startsWith("[")) System.out.println("Array");
        }
    }

    public void renderWindow(int width, int height) {
        if (width <= 0) return;
        if (height <= 0) return;
        if (width > 1920) System.out.println("4K");
        if (height > 1080) System.out.println("HD");
    }

    public void drawButton(String text) {
        if (text == null) return;
        if (text.length() > 10) System.out.println("Too long");
        if (text.isEmpty()) System.out.println("Empty");
    }

    public void handleMouseClick(int x, int y) {
        if (x < 0) return;
        if (y < 0) return;
        if (x > 100 && y > 100) System.out.println("Center");
    }

    public void handleKeyPress(int key) {
        if (key == 13) System.out.println("Enter");
        if (key == 27) System.out.println("Escape");
        if (key == 32) System.out.println("Space");
        if (key == 8) System.out.println("Backspace");
    }
}
