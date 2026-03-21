package parser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import model.ClassModel;
import model.MethodModel;

import java.io.IOException;
import java.nio.file.Path;

public class FileParser {
    private final Path javaFile; // путь к .java файла

    public FileParser(Path javaFile) {
        this.javaFile = javaFile;
    }

    public ClassModel parse() throws IOException {
        // Создаём объект ClassModel для хранения информации о классе
        ClassModel classModel = new ClassModel();

        // Парсим .java файла в AST
        CompilationUnit cu = StaticJavaParser.parse(javaFile);

        // Ищем все классы/интерфейсы в файле
        cu.findAll(ClassOrInterfaceDeclaration.class).forEach(c -> {
            // Сохраняем имя класса
            classModel.setName(c.getNameAsString());

            // Перебираем все методы класса
            for (MethodDeclaration method : c.getMethods()) {
                MethodModel methodModel = new MethodModel();
                methodModel.setName(method.getNameAsString());
                methodModel.setParameterCount(method.getParameters().size());

                // Количество строк метода
                if (method.getBegin().isPresent() && method.getEnd().isPresent()) {
                    methodModel.setLineCount(method.getEnd().get().line - method.getBegin().get().line + 1);
                } else {
                    methodModel.setLineCount(0); // если информация недоступна
                }

                // Пока ставим заглушку для сложности
                methodModel.setComplexity(1);

                // Добавляем метод в класс
                classModel.addMethod(methodModel);
            }
        });

        return classModel;
    }
}