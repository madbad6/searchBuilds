package model;

import java.util.Objects;

public class Root {

    private String city;
    private String street;
    private int house;
    private int floor;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return city + ", " + street + ", " + house + ", " + floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return house == root.house
                && floor == root.floor
                && Objects.equals(city, root.city)
                && Objects.equals(street, root.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, floor);
    }
}
