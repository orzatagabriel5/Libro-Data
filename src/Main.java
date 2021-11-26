

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public String[] buffer, keyWords;
    public Integer ID;
    // Am folosit HahMap-uri ca sa stochez corespondente de genul editorial-groups-books etc.
    public HashMap<String, ArrayList<String>> cartiAutori = new HashMap<>();
    public HashMap<String, ArrayList<String>> editoriCarti = new HashMap<>();
    public HashMap<String, ArrayList<String>> publicCarti = new HashMap<>();

    public HashMap<String, ArrayList<String>> retailerCarti = new HashMap<>();
    public HashMap<String, ArrayList<String>> retailerTari = new HashMap<>();
    public HashMap<String, ArrayList<String>> retailerEditorialGroups = new HashMap<>();
    public HashMap<String, ArrayList<String>> retailerPublishingBrands = new HashMap<>();


    public static ArrayList<Author> authors = new ArrayList<>();
    public static ArrayList<Countries> countries = new ArrayList<>();
    public static ArrayList<Language> languages = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<PublishingRetailer> publishingRetailers = new ArrayList<>();
    public static ArrayList<EditorialGroup> editorialGroups = new ArrayList<>();
    public static ArrayList<PublishingBrand> publishingBrands = new ArrayList<>();


    public void initialize(){

        int j;
        try (BufferedReader br = new BufferedReader(new FileReader(
                    "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/authors.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                buffer = line.split("###");
                Author autor = new Author(Integer.parseInt(buffer[0]), buffer[1], buffer[2]);
                authors.add(autor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                    "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/books-authors.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                buffer = line.split("###");
                if(cartiAutori.get(buffer[0]) == null){
                    ArrayList<String> autori = new ArrayList<>();
                    autori.add(buffer[1]);
                    cartiAutori.put(buffer[0], autori);
                } else {
                    ArrayList<String> tmp = cartiAutori.get(buffer[0]);
                    tmp.add(buffer[1]);
                    cartiAutori.put(buffer[0], tmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                    "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/books.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                j = 0;
                buffer = line.split("###");
                Book carte = new Book(Integer.parseInt(buffer[0]), Integer.parseInt(buffer[4]),
                        Integer.parseInt(buffer[6]), buffer[1], buffer[2], buffer[3], buffer[7]);
                keyWords = buffer[5].split("; ");
                carte.setKeywords(keyWords);

                Author[] autoriCarte = new Author[5];
                for(String aut : cartiAutori.get(buffer[0])){
                    for(Author a : authors){
                        if(a != null) {
                            if (aut.compareTo(a.getID().toString()) == 0) {
                                autoriCarte[j] = a;
                            }
                        }
                    }
                    j++;
                }
                carte.setAuthors(autoriCarte);
                books.add(carte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/countries.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                Countries countrie = new Countries(Integer.parseInt(buffer[0]), buffer[1]);
                countries.add(countrie);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/editorial-groups-books.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                if(editoriCarti.get(buffer[0]) == null){
                    ArrayList<String> carti = new ArrayList<>();
                    carti.add(buffer[1]);
                    editoriCarti.put(buffer[0], carti);
                } else {
                    ArrayList<String> tmp = editoriCarti.get(buffer[0]);
                    tmp.add(buffer[1]);
                    editoriCarti.put(buffer[0], tmp);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/editorial-groups.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                j = 0;
                buffer = line.split("###");

                Book[] cartiEditori = new Book[50];
                for(String IDCarte : editoriCarti.get(buffer[0])){
                    for(Book book : books){
                        if(book != null){
                            if(IDCarte.compareTo(book.getID().toString()) == 0){
                                cartiEditori[j] = book;
                            }
                        }
                    }
                    j++;
                }
                EditorialGroup editorialGroup = new EditorialGroup(Integer.parseInt(buffer[0]), buffer[1], cartiEditori);
                editorialGroups.add(editorialGroup);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/languages.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                Language language = new Language(Integer.parseInt(buffer[0]), buffer[1], buffer[2]);
                languages.add(language);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/publishing-brands-books.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                if(publicCarti.get(buffer[0]) == null){
                    ArrayList<String> carti = new ArrayList<>();
                    carti.add(buffer[1]);
                    publicCarti.put(buffer[0], carti);
                } else {
                    ArrayList<String> tmp = publicCarti.get(buffer[0]);
                    tmp.add(buffer[1]);
                    publicCarti.put(buffer[0], tmp);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/publishing-brands.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                j = 0;
                buffer = line.split("###");
                Book[] cartiPublic = new Book[50];
                for(String IDCarte : publicCarti.get(buffer[0])){
                    for(Book book : books){
                        if(book != null){
                            if(IDCarte.compareTo(book.getID().toString()) == 0){
                                cartiPublic[j] = book;
                            }
                        }
                    }

                    j++;
                }
                PublishingBrand publishingBrand = new PublishingBrand(Integer.parseInt(buffer[0]), buffer[1], cartiPublic);
                publishingBrands.add(publishingBrand);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/publishing-retailers-books.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                if(retailerCarti.get(buffer[0]) == null){
                    ArrayList<String> carti = new ArrayList<>();
                    carti.add(buffer[1]);
                    retailerCarti.put(buffer[0], carti);
                } else {
                    ArrayList<String> tmp = retailerCarti.get(buffer[0]);
                    tmp.add(buffer[1]);
                    retailerCarti.put(buffer[0], tmp);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/publishing-retailers-countries.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                if(retailerTari.get(buffer[0]) == null){
                    ArrayList<String> tari = new ArrayList<>();
                    tari.add(buffer[1]);
                    retailerTari .put(buffer[0], tari);
                } else {
                    ArrayList<String> tmp = retailerTari.get(buffer[0]);
                    tmp.add(buffer[1]);
                    retailerTari.put(buffer[0], tmp);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/publishing-retailers-editorial-groups.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                if(retailerEditorialGroups.get(buffer[0]) == null){
                    ArrayList<String> edtGroups = new ArrayList<>();
                    edtGroups.add(buffer[1]);
                    retailerEditorialGroups.put(buffer[0], edtGroups);
                } else {
                    ArrayList<String> tmp = retailerEditorialGroups.get(buffer[0]);
                    tmp.add(buffer[1]);
                    retailerEditorialGroups.put(buffer[0], tmp);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/publishing-retailers-publishing-brands.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");
                if(retailerPublishingBrands.get(buffer[0]) == null){
                    ArrayList<String> pbBrands = new ArrayList<>();
                    pbBrands.add(buffer[1]);
                    retailerPublishingBrands.put(buffer[0], pbBrands);
                } else {
                    ArrayList<String> tmp = retailerPublishingBrands.get(buffer[0]);
                    tmp.add(buffer[1]);
                    retailerPublishingBrands.put(buffer[0], tmp);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/Users/gabriel.orzata/IdeaProjects/Tema-1/init/publishing-retailers.in"))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                buffer = line.split("###");

                ArrayList<Countries> tari = new ArrayList<>();
                for(String IDTara : retailerTari.get(buffer[0])){
                    for(Countries tara : countries){
                        if(tara != null){
                            if(IDTara.compareTo(tara.getID().toString()) == 0){
                                tari.add(tara);
                            }
                        }
                    }
                }

                PublishingRetailer publishingRetailer = new PublishingRetailer(150,
                            Integer.parseInt(buffer[0]), buffer[1], tari);

                for(String IDCarte : retailerCarti.get(buffer[0])){
                    for(Book book : books){
                        if(book != null){
                            if(IDCarte.compareTo(book.getID().toString()) == 0){
                                publishingRetailer.addPublishingArtifact(book);
                            }
                        }
                    }
                }

                for(String IDGrup : retailerEditorialGroups.get(buffer[0])){
                    for(EditorialGroup grup : editorialGroups){
                        if(grup != null){
                            if(IDGrup.compareTo(grup.getID().toString()) == 0){
                                publishingRetailer.addPublishingArtifact(grup);
                            }
                        }
                    }
                }

                for(String IDCarte : retailerPublishingBrands.get(buffer[0])){
                    for(PublishingBrand brand : publishingBrands){
                        if(brand != null){
                            if(IDCarte.compareTo(brand.getID().toString()) == 0){
                                publishingRetailer.addPublishingArtifact(brand);
                            }
                        }
                    }
                }
                publishingRetailers.add(publishingRetailer);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Language> getLanguagesForPublishingRetailerID (int publishingRetailerID) {
        ArrayList<Language> languagesOut = new ArrayList<>();
        Integer flag_eng = 1, flag_fre = 1, flag_spa = 1, flag_dut = 1;

        for(PublishingRetailer publishingRetailer : publishingRetailers){
            if(publishingRetailer != null){
                if(publishingRetailer.ID.compareTo(publishingRetailerID) == 0){

                    ArrayList<Book> books =  getBooksForPublishingRetailerID(publishingRetailerID);
//                  De fiecare data cand gasesc o carte in Retailer care este scrisa intr-o limba
//                  noua (care nu exista deja in lista de tari data ca output) setez un flag
//                  pentru aceasta si o adaug in lista finala de limbi.
                    for(Book carte : books){
                        if((flag_eng.compareTo(1) == 0) && (carte.languageID.compareTo(1) == 0)){
                            languagesOut.add(languages.get(0));
                            flag_eng = 2;
                        }
                        if((flag_fre.compareTo(1) == 0) && (carte.languageID.compareTo(2) == 0)){
                            languagesOut.add(languages.get(1));
                            flag_fre = 2;
                        }
                        if((flag_spa.compareTo(1) == 0) && (carte.languageID.compareTo(3) == 0)){
                            languagesOut.add(languages.get(2));
                            flag_spa = 2;
                        }
                        if((flag_dut.compareTo(1) == 0) && (carte.languageID.compareTo(5) == 0)){
                            languagesOut.add(languages.get(3));
                            flag_dut = 2;
                        }
                    }
                }
            }
        }
        return languagesOut;
    }

    public static ArrayList<Countries> getCountriesForBookID(int bookID){

        ArrayList<Countries> countriesForBook = new ArrayList<>();
        // Caut in toate instantele de tipul IPublishingArtifacts ale tututot Retailerilor
        // ID ul cartii si verific din ce tari sunt Retaileri, apoi adaug acele tari in
        // lista finala de tari data ca output.
        for(PublishingRetailer publishingRetailer : publishingRetailers){
            for(IPublishingArtifact publishingArtifact : publishingRetailer.publishingArtifacts){
                if(publishingArtifact instanceof Book){
                    if(((Book)publishingArtifact).ID.compareTo(bookID) == 0) {
                        for (Countries tara : publishingRetailer.countries) {
                            if(!countriesForBook.contains(tara)) {
                                countriesForBook.add(tara);
                            }
                        }
                    }
                }

                if(publishingArtifact instanceof EditorialGroup){
                    for(Book carte : ((EditorialGroup)publishingArtifact).books){
                        if(carte != null) {
                            if (carte.ID.compareTo(bookID) == 0) {
                                for (Countries tara : publishingRetailer.countries) {
                                    if(!countriesForBook.contains(tara)) {
                                        countriesForBook.add(tara);
                                    }
                                }
                            }
                        }
                    }
                }

                if(publishingArtifact instanceof PublishingBrand){
                    for(Book carte : ((PublishingBrand)publishingArtifact).books){
                        if(carte != null) {
                            if (carte.ID.compareTo(bookID) == 0) {
                                for (Countries tara : publishingRetailer.countries) {
                                    if(!countriesForBook.contains(tara)) {
                                        countriesForBook.add(tara);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return countriesForBook;
    }

    public static ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID){

        ArrayList<Book> books = new ArrayList<>();
        // Caut in toate instantele de tipul IPublishingArtifacts cartile continute si
        // le adaug in lista finala data ca output
        for(PublishingRetailer publishingRetailer : publishingRetailers){
            if(publishingRetailer.ID.compareTo(publishingRetailerID) == 0) {
                for (IPublishingArtifact publishingArtifact : publishingRetailer.publishingArtifacts) {
                    if (publishingArtifact instanceof Book) {
                        if (!books.contains((Book) publishingArtifact)) {
                            books.add((Book) publishingArtifact);
                        }
                    }

                    if (publishingArtifact instanceof EditorialGroup) {
                        for (Book carte : ((EditorialGroup) publishingArtifact).books) {
                            if (carte != null) {
                                if (!books.contains(carte)) {
                                    books.add(carte);
                                }
                            }
                        }
                    }

                    if (publishingArtifact instanceof PublishingBrand) {
                        for (Book carte : ((PublishingBrand) publishingArtifact).books) {
                            if (carte != null) {
                                if (!books.contains(carte)) {
                                    books.add(carte);
                                }
                            }
                        }
                    }
                }
            }
        }
        return books;
    }

    public static ArrayList<Book> getAllBooksForRetailerIDs (int retailerID1, int retailerID2){

        ArrayList<Book> books1 = getBooksForPublishingRetailerID(retailerID1);

        ArrayList<Book> books2 = getBooksForPublishingRetailerID(retailerID2);

        // Reuniunea celor doi retaileri
        for(Book carte : books2){
            if(!books1.contains(carte)){
                books1.add(carte);
            }
        }
        return books1;
    }

    public static ArrayList<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){

        int flag = 0;
        ArrayList<Book> books1 = getBooksForPublishingRetailerID(retailerID1);

        ArrayList<Book> books2 = getBooksForPublishingRetailerID(retailerID2);

        ArrayList<Book> books = new ArrayList<>();

        // Intersectia cartilor celor doi retaileri
        for(Book carte : books1){
            if(books2.contains(carte)){
                books.add(carte);
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println("Retaileri nu contin carti comune.");
        }
        return books;
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.initialize();


        System.out.println("Test getBooksForPublishingRetailerID:");
        System.out.println("TEST 1:");
        for(Book carte : getBooksForPublishingRetailerID(1)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 2:");
        for(Book carte : getBooksForPublishingRetailerID(2)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 3:");
        for(Book carte : getBooksForPublishingRetailerID(17)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 4:");
        for(Book carte : getBooksForPublishingRetailerID(14)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 5:");
        for(Book carte : getBooksForPublishingRetailerID(20)){
            System.out.println(carte.name);
        }

        System.out.println("Test getLanguagesForPublishingRetailerID");
        System.out.println("TEST 6:");
        for(Language limba : getLanguagesForPublishingRetailerID(16)){
            System.out.println(limba.name);
        }
        System.out.println("TEST 7:");
        for(Language limba : getLanguagesForPublishingRetailerID(30)){
            System.out.println(limba.name);
        }
        System.out.println("TEST 8:");
        for(Language limba : getLanguagesForPublishingRetailerID(9)){
            System.out.println(limba.name);
        }
        System.out.println("TEST 9:");
        for(Language limba : getLanguagesForPublishingRetailerID(21)){
            System.out.println(limba.name);
        }
        System.out.println("TEST 10:");
        for(Language limba : getLanguagesForPublishingRetailerID(1)){
            System.out.println(limba.name);
        }

        System.out.println("Test getCountriesForBookID:");
        System.out.println("TEST 11:");
        for(Countries tara : getCountriesForBookID(350)){
            System.out.println(tara.countryCode);
        }
        System.out.println("TEST 12:");
        for(Countries tara : getCountriesForBookID(3748)){
            System.out.println(tara.countryCode);
        }
        System.out.println("TEST 13:");
        for(Countries tara : getCountriesForBookID(4575)){
            System.out.println(tara.countryCode);
        }
        System.out.println("TEST 14:");
        for(Countries tara : getCountriesForBookID(7121)){
            System.out.println(tara.countryCode);
        }
        System.out.println("TEST 15:");
        for(Countries tara : getCountriesForBookID(204)){
            System.out.println(tara.countryCode);
        }


        System.out.println("Test getCommonBooksForRetailerIDs:");
        System.out.println("TEST 16:");
        for(Book carte : getCommonBooksForRetailerIDs(20, 26)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 17:");
        for(Book carte : getCommonBooksForRetailerIDs(8, 4)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 18:");
        for(Book carte : getCommonBooksForRetailerIDs(1, 2)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 19:");
        for(Book carte : getCommonBooksForRetailerIDs(11, 13)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 20:");
        for(Book carte : getCommonBooksForRetailerIDs(1, 6)){
            System.out.println(carte.name);
        }


        System.out.println("Test getAllBooksForRetailerIDs:");
        System.out.println("TEST 21:");
        for(Book carte : getAllBooksForRetailerIDs(7, 2)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 22:");
        for(Book carte : getAllBooksForRetailerIDs(14, 20)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 23:");
        for(Book carte : getAllBooksForRetailerIDs(18, 25)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 24:");
        for(Book carte : getAllBooksForRetailerIDs(4, 6)){
            System.out.println(carte.name);
        }
        System.out.println("TEST 25:");
        for(Book carte : getAllBooksForRetailerIDs(1, 2)){
            System.out.println(carte.name);
        }
    }
}
