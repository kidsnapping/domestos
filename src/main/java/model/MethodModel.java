package model;

public class MethodModel {

    private String name;
    private int parameterCount;
    private int lineCount;

    private int ifCount;
    private int loopCount;
    private int switchCount;
    private int tryCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParameterCount() {
        return parameterCount;
    }

    public void setParameterCount(int parameterCount) {
        this.parameterCount = parameterCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getIfCount() {
        return ifCount;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public int getSwitchCount() {
        return switchCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void incrementIfCount() {
        this.ifCount++;
    }

    public void incrementLoopCount() {
        this.loopCount++;
    }

    public void incrementSwitchCount() {
        this.switchCount++;
    }

    public void incrementTryCount() {
        this.tryCount++;
    }
}