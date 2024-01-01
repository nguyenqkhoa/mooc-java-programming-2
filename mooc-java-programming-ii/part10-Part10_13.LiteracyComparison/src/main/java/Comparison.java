public class Comparison{

    private String gender;
    private String country;
    private int year;
    private double literate;

    public Comparison(String gender, String country, int year, double literate) {
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literate = literate;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getLiterate() {
        return literate;
    }

    @Override
    public String toString(){
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literate;
    }

}
