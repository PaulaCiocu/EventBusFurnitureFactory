public class PackageEmployee implements Employee, Subscriber{
    private final EventService eventBus;

    public PackageEmployee(EventService eventBus) {
        this.eventBus = eventBus;
    }

    public void subscribeToEvents() throws InvalidEventTypeException{
        eventBus.subscribe(Event.class, new PackageFilter(), this);
    }

    @Override
    public void inform(Event event) {
        if (event.getType().equals("BACKREST_COMPLETED") || event.getType().equals("STABILIZER_COMPLETED")) {
            Chair chair = (Chair) event.getData();
            chair.setTaskStatus("DONE_P", true);
            System.out.println("Package ready for chair: " + chair.getName()+"\n");
            eventBus.publish(new CustomEvent("PACKAGE_DONE", chair));
        }
    }
}
