package parser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import model.ClassModel;
import java.io.IOException;
import java.nio.file.Path;

public class FileParser {
    private final Path javaFile; // путь к .java файла

    public FileParser(Path javaFile) {
        this.javaFile = javaFile;
    }

    public ClassModel parse() throws IOException {
        // Парсим .java файла в AST
        CompilationUnit cu = StaticJavaParser.parse(javaFile);

        // Создание visitor
        ASTVisitor visitor = new ASTVisitor();

        // Запуск обхода древа
        visitor.visit(cu, null);

        // Получение результата
        return visitor.getClassModel();
    }
}