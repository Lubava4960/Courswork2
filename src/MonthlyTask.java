import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {


    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getTaskDateTime().toLocalDate();
        return taskDate.equals(localDate) ||
                (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth());
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.MONTHLY;
    }
}
