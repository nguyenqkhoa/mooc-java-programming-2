public class Teacher extends Person{
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    public Teacher(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return super.toString() + "\n  salary " + this.salary + " euro/month";
    }
}
