import java.util.ArrayList;

public class PublishingRetailer {

    private Integer dim = 0;
    Integer ID;
    String name;
    ArrayList<Countries> countries = new ArrayList<>();
    IPublishingArtifact[] publishingArtifacts;


    public PublishingRetailer(int size, Integer ID, String name, ArrayList<Countries> countries) {
        this.publishingArtifacts = new IPublishingArtifact[size];
        this.ID = ID;
        this.name = name;
        this.countries = countries;
    }

    public PublishingRetailer() {}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Countries> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Countries> countries) {
        this.countries = countries;
    }

    public void addPublishingArtifact(IPublishingArtifact artifact){
        publishingArtifacts[dim] = artifact;
        dim++;
    }

    public void publishAll() {
        for (int i = 0; i < dim; i++) {
            System.out.println(publishingArtifacts[i].Publish());
        }
    }


}
