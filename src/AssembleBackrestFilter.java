import java.util.Map;

public class AssembleBackrestFilter implements Filter{

    @Override
    public boolean apply(Event event) {
        Chair chair = (Chair) event.getData();
        Map<String, Boolean> tasks = chair.getTasks();
        return !tasks.get("DONE_B");
    }
}
