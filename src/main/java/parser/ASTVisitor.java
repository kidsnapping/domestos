package parser;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import model.ClassModel;
import model.MethodModel;

public class ASTVisitor extends VoidVisitorAdapter<Void> {

    private ClassModel classModel;
    private MethodModel currentMethod;

    private int currentNestingLevel = 0;

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

    // Поля класса
    @Override
    public void visit(FieldDeclaration n, Void arg) {
        if (classModel != null) {
            classModel.incrementFieldCount();
        }

        super.visit(n, arg);
    }

    // Метод
    @Override
    public void visit(MethodDeclaration m, Void arg) {

        currentMethod = new MethodModel();

        currentMethod.setName(m.getNameAsString());
        currentMethod.setParameterCount(m.getParameters().size());

        // Количество строк
        if (m.getBegin().isPresent() && m.getEnd().isPresent()) {

            currentMethod.setLineCount(
                    m.getEnd().get().line -
                            m.getBegin().get().line + 1
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

            currentNestingLevel++;

            if (currentNestingLevel >
                    currentMethod.getMaxNestingLevel()) {

                currentMethod.setMaxNestingLevel(
                        currentNestingLevel
                );
            }
        }

        super.visit(n, arg);

        currentNestingLevel--;
    }

    // for
    @Override
    public void visit(ForStmt n, Void arg) {

        if (currentMethod != null) {

            currentMethod.incrementLoopCount();

            currentNestingLevel++;

            if (currentNestingLevel >
                    currentMethod.getMaxNestingLevel()) {

                currentMethod.setMaxNestingLevel(
                        currentNestingLevel
                );
            }
        }

        super.visit(n, arg);

        currentNestingLevel--;
    }

    // foreach
    @Override
    public void visit(ForEachStmt n, Void arg) {

        if (currentMethod != null) {

            currentMethod.incrementLoopCount();

            currentNestingLevel++;

            if (currentNestingLevel >
                    currentMethod.getMaxNestingLevel()) {

                currentMethod.setMaxNestingLevel(
                        currentNestingLevel
                );
            }
        }

        super.visit(n, arg);

        currentNestingLevel--;
    }

    // while
    @Override
    public void visit(WhileStmt n, Void arg) {

        if (currentMethod != null) {

            currentMethod.incrementLoopCount();

            currentNestingLevel++;

            if (currentNestingLevel >
                    currentMethod.getMaxNestingLevel()) {

                currentMethod.setMaxNestingLevel(
                        currentNestingLevel
                );
            }
        }

        super.visit(n, arg);

        currentNestingLevel--;
    }

    // do while
    @Override
    public void visit(DoStmt n, Void arg) {

        if (currentMethod != null) {

            currentMethod.incrementLoopCount();

            currentNestingLevel++;

            if (currentNestingLevel >
                    currentMethod.getMaxNestingLevel()) {

                currentMethod.setMaxNestingLevel(
                        currentNestingLevel
                );
            }
        }

        super.visit(n, arg);

        currentNestingLevel--;
    }

    // switch
    @Override
    public void visit(SwitchStmt n, Void arg) {

        if (currentMethod != null) {

            currentMethod.incrementSwitchCount();

            currentNestingLevel++;

            if (currentNestingLevel >
                    currentMethod.getMaxNestingLevel()) {

                currentMethod.setMaxNestingLevel(
                        currentNestingLevel
                );
            }
        }

        super.visit(n, arg);

        currentNestingLevel--;
    }

    // catch
    @Override
    public void visit(CatchClause n, Void arg) {

        if (currentMethod != null) {

            currentMethod.incrementCatchCount();

            if (n.getBody().isEmpty()) {
                currentMethod.incrementEmptyCatchCount();
            }

            currentNestingLevel++;

            if (currentNestingLevel >
                    currentMethod.getMaxNestingLevel()) {

                currentMethod.setMaxNestingLevel(
                        currentNestingLevel
                );
            }
        }

        super.visit(n, arg);

        currentNestingLevel--;
    }

    // Graph
    @Override
    public void visit(MethodCallExpr n, Void arg) {

        if (currentMethod != null) {

            currentMethod.addCalledMethod(
                    n.getNameAsString()
            );
        }

        super.visit(n, arg);
    }
}