import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTameTask extends Task{


    public OneTameTask(String title, Task type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate date) {

        return false;
    }
}
