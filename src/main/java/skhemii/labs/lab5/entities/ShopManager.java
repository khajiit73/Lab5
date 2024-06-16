package skhemii.labs.lab5.entities;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShopManager implements Serializable {
    private HashMap<Integer, Shop> shopMap;

    public ShopManager() {
        shopMap = new HashMap<>();
    }

    public void addShop(Shop shop) {
        shopMap.put(shop.getId(), shop);
    }
    public void removeShop(Integer id) {
        shopMap.remove(id);
    }
    public Shop getShop(Integer id) {
        return shopMap.get(id);
    }
    public List<Shop> getAllShops() {
        return shopMap.values().stream().toList();
    }
    public void clearShops() {shopMap = new HashMap<>();}

    public Shop findShopById(int id) {
        return shopMap.get(id);
    }

    public List<Shop> findShopsByName(String name) {
        return shopMap.values().stream()
                .filter(shop -> shop.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Shop> findShopsByAddress(String address) {
        return shopMap.values().stream()
                .filter(shop -> shop.getName().equals(address))
                .collect(Collectors.toList());
    }

    public List<Shop> getAllShopsSortedById() {
        return shopMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Shop> getAllShopsSortedByName() {
        return shopMap.values().stream()
                .sorted(Comparator.comparing(Shop::getName))
                .collect(Collectors.toList());
    }

    public List<Shop> getAllShopsSortedByAddress() {
        return shopMap.values().stream()
                .sorted(Comparator.comparing(Shop::getAddress))
                .collect(Collectors.toList());
    }
}
