package smells;

import model.MethodModel;

public class LongMethodSmell {

    private static final int MAX_LINES = 30;

    public boolean isLongMethod(MethodModel method) {
        return method.getLineCount() > MAX_LINES;
    }
}
