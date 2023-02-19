import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate) ||
                (localDate.isAfter(taskDate) &&
                        localDate.getDayOfMonth() == taskDate.getDayOfMonth() &&
                        localDate.getMonth().equals(taskDate.getMonth()));
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.YEARLY;
    }

}
