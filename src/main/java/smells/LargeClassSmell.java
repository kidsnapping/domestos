package smells;

import model.ClassModel;

public class LargeClassSmell {

    private static final int MAX_METHODS = 10;

    public boolean isLargeClass(ClassModel classModel) {
        return classModel.getMethods().size() > MAX_METHODS;
    }
}
