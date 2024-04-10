public class CutSeatEmployee implements Employee, Subscriber {
    private final EventService eventBus;

    public CutSeatEmployee(EventService eventBus) {
        this.eventBus = eventBus;
    }

    public void subscribeToEvents() throws InvalidEventTypeException{
        eventBus.subscribe(Event.class, new CutSeatFilter(), this);
    }

    @Override
    public void inform(Event event) {
        if (event.getType().equals("START_CUTTING")) {
            Chair chair = (Chair) event.getData();
            chair.setTaskStatus("DONE_C", true);
            System.out.println("Seat cut for chair: " + chair.getName());
            eventBus.publish(new CutCompletedIvent("CUT_COMPLETED", chair));
        }
    }
}
