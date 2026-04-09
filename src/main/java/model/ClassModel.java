package model;

import java.util.ArrayList;
import java.util.List;

public class ClassModel {

    private String name;

    private List<MethodModel> methods = new ArrayList<>();

    private int methodCount;
    private int totalLines;

    private int totalIfCount;
    private int totalLoopCount;
    private int totalSwitchCount;
    private int totalTryCount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MethodModel> getMethods() {
        return methods;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public int getTotalIfCount() {
        return totalIfCount;
    }

    public int getTotalLoopCount() {
        return totalLoopCount;
    }

    public int getTotalSwitchCount() {
        return totalSwitchCount;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }


    public void addMethod(MethodModel method) {
        methods.add(method);
        methodCount++;

        totalLines += method.getLineCount();
        totalIfCount += method.getIfCount();
        totalLoopCount += method.getLoopCount();
        totalSwitchCount += method.getSwitchCount();
        totalTryCount += method.getTryCount();
    }
}