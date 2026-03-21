package core;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    private static final String FILE_PATH =
            "src/main/java/core/AnalyzerApplication.java";
    public static void main(String[] args) throws Exception {
        CompilationUnit cu = StaticJavaParser
                .parse(Files.newInputStream(Paths.get(FILE_PATH)));
        YamlPrinter printer = new YamlPrinter(true);
        System.out.println(printer.output(cu));
    }
}