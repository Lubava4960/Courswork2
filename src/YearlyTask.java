import java.time.LocalDate;

public class YearlyTask extends Task{

    public YearlyTask(String title, Task dateTime, String description) throws IncorrectArgumentException {
        super(title, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate date) {
        return false;
    }
}
