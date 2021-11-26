public class Language {

    Integer ID;
    String code, name;

    public Language(Integer ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
    }

    public Language() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void afiseazaDate() {
        System.out.println(this.ID + " " + this.code + " " + this.name);
    }
}
