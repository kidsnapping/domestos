package smells;

import model.MethodModel;
import metrics.CyclomaticComplexityMetric;

public class ComplexMethodSmell {

    private static final int MAX_COMPLEXITY = 10;

    private final CyclomaticComplexityMetric metric = new CyclomaticComplexityMetric();

    public boolean isSmelly(MethodModel method) {
        int complexity = metric.calculate(method);
        return complexity > MAX_COMPLEXITY;
    }
}