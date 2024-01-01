import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {

    private ArrayList<Person> persons = new ArrayList<>();

    public Employees() {
    }

    public void add(Person personToAdd){
        persons.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd){
        for (Person p: peopleToAdd) {
            persons.add(p);
        }
    }

    public void print(){
        for (Person p: persons) {
            System.out.println(p.toString());
        }
    }

    public void print(Education education){
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            if (person.getEducation() == education){
                System.out.println(person.toString());
            }
        }
    }

    public void fire(Education education){
        Iterator<Person> iterator = persons.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }

}
