public class Books {

    private String name;
    private int age;

    public Books(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name + " (recommended for " + this.age + " year-olds or older)";
    }
}
