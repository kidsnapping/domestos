package smells;

import model.MethodModel;

public class DeepNestingSmell {

    private static final int MAX_NESTING = 3;

    public boolean hasDeepNesting(MethodModel methodModel) {
        return methodModel.getMaxNestingLevel() > MAX_NESTING;
    }
}