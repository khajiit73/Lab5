package skhemii.labs.lab5;

import skhemii.labs.lab5.entities.Shop;
import skhemii.labs.lab5.entities.ShopManager;

import java.io.*;
import java.util.*;

public class ShopFileHandler {
    private final ShopManager shopManager;
    private final String filename;

    public ShopFileHandler(String filename, ShopManager shopManager) {
        this.filename = filename;
        if(shopManager == null)
        {
            this.shopManager = new ShopManager();
            return;
        }
        this.shopManager = shopManager;
    }

    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Shop shop : shopManager.getAllShops()) {
                writer.write(shop.toString());
                writer.newLine();
            }
        }
    }

    public List<Shop> loadFromFile() throws IOException {
        shopManager.clearShops();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                shopManager.addShop(Shop.fromString(line));
            }
        }
        return shopManager.getAllShops();
    }

    public void addRecord(Shop shop) throws IOException {
        shopManager.addShop(shop);
        saveToFile();
    }

    public void removeRecord(String shopName) throws IOException {
        for (Shop shop : shopManager.getAllShops()) {
            if (shop.getName().equals(shopName))
            {
                shopManager.removeShop(shop.getId());
            }
        }
        saveToFile();
    }

    public Shop searchByName(String shopName) {
        for (Shop shop : shopManager.getAllShops()) {
            if (shop.getName().equals(shopName)) {
                return shop;
            }
        }
        return null;
    }
}

