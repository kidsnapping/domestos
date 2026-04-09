package metrics;

import model.MethodModel;

public class CyclomaticComplexityMetric {

    public int calculate(MethodModel method) {
        return 1 + method.getIfCount() + method.getLoopCount() + method.getSwitchCount() + method.getTryCount();
    }
}