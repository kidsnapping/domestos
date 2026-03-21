package model;

import java.util.ArrayList;
import java.util.List;

public class ClassModel {
    private String name;
    private List<MethodModel> methods = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MethodModel> getMethods() {
        return methods;
    }

    public void addMethod(MethodModel method) {
        methods.add(method);
    }
}
