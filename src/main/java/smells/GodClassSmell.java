package smells;

import model.ClassModel;

public class GodClassSmell {

    private static final int MAX_METHODS = 15;
    private static final int MAX_COMPLEXITY = 50;

    public boolean isGodClass(ClassModel classModel) {

        return classModel.getMethods().size() > MAX_METHODS
                && classModel.getTotalComplexity() > MAX_COMPLEXITY;
    }
}