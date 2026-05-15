package core;

import model.ClassModel;
import model.MethodModel;
import model.ProjectModel;
import report.SmellReport;
import smells.*;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    private final LongMethodSmell longMethodSmell =
            new LongMethodSmell();

    private final LongParameterListSmell longParameterListSmell =
            new LongParameterListSmell();

    private final ComplexMethodSmell complexMethodSmell =
            new ComplexMethodSmell();

    private final DeepNestingSmell deepNestingSmell =
            new DeepNestingSmell();

    private final EmptyCatchSmell emptyCatchSmell =
            new EmptyCatchSmell();

    private final LargeClassSmell largeClassSmell =
            new LargeClassSmell();

    private final GodClassSmell godClassSmell =
            new GodClassSmell();

    public List<SmellReport> analyze(ProjectModel projectModel) {

        List<SmellReport> reports = new ArrayList<>();

        // Проход по классам
        for (ClassModel classModel : projectModel.getClasses()) {

            // CLASS SMELLS

            if (largeClassSmell.isLargeClass(classModel)) {

                reports.add(
                        new SmellReport(
                                classModel.getName(),
                                null,
                                "Large Class",
                                "Класс содержит слишком много методов",
                                "MEDIUM"
                        )
                );
            }

            if (godClassSmell.isGodClass(classModel)) {

                reports.add(
                        new SmellReport(
                                classModel.getName(),
                                null,
                                "God Class",
                                "Класс имеет слишком высокую сложность",
                                "HIGH"
                        )
                );
            }

            // METHOD SMELLS

            for (MethodModel methodModel : classModel.getMethods()) {

                // Long Method
                if (longMethodSmell.isLongMethod(methodModel)) {

                    reports.add(
                            new SmellReport(
                                    classModel.getName(),
                                    methodModel.getName(),
                                    "Long Method",
                                    "Метод слишком длинный",
                                    "MEDIUM"
                            )
                    );
                }

                // Long Parameter List
                if (longParameterListSmell
                        .hasLongParameterList(methodModel)) {

                    reports.add(
                            new SmellReport(
                                    classModel.getName(),
                                    methodModel.getName(),
                                    "Long Parameter List",
                                    "Слишком много параметров",
                                    "LOW"
                            )
                    );
                }

                // Complex Method
                if (complexMethodSmell.isComplex(methodModel)) {

                    reports.add(
                            new SmellReport(
                                    classModel.getName(),
                                    methodModel.getName(),
                                    "Complex Method",
                                    "Высокая цикломатическая сложность",
                                    "HIGH"
                            )
                    );
                }

                // Deep Nesting
                if (deepNestingSmell.hasDeepNesting(methodModel)) {

                    reports.add(
                            new SmellReport(
                                    classModel.getName(),
                                    methodModel.getName(),
                                    "Deep Nesting",
                                    "Слишком глубокая вложенность",
                                    "MEDIUM"
                            )
                    );
                }

                // Empty Catch
                if (emptyCatchSmell.hasEmptyCatch(methodModel)) {

                    reports.add(
                            new SmellReport(
                                    classModel.getName(),
                                    methodModel.getName(),
                                    "Empty Catch",
                                    "Обнаружен пустой catch блок",
                                    "HIGH"
                            )
                    );
                }
            }
        }

        return reports;
    }
}