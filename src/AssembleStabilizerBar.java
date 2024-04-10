public class AssembleStabilizerBar implements Employee,Subscriber{
    private final EventService eventBus;

    public AssembleStabilizerBar(EventService eventBus) {
        this.eventBus = eventBus;
    }

    public void subscribeToEvents() throws InvalidEventTypeException {
        eventBus.subscribe(Event.class, new AssemblingStabilizerBarFilter(), this);
    }

    @Override
    public void inform(Event event) {
        if (event.getType().equals("FEET_COMPLETED")) {
            Chair chair = (Chair) event.getData();
            chair.setTaskStatus("DONE_S", true);
            System.out.println("Assembling stabilizer for chair: " + chair.getName());
            eventBus.publish(new CustomEvent("STABILIZER_COMPLETED", chair));
        }
    }
}
