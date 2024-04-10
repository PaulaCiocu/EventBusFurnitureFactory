public class CustomEvent implements Event {
    private final String type;
    private final Object data;

    public CustomEvent(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Object getData() {
        return data;
    }
}
