package parser;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import model.ClassModel;
import model.MethodModel;

public class ASTVisitor extends VoidVisitorAdapter<Void> {

    private ClassModel classModel;
    private MethodModel currentMethod;

    public ClassModel getClassModel() {
        return classModel;
    }

    // Обработка класса
    @Override
    public void visit(ClassOrInterfaceDeclaration c, Void arg) {
        classModel = new ClassModel();
        classModel.setName(c.getNameAsString());

        super.visit(c, arg);
    }

    // Обработка метода
    @Override
    public void visit(MethodDeclaration m, Void arg) {
        currentMethod = new MethodModel();
        currentMethod.setName(m.getNameAsString());
        currentMethod.setParameterCount(m.getParameters().size());

        // строки метода
        if (m.getBegin().isPresent() && m.getEnd().isPresent()) {
            currentMethod.setLineCount(m.getEnd().get().line - m.getBegin().get().line + 1);
        }

        currentMethod.setComplexity(1); // базовая сложность

        super.visit(m, arg);

        classModel.addMethod(currentMethod);
    }

    // if -> сложность
    @Override
    public void visit(IfStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.setComplexity(currentMethod.getComplexity() + 1);
        }
        super.visit(n, arg);
    }

    // for -> сложность
    @Override
    public void visit(ForStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.setComplexity(currentMethod.getComplexity() + 1);
        }
        super.visit(n, arg);
    }

    // while -> сложность
    @Override
    public void visit(WhileStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.setComplexity(currentMethod.getComplexity() + 1);
        }
        super.visit(n, arg);
    }
}