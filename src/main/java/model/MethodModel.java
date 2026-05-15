package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MethodModel {

    private String name;
    private int parameterCount;
    private int lineCount;
    private int maxNestingLevel;
    private int emptyCatchCount;
    private int catchCount;
    private Set<String> calledMethods = new HashSet<>();

    private int ifCount;
    private int loopCount;
    private int switchCount;
    private int tryCount;

    public void addCalledMethod(String methodName) {
        calledMethods.add(methodName);
    }

    public Set<String> getCalledMethods() {
        return calledMethods;
    }

    public int getMaxNestingLevel() {
        return maxNestingLevel;
    }

    public void setMaxNestingLevel(int maxNestingLevel) {
        this.maxNestingLevel = maxNestingLevel;
    }

    public int getEmptyCatchCount() {
        return emptyCatchCount;
    }

    public void setEmptyCatchCount(int emptyCatchCount) {
        this.emptyCatchCount = emptyCatchCount;
    }

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

    public void incrementCatchCount() {
        catchCount++;
    }

    public void incrementEmptyCatchCount() {
        emptyCatchCount++;
    }

    public int getCatchCount() {
        return catchCount;
    }

}