
public class IncorrectArgumentException extends Throwable{
    private String argument;

    public String getArgument() {
        return argument;
   }

    @Override
    public String toString() {
       return "IncorrectArgumentException{" +
              "argument='" + argument + '\'' +
                '}';
    }
    public IncorrectArgumentException(String argument) {
        super(argument);

    }
}
