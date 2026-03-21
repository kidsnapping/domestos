    package parser;
    
    import model.ClassModel;
    import model.ProjectModel;
    
    import java.io.IOException;
    import java.nio.file.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Stream;
    
    public class ProjectParser {
        private final Path projectRoot; // путь поиска
    
        public ProjectParser(Path projectRoot) {
            this.projectRoot = projectRoot;
        }
    
        public ProjectModel parseProject() { // метод для передачи
            ProjectModel projectModel = new ProjectModel();

            List<Path> javaFiles = findJavaFiles(); // список файлов, полученный после поиска
    
            for (Path file : javaFiles) { // обрабатываем каждый файл
                try {
                    FileParser fileParser = new FileParser(file); // считать файл
                    ClassModel classModel = fileParser.parse(); // вернуть обработанный ClassModel

                    if (classModel != null) { // сохраняем в случае успеха
                        projectModel.addClass(classModel);
                    }

                } catch (Exception e) {
                    System.err.println("Ошибка при обработке файла: " + file);
                    e.printStackTrace();
                }
            }
    
            return projectModel;
        }

        // поиск файлов .java
        private List<Path> findJavaFiles() {
            List<Path> javaFiles = new ArrayList<>();
    
            try (Stream<Path> paths = Files.walk(projectRoot)) { //начало поиска, выбор путей и файлов
                paths
                        .filter(Files::isRegularFile) // фильтрация, оставляем только файлы
                        .filter(path -> path.toString().endsWith(".java")) // убираем лишнии файлы, оставляем только .java
                        .forEach(javaFiles::add); // добавляем их в список javaFiles
    
            } catch (IOException e) {
                throw new RuntimeException("Ошибка при сканировании проекта", e);
            }
    
            return javaFiles;
        }
    }
