package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectModel {
    private List<ClassModel> classes = new ArrayList<>();

    public void addClass(ClassModel cls) {
        classes.add(cls);
    }

    public List<ClassModel> getClasses() {
        return classes;
    }

    private Map<String, List<String>> callGraph = new HashMap<>();
}
