package smells;

import model.MethodModel;

public class EmptyCatchSmell {

    public boolean hasEmptyCatch(MethodModel methodModel) {
        return methodModel.getEmptyCatchCount() > 0;
    }
}