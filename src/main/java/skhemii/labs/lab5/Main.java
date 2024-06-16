package skhemii.labs.lab5;

import skhemii.labs.lab5.entities.Shop;
import skhemii.labs.lab5.entities.ShopManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ShopManager shopManager = new ShopManager();

        ShopFileHandler shopFileHandler = new ShopFileHandler("catalog.txt", shopManager);

        try{
            //populating file
            shopFileHandler.addRecord(new Shop(1, "Silpo","v Ornavi"));
            shopFileHandler.addRecord(new Shop(2, "Silpo","tam de stare Silpo"));
            shopFileHandler.addRecord(new Shop(3, "ATB","Alyaska bazar"));
            shopFileHandler.addRecord(new Shop(4, "Novus","kolo avtovokzalu"));
            shopFileHandler.addRecord(new Shop(5, "Silpo","tam de nove Silpo"));

            //reading data from file
            System.out.println("\nShops:");
            var shops = shopFileHandler.loadFromFile();
            for (Shop shop : shops) {
                System.out.println(shop.toString());
            }

            //removing record
            shopFileHandler.removeRecord("Silpo");

            System.out.println("\nShops after deleting:");
            var shopsAfterDeleting = shopFileHandler.loadFromFile();
            for (Shop shop : shopsAfterDeleting) {
                System.out.println(shop.toString());
            }

            //search by name
            System.out.println("\nShops by search:");
            var shopSearched = shopFileHandler.searchByName("ATB");
            System.out.println(shopSearched.toString());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}