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

    // Класс
    @Override
    public void visit(ClassOrInterfaceDeclaration c, Void arg) {
        classModel = new ClassModel();
        classModel.setName(c.getNameAsString());

        super.visit(c, arg);
    }

    // Метод
    @Override
    public void visit(MethodDeclaration m, Void arg) {
        currentMethod = new MethodModel();

        currentMethod.setName(m.getNameAsString());
        currentMethod.setParameterCount(m.getParameters().size());

        // строки
        if (m.getBegin().isPresent() && m.getEnd().isPresent()) {
            currentMethod.setLineCount(
                    m.getEnd().get().line - m.getBegin().get().line + 1
            );
        }

        super.visit(m, arg);
        classModel.addMethod(currentMethod);
    }

    // if
    @Override
    public void visit(IfStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.incrementIfCount();
        }
        super.visit(n, arg);
    }

    // for
    @Override
    public void visit(ForStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.incrementLoopCount();
        }
        super.visit(n, arg);
    }

    // while
    @Override
    public void visit(WhileStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.incrementLoopCount();
        }
        super.visit(n, arg);
    }

    // switch
    @Override
    public void visit(SwitchStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.incrementSwitchCount();
        }
        super.visit(n, arg);
    }

    // try-catch
    @Override
    public void visit(TryStmt n, Void arg) {
        if (currentMethod != null) {
            currentMethod.incrementTryCount();
        }
        super.visit(n, arg);
    }
}