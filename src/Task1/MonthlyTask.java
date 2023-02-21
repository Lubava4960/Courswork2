package Task1;

import Task1.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {


    public MonthlyTask(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        super(title, description, taskDateTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getTaskDataTime().toLocalDate();
        return taskDate.equals(localDate) ||
                (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth());
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.MONTHLY;
    }
}
