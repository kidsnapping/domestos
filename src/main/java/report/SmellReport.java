package report;

public class SmellReport {
    private final String className;
    private final String methodName;
    private final String smellName;
    private final String description;
    private final String severity;

    public SmellReport(
            String className,
            String methodName,
            String smellName,
            String description,
            String severity
    ) {
        this.className = className;
        this.methodName = methodName;
        this.smellName = smellName;
        this.description = description;
        this.severity = severity;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getSmellName() {
        return smellName;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }
}