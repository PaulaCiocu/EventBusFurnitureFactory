import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidEventTypeException {
        EventService eventService=EventService.instance();
        ArrayList<Employee> employees=new ArrayList<>();
        List<Chair> chairList=new ArrayList<>();

        CutSeatEmployee cutSeatEmployee=new CutSeatEmployee(eventService);
        AssembleFeetEmployee assembleFeetEmployee=new AssembleFeetEmployee(eventService);
        AssembleBackrestEmployee assembleBackrestEmployee=new AssembleBackrestEmployee(eventService);
        AssembleStabilizerBar assembleStabilizerBar=new AssembleStabilizerBar(eventService);
        PackageEmployee packageEmployee=new PackageEmployee(eventService);

        CutSeatEmployee cutSeatEmployee2=new CutSeatEmployee(eventService);
        AssembleFeetEmployee assembleFeetEmployee2=new AssembleFeetEmployee(eventService);
        AssembleBackrestEmployee assembleBackrestEmployee2=new AssembleBackrestEmployee(eventService);
        AssembleStabilizerBar assembleStabilizerBar2=new AssembleStabilizerBar(eventService);
        PackageEmployee packageEmployee2=new PackageEmployee(eventService);


        employees.add(cutSeatEmployee);
        employees.add(cutSeatEmployee2);
        employees.add(assembleBackrestEmployee);
        employees.add(assembleFeetEmployee);
        employees.add(packageEmployee);
        employees.add(packageEmployee2);
        employees.add(assembleStabilizerBar2);
        employees.add(assembleFeetEmployee2);
        employees.add(assembleBackrestEmployee2);
        employees.add(assembleStabilizerBar2);

        Chair chair=new Chair("Chair1");
        Chair chair2=new Chair("Chair2");

        chairList.add(chair);
        chairList.add(chair2);


        for(Employee e:employees){
            e.subscribeToEvents();
        }

        eventService.publish(new CustomEvent("START_CUTTING", chair));
        eventService.publish(new CustomEvent("START_CUTTING", chair2));

    }
}