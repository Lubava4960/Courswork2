public enum Type implements java.lang.reflect.Type {

    WORK("рабочие задачи"),
    PERSONAL("личные задачи");
    private final String type;

    Type(String type) {

        this.type = type;
    }

    public String getType() {
        return type;
    }
}
