public class PublishingBrand implements IPublishingArtifact{

    Integer ID;
    String name;
    Book[] books;

    public PublishingBrand(Integer ID, String name, Book[] books) {
        this.ID = ID;
        this.name = name;
        this.books = books;
    }

    public PublishingBrand() {
    }

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

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void afiseazaCarti() {
        for(Book b : books){
            if(b != null){
                System.out.println(b.getName() + " " + b.getID());
            }
        }
    }

    @Override
    public String Publish() {

        String rez  = new String();

        rez = "<xml>\n" +
                "\t<publishingBrand>\n" +
                "\t\t<ID>" + ID + "</ID\n" +
                "\t\t<Name>" + name + "</Name>\n" +
                "\t</publishingBrand>\n" +
                "\t<books>\n";

        for(Book carte : books){
            if(carte != null) {
                rez += "\t\t<book>\n";
                rez += "\t\t\t<title>" + carte.name + "</title>\n" +
                        "\t\t\t<subtitle>" + carte.subtitle + "</subtitle\n" +
                        "\t\t\t<isbn>" + carte.ISBN + "</isbn>\n" +
                        "\t\t\t<pageCount>" + carte.pageCount + "</pageCount>\n" + "\t\t\t<keywords>";

                for (String key : carte.keywords) {
                    if (key != null) {
                        rez += key + " ";
                    }
                }

                rez += "</keywords>\n" +
                        "\t\t\t<languageID>" + carte.languageID + "</langageID>\n" +
                        "\t\t\t<createdOn>" + carte.createdOn + "</createdOn>\n" + "\t\t\t<authors>";

                for (Author autor : carte.authors) {
                    if (autor != null) {
                        rez += autor.getFirstName() + autor.getLastName() + " ";
                    }
                }

                rez += "</authors>\n" + "\t\t</book>\n";
            }
        }

        rez += "\t</books>\n" + "</xml>";

        return rez;
    }
}
