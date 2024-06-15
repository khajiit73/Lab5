package skhemii.labs.lab5;

import skhemii.labs.lab5.entities.Shop;
import skhemii.labs.lab5.entities.ShopManager;

public class Main {
    public static void main(String[] args) {

        ShopManager manager = new ShopManager();

        manager.addShop(new Shop(1, "Silpo","v Ornavi"));
        manager.addShop(new Shop(2, "Silpo","tam de stare Silpo"));
        manager.addShop(new Shop(3, "ATB","Alyaska bazar"));
        manager.addShop(new Shop(4, "Novus","kolo avtovokzalu"));
        manager.addShop(new Shop(5, "Silpo","tam de nove Silpo"));

        System.out.println("All shops:");
        for (Shop shop: manager.getAllShops()) {
            System.out.println(shop.toString());
        }

        System.out.println("\nAll Silpo's:");
        for (Shop shop: manager.findShopsByName("Silpo")) {
            System.out.println(shop.toString());
        }

        System.out.println("\nAll shops sorted by name:");
        for (Shop shop: manager.getAllShopsSortedByName()) {
            System.out.println(shop.toString());
        }

        manager.removeShop(1);
        manager.removeShop(5);

        System.out.println("\nAll shops after removing some:");
        for (Shop shop: manager.getAllShops()) {
            System.out.println(shop.toString());
        }
    }
}