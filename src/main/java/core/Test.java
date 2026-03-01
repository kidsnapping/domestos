package core;

public class Test extends Sosal {
    public static void main(String[] args) {
        Sosal exe = new Sosal();
        exe.setPetux("Vadim");
        exe.check();
        exe.setPetux("On");
        exe.check();

    }
}

class Sosal{
    String petux;

    public void setPetux(String petux) {
        this.petux = petux;
    }

    public String getPetux() {
        return petux;
    }

    void check(){
        switch (petux){
            case "Ya":
                System.out.println("Ya Petux");
                break;
            case "On":
                System.out.println("On petux");
                break;
            case "Vadim":
                System.out.println("Vadim petux");
                break;
        }
    }
}