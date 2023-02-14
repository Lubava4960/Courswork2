import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class DailyTask extends Task  {


    public DailyTask(String title, Type type, int Id, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, Id, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDateTime date) {
        return false;
    }

    @Override
    public int getId() {

        return 0;
    }


}


