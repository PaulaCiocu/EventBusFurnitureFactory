import java.util.ArrayList;
import java.util.List;


public class EventService {

    private final Class<?> eventClass= Event.class;
    protected List<Subscription> subscriptions;
    static private EventService singleton = null;

    private EventService() {
        subscriptions = new ArrayList<>();
    }

    static public EventService instance() {
        if (singleton == null)
            singleton = new EventService();
        return singleton;
    }

    public void publish(Event event) {
        for (Subscription subscription : subscriptions) {
            if (subscription.eventType.isAssignableFrom(event.getClass())
                    && (subscription.filter == null || subscription.filter.apply(event)))
                subscription.subscriber.inform(event);
        }
    }
    public void subscribe(Class<?> eventType, Filter filter, Subscriber subscriber)
            throws InvalidEventTypeException {
        if (!eventClass.isAssignableFrom(eventType))
            throw new InvalidEventTypeException();
        // Prevent duplicate subscriptions
        Subscription subscription = new Subscription(eventType, filter, subscriber);
        if (!subscriptions.contains(subscription))
            subscriptions.add(subscription);
    }

    public void unsubscribe(Class<?> eventType, Filter filter, Subscriber subscriber)
            throws InvalidEventTypeException {
        if (!eventClass.isAssignableFrom(eventType))
            throw new InvalidEventTypeException();
        subscriptions.remove(new Subscription(eventType, filter, subscriber));
    }

}


