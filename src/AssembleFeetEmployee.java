public class AssembleFeetEmployee implements Employee,Subscriber{
    private final EventService eventBus;

    public AssembleFeetEmployee(EventService eventBus) {
        this.eventBus = eventBus;
    }

    public void subscribeToEvents() throws InvalidEventTypeException{
        eventBus.subscribe(CutCompletedIvent.class, new AssemblingFeetFilter(), this);
    }

    @Override
    public void inform(Event event) {

        Chair chair = (Chair) event.getData();
        chair.setTaskStatus("DONE_F", true);
        System.out.println("Assembling feet for chair: " + chair.getName());
        eventBus.publish(new CustomEvent("FEET_COMPLETED", chair));

    }
}
