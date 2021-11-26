public class Book implements IPublishingArtifact {

    Integer ID, pageCount, languageID;
    String name, subtitle, ISBN, createdOn;
    String[] keywords;
    Author[] authors;

    public Book(Integer ID, Integer pageCount, Integer languageID, String name,
                String subtitle, String ISBN, String createdOn) {
        this.ID = ID;
        this.pageCount = pageCount;
        this.languageID = languageID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.createdOn = createdOn;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void afiseazaAutori(){
        for(Author a : authors) {
            if (a != null){
                System.out.println(a.getFirstName() + " " + a.getLastName());
            }
        }
    }


    @Override
    public String Publish() {
        String rez = new String();
        rez = "<xml>\n " +
                "\t<title>" + name + "</title>\n" +
                "\t<subtitle>" + subtitle + "</subtitle\n" +
                "\t<isbn>" + ISBN + "</isbn>\n" +
                "\t<pageCount>" + pageCount + "</pageCount>\n" + "\t<keywords>";

        for(String key : keywords){
            if(key != null) {
                rez += key + " ";
            }
        }

        rez += "</keywords>\n" +
                "\t<languageID>" + languageID + "</langageID>\n" +
                "\t<createdOn>" + createdOn + "</createdOn>\n" + "\t<authors>";

        for(Author autor : authors){
            if(autor != null) {
                rez += autor.getFirstName() + autor.getLastName() + " ";
            }
        }

        rez += "</authors>\n" + "</xml>\n";

        return rez;

    }
}
