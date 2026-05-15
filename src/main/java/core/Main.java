package core;


import model.ProjectModel;
import parser.ProjectParser;
import report.ConsoleReporter;
import report.SmellReport;

import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path projectPath = Path.of("src/main/java/tests");

        ProjectParser parser = new ProjectParser(projectPath);
        ProjectModel projectModel = parser.parseProject();

        Analyzer analyzer = new Analyzer();
        List<SmellReport> reports = analyzer.analyze(projectModel);

        ConsoleReporter reporter = new ConsoleReporter();
        reporter.print(projectModel, reports);
    }
}
