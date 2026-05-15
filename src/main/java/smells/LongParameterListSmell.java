package smells;

import model.MethodModel;

public class LongParameterListSmell {

    private static final int MAX_PARAMETERS = 4;

    public boolean hasLongParameterList(MethodModel method) {
        return method.getParameterCount() > MAX_PARAMETERS;
    }
}
