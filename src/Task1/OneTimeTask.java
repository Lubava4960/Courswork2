package Task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String description, LocalDateTime taskDateTime, TaskType taskType) {
        super(title, description, taskDateTime, taskType);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getTaskDataTime().toLocalDate());
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.ONE_TIME;
    }
}


