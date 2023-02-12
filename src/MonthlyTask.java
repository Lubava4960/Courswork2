import java.time.LocalDateTime;

public abstract class MonthlyTask extends Task {


    public MonthlyTask(String title, Task type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }
}
