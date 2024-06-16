package skhemii.labs.lab5;

import skhemii.labs.lab5.entities.Shop;
import skhemii.labs.lab5.entities.ShopManager;

import java.io.*;
import java.util.*;

/**
 * Class for handling interaction with files
 */
public class ShopFileHandler {
    private final ShopManager shopManager;
    private final String filename;

    /**
     * Constructor
     * @param filename name of the working file
     * @param shopManager ShopManager object
     */
    public ShopFileHandler(String filename, ShopManager shopManager) {
        this.filename = filename;
        if(shopManager == null)
        {
            this.shopManager = new ShopManager();
            return;
        }
        this.shopManager = shopManager;
    }

    /**
     * Saving information to file
     * @throws IOException if in the process of working with file occurs problem
     */
    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Shop shop : shopManager.getAllShops()) {
                writer.write(shop.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Return list of shops
     * @return list of shops from file
     * @throws IOException if in the process of working with file occurs problem
     */
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

    /**
     * Add record to file
     * @param shop shop, that is being added
     * @throws IOException if in the process of working with file occurs problem
     */
    public void addRecord(Shop shop) throws IOException {
        shopManager.addShop(shop);
        saveToFile();
    }

    /**
     * Remove shop from file
     * @param shopName name od shop, that is being removed
     * @throws IOException if in the process of working with file occurs problem
     */
    public void removeRecord(String shopName) throws IOException {
        for (Shop shop : shopManager.getAllShops()) {
            if (shop.getName().equals(shopName))
            {
                shopManager.removeShop(shop.getId());
            }
        }
        saveToFile();
    }

    /**
     * Search in the file by shop's name
     * @param shopName name of searched shop
     * @return shop with given name
     */
    public Shop searchByName(String shopName) {
        for (Shop shop : shopManager.getAllShops()) {
            if (shop.getName().equals(shopName)) {
                return shop;
            }
        }
        return null;
    }
}

