import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class DailyTask extends Task  {

    public DailyTask( String title, Type type, int id, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super( title, type, id, dateTime, description);
    }

    @Override
    public boolean appearsln() {
        return false;
    }
}
