package core;

import model.ClassModel;
import model.MethodModel;
import metrics.CyclomaticComplexityMetric;
import model.ProjectModel;
import smells.ComplexMethodSmell;

public class Test {

    public static void analyze1(ProjectModel project) {
        CyclomaticComplexityMetric metric = new CyclomaticComplexityMetric();
        ComplexMethodSmell smell = new ComplexMethodSmell();

        for (ClassModel cls : project.getClasses()) {
            System.out.println("Class: " + cls.getName());

            for (MethodModel method : cls.getMethods()) {
                int complexity = metric.calculate(method);

                System.out.println("  Method: " + method.getName());
                System.out.println("    Complexity: " + complexity);

                if (smell.isSmelly(method)) {
                    System.out.println("    ⚠ Complex Method detected!");
                }
            }
        }
    }
}