package Task1;

public enum TaskType {
    WORK(" рабочие задачи. "),
    PERSONAL(" личные задачи. ");
    private final String taskType;


    TaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "taskType='" + taskType + '\'' +
                '}';
    }

}
