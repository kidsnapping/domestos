package tests;

public class LargeClassExample {

    private String textContext;

    public LargeClassExample(String textContext) {
        this.textContext = textContext;
    }

    public void processString1() { System.out.println("Обработка 1"); }
    public void processString2() { System.out.println("Обработка 2"); }
    public void processString3() { System.out.println("Обработка 3"); }
    public void processString4() { System.out.println("Обработка 4"); }
    public void processString5() { System.out.println("Обработка 5"); }
    public void processString6() { System.out.println("Обработка 6"); }
    public void processString7() { System.out.println("Обработка 7"); }
    public void processString8() { System.out.println("Обработка 8"); }
    public void processString9() { System.out.println("Обработка 9"); }
    public void processString10() { System.out.println("Обработка 10"); }

    public void validateInput1() { System.out.println("Валидация 1"); }
    public void validateInput2() { System.out.println("Валидация 2"); }
    public void validateInput3() { System.out.println("Валидация 3"); }
    public void validateInput4() { System.out.println("Валидация 4"); }
    public void validateInput5() { System.out.println("Валидация 5"); }
    public void validateInput6() { System.out.println("Валидация 6"); }
    public void validateInput7() { System.out.println("Валидация 7"); }
    public void validateInput8() { System.out.println("Валидация 8"); }
    public void validateInput9() { System.out.println("Валидация 9"); }
    public void validateInput10() { System.out.println("Валидация 10"); }

    public void transformFormat1() { System.out.println("Трансформация 1"); }
    public void transformFormat2() { System.out.println("Трансформация 2"); }
    public void transformFormat3() { System.out.println("Трансформация 3"); }
    public void transformFormat4() { System.out.println("Трансформация 4"); }
    public void transformFormat5() { System.out.println("Трансформация 5"); }
    public void transformFormat6() { System.out.println("Трансформация 6"); }
    public void transformFormat7() { System.out.println("Трансформация 7"); }
    public void transformFormat8() { System.out.println("Трансформация 8"); }
    public void transformFormat9() { System.out.println("Трансформация 9"); }
    public void transformFormat10() { System.out.println("Трансформация 10"); }

    public void flushState() {
        this.textContext = "";
    }
}