# Libro Data

I created a simulation of a online library where Publishing Retailers can store and publish their books.

First I read the detailes of a book and other instances of its class like authors. I use HashMaps to store matches betwen authors and books or to store every book of a Publishing Brand, Editorial Group or Publishing Retailer and than I store everything in the corespondent classes.

A book can be published by a Editorial Group, a Publishing Brand or by the author himself. Every class of those three implements the same interface that contains a publish method which writes a xml file with all the details of the book, Publishing Brand or Editorial Group. That method can be ran by every Publishing Retailer to upload a new book on the online library(supposing that the xml file is passed on the website database).
