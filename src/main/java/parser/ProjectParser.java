package parser;

import model.ClassModel;
import model.ProjectModel;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProjectParser {
    private final Path projectRoot;

    public ProjectParser(Path projectRoot) {
        this.projectRoot = projectRoot;
    }

    public ProjectModel parseProject() {
        ProjectModel projectModel = new ProjectModel();

        List<Path> javaFiles = findJavaFiles();

        for (Path file : javaFiles) {
            try {
                FileParser fileParser = new FileParser(file);
                ClassModel classModel = fileParser.parse();

                if (classModel != null) {
                    projectModel.addClass(classModel);
                }

            } catch (Exception e) {
                System.err.println("Ошибка при обработке файла: " + file);
                e.printStackTrace();
            }
        }

        return projectModel;
    }

    private List<Path> findJavaFiles() {
        List<Path> javaFiles = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(projectRoot)) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(javaFiles::add);

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при сканировании проекта", e);
        }

        return javaFiles;
    }
}
