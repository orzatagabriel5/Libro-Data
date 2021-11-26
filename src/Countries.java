public class Countries {

    Integer ID;
    String countryCode;

    public Countries(Integer ID, String countryCode) {
        this.ID = ID;
        this.countryCode = countryCode;
    }

    public Countries(){

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
