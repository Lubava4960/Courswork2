import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTameTask extends Task{




    public OneTameTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }



    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getTaskDateTime().toLocalDate());
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.ONE_TIME;
    }
}
