# tema-1-orzatagabriel5
Orzata Gabriel-Nicusor 323CB
Tema 1 - Libro Data

Pentru rezolvarea temei am creeat cate un fisier pentru fiecare tip de clasa ce trebuie construita
si interfata IPublishingArtifact care este implementata de carte Book, EditoarialGroup si
PublishingBrand. Atat citirea datelor din fisierele de tip .in, cat si metodele de tip get si
testarea acestora sunt facute intr-o clasa principala Main ce contine metoda initialize in plus
fata de cele cerute in cerinta temei.

Clasa Main:
Pentru inceput am definit ArrayList-uri de tipul fiecarei clasa pentru a stoca datele citite.
Pe langa acestea am definit si HashMap-uri pentru a retine relatiile de tipul books-authors,
publishing-retailers-countries, etc.

metoda initialize:

    Pentru fiecare clasa care contine un vector de alta clasa
    (de exemplu clasa Book care are un vector de tipul Author), citesc mai intai clasa atribut
    pentru a putea stoca in clasa principala instantele initializate anterior.
metoda getBooksForPublishingRetailerID:

    Parcurg lista de publishingRetailers pana cand gasesc Retailerul cu ID-ul cerut,
    apoi parcurg si fiecare obiect de tipul IpublishingArtifact verificand daca este de tipul
    Book, EditorialGroup sau PublishingBrand. Pentru tipul Book verific daca aceasta exista
    deja in lista de carti ce urmeaza sa fie returnata ca output, iar pentru EditorialGroup
    si PublishingBrand parcurg lista de carti a acestora si fac acelasi lucru.
metoda getLanguagesForPublishingRetailerID:

    Gasesc Retailerul cu ID-ul dat si apoi verific in ce limba sunt scrise toate cartile
    acestuia.
    Folosesc getBooksForPublishingRetailer pentru a afla toate cartile continute in Retailer.
metoda getCountriesForBookID:

    Caut cartea daca ca paramentru in fiecare publishingRetailer si implicit in fiecare
    EditorialGroup si PublishingBrand al acestora si de fiecare data cand o gasesc verific
    in ce tara se afla Retailerul si o adaug in lista de tari returnata de metoda, daca nu
    exista deja.
metoda getCommonBooksForRetailerIDs:

    Folosesc metoda getBooksForPublishingRetailerID si fac intersectia acestora.
metoda getAllBooksForRetailerIDs:

    Folosesc metoda getBooksForPublishingRetailerID si fac reuniunea acestora.


Metoda publish:

    In fiecare dintre clasele care implementeaza interfata IPublishingArtifacts printez
    la output in felul specific acestora. Cand apelez metoda pentru un publishingArtifact
    se va printa in functie de ce instaceoff este artefactul deoarece interfata este implementata
    de cele 3 clase.
