package skhemii.labs.lab5.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Shop entity
 */
public class Shop{
    private int id;
    private String name;
    private String address;

    /**
     * Constructor
     * @param id id of the shop
     * @param name name of the shop
     * @param address address of the shop
     */
    public Shop(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /**
     * Get id of the shop
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id of the shop
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get name of the shop
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Set name of the shop
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get address of the shop
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Set address of the shop
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id && Objects.equals(name, shop.name) && Objects.equals(address, shop.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shop{");
        sb.append("id=").append(id);
        sb.append(",name=").append(name);
        sb.append(",address=").append(address);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Convert string representation of the shop to Shop object
     * @param shopString string representation of the shop
     * @return Shop object
     */
    public static Shop fromString(String shopString) {
        // Regular expression to extract the values
        Pattern pattern = Pattern.compile("Shop\\{id=(\\d+),name=([^,]+),address=([^}]+)}");
        Matcher matcher = pattern.matcher(shopString);

        if (matcher.find()) {
            // Extracted values
            int id = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2);
            String address = matcher.group(3);
            return new Shop(id, name, address);
        }
        else {
            return null;
        }
    }
}
