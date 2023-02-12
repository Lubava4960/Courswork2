import java.time.LocalDate;
import java.time.LocalDateTime;
public class DailyTask extends Task {


    public DailyTask(String title, Task type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate  localDate) {
        LocalDateTime dateTime = this.getDateTime();
        return false;
    }

    // private Object getTaskDateTime() {
   //}
}
