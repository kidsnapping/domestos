package report;

import model.ClassModel;
import model.MethodModel;
import model.ProjectModel;

import java.util.List;

public class ConsoleReporter {

    public void print(ProjectModel project, List<SmellReport> reports) {

        if (reports.isEmpty()) {
            System.out.println("Code smells не обнаружены");
        } else {

            System.out.println("=== Результаты анализа ===\n");

            for (SmellReport report : reports) {
                System.out.println("Class: " + report.getClassName());
                System.out.println("Method: " + report.getMethodName());
                System.out.println("Smell: " + report.getSmellName());
                System.out.println("Severity: " + report.getSeverity());
                System.out.println("Description: " + report.getDescription());
                System.out.println();
            }
        }

        System.out.println("=== Call Graph ===\n");

        for (ClassModel cls : project.getClasses()) {

            for (MethodModel m : cls.getMethods()) {

                System.out.println(
                        cls.getName() + "." + m.getName()
                                + " calls: " + m.getCalledMethods()
                );
            }
        }
    }
}