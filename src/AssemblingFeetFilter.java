import java.util.Map;

public class AssemblingFeetFilter implements Filter{

    @Override
    public boolean apply(Event event) {
        Chair chair = (Chair) event.getData();
        Map<String, Boolean> tasks = chair.getTasks();
        return !tasks.get("DONE_F");
    }
}
