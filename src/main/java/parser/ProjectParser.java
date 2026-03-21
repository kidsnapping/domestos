    package parser;
    
    import model.ClassModel;
    import model.ProjectModel;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    import java.io.IOException;
    import java.nio.file.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Stream;
    
    public class ProjectParser {

        private static final Logger logger = LoggerFactory.getLogger(ProjectParser.class);
        private final Path projectRoot; // путь поиска

        public ProjectParser(Path projectRoot) {
            this.projectRoot = projectRoot;
        }

        // Метод для передачи
        public ProjectModel parseProject() {
            ProjectModel projectModel = new ProjectModel();

            List<Path> javaFiles = findJavaFiles(); // список файлов, полученный после поиска

            // Обрабатываем каждый файл
            for (Path file : javaFiles) {
                try {
                    FileParser fileParser = new FileParser(file); // считать файл
                    ClassModel classModel = fileParser.parse(); // вернуть обработанный ClassModel

                    if (classModel != null) { // сохраняем в случае успеха
                        projectModel.addClass(classModel);
                    }

                } catch (Exception e) {
                    logger.error("Ошибка при обработке файла: {}", file, e);
                }
            }
    
            return projectModel;
        }

        // Поиск файлов .java
        private List<Path> findJavaFiles() {
            List<Path> javaFiles = new ArrayList<>();

            // Начало поиска, выбор путей и файлов
            try (Stream<Path> paths = Files.walk(projectRoot)) {
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