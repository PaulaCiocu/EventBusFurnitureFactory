import java.sql.SQLOutput;
import java.util.Map;

public class PackageFilter implements Filter{


    @Override
    public boolean apply(Event event) {
        Chair chair = (Chair) event.getData();
        Map<String, Boolean> tasks = chair.getTasks();
        return tasks.get("DONE_S") && tasks.get("DONE_B") && !tasks.get("DONE_P");
    }
}
