public class Student extends Person{

    private int studyCredit;

    public Student(String name, String address, int studyCredit) {
        super(name, address);
        this.studyCredit = studyCredit;
    }

    public Student(String name, String address) {
        super(name, address);
    }

    public void study(){
        studyCredit++;
    }

    public int credits(){
        return studyCredit;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  Study credits " + this.studyCredit;
    }
}
