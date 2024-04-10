import java.util.HashMap;
import java.util.Map;

public class Chair {
    private String name;
    private Map<String, Boolean> tasks;

    public Chair(String name) {
        this.name = name;
        this.tasks = new HashMap<>();
        initializeTasks();
    }

    private void initializeTasks() {
        tasks.put("DONE_C", false);  // Cut seat
        tasks.put("DONE_F", false);  // Assemble feet
        tasks.put("DONE_B", false);  // Assemble backrest
        tasks.put("DONE_S", false);  // Assemble stabilizer bar
        tasks.put("DONE_P", false);  // Package chair
    }

    public String getName() {
        return name;
    }

    public Map<String, Boolean> getTasks() {
        return tasks;
    }

    public void setTaskStatus(String task, boolean status) {
        tasks.put(task, status);
    }
}
