package core;

import model.ProjectModel;
import parser.ProjectParser;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnalyzerApplication {
    public static void main(String[] args) {
        Path projectPath = Paths.get("C:/projects/domestos");

        ProjectParser parser = new ProjectParser(projectPath);
        ProjectModel project = parser.parseProject();

        Test analyzer = new Test();
        analyzer.analyze1(project);
    }
}
