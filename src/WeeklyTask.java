import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{


    public WeeklyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate) ||
                (localDate.isAfter(taskDate) && localDate.getDayOfWeek().equals(taskDate.getDayOfWeek()));
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.WEEKLY;
    }
}
