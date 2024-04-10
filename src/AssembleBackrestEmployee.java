public class AssembleBackrestEmployee implements Employee,Subscriber{
    private final EventService eventBus;


    public AssembleBackrestEmployee(EventService eventBus) {
        this.eventBus = eventBus;
    }

    public void subscribeToEvents() throws InvalidEventTypeException{
        eventBus.subscribe(CutCompletedIvent.class, new AssembleBackrestFilter(), this);
    }

    @Override
    public void inform(Event event) {

            Chair chair = (Chair) event.getData();
            chair.setTaskStatus("DONE_B", true);
            System.out.println("Assembling backrest for chair: " + chair.getName());
            eventBus.publish(new CustomEvent("BACKREST_COMPLETED", chair));

    }
}
