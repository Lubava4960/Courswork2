import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task  {


    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate) || localDate.isAfter(taskDate);
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.DAILY;
    }

}


