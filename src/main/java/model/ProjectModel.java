package model;

import java.util.ArrayList;
import java.util.List;

public class ProjectModel {
    private List<ClassModel> classes = new ArrayList<>();

    public void addClass(ClassModel cls) {
        classes.add(cls);
    }

    public List<ClassModel> getClasses() {
        return classes;
    }
}
