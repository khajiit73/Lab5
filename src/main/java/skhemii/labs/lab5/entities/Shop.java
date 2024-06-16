package skhemii.labs.lab5.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop implements Serializable {
    private int id;
    private String name;
    private String address;

    public Shop(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

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
