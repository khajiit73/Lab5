package skhemii.labs.lab5.entities;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manager for working with shops
 */
public class ShopManager{
    private HashMap<Integer, Shop> shopMap;

    /**
     * Initializing a ShopManager by creating empty HashMap
     */
    public ShopManager() {
        shopMap = new HashMap<>();
    }

    /**
     * Add shop to ShopManager
     * @param shop shop, that should be added
     */
    public void addShop(Shop shop) {
        shopMap.put(shop.getId(), shop);
    }
    /**
     * Remove shop from ShopManager
     * @param id id of an element, that should be removed
     */
    public void removeShop(Integer id) {
        shopMap.remove(id);
    }

    /**
     * Returns shop by given id
     * @param id given id for search
     * @return shop with given index
     */
    public Shop getShop(Integer id) {
        return shopMap.get(id);
    }

    /**
     * Returns list of shops in manager
     * @return list of shops
     */
    public List<Shop> getAllShops() {
        return shopMap.values().stream().toList();
    }

    /**
     * Clear HashMap of shops
     */
    public void clearShops() {shopMap = new HashMap<>();}

    /**
     * Search of shop by name
     * @param name name of shop
     * @return shop with given name
     */
    public List<Shop> findShopsByName(String name) {
        return shopMap.values().stream()
                .filter(shop -> shop.getName().equals(name))
                .collect(Collectors.toList());
    }
    /**
     * Search of shop by address
     * @param address address of shop
     * @return shop with given address
     */
    public List<Shop> findShopsByAddress(String address) {
        return shopMap.values().stream()
                .filter(shop -> shop.getName().equals(address))
                .collect(Collectors.toList());
    }

    /**
     * Get shops sorted by id
     * @return list of shops, sorted by id
     */
    public List<Shop> getAllShopsSortedById() {
        return shopMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
    /**
     * Get shops sorted by name
     * @return list of shops, sorted by name
     */
    public List<Shop> getAllShopsSortedByName() {
        return shopMap.values().stream()
                .sorted(Comparator.comparing(Shop::getName))
                .collect(Collectors.toList());
    }
    /**
     * Get shops sorted by address
     * @return list of shops, sorted by address
     */
    public List<Shop> getAllShopsSortedByAddress() {
        return shopMap.values().stream()
                .sorted(Comparator.comparing(Shop::getAddress))
                .collect(Collectors.toList());
    }
}
