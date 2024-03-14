package com.example.HomeStore.model.entity;

import java.util.Objects;

public class Home {

    private Long id;
    private Integer area;
    private Integer rooms;
    private Integer price;
    private String location;
    private String status;

    public Home(Long id,
                Integer area,
                Integer rooms,
                Integer price,
                String location,
                String status) {
        this.id = id;
        this.area = area;
        this.rooms = rooms;
        this.price = price;
        this.location = location;
        this.status = status;
    }

    public static HomeStoreBuilder builder() {
        return new HomeStoreBuilder();
    }

    public static class HomeStoreBuilder {

        private Long id;
        private Integer area;
        private Integer rooms;
        private Integer price;
        private String location;
        private String status;


        //id(Long id): This method takes a Long argument and sets the id field of the IdCardBuilder instance

        public HomeStoreBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public HomeStoreBuilder area(Integer area) {
            this.area = area;
            return this;
        }

        public HomeStoreBuilder rooms(Integer rooms) {
            this.rooms = rooms;
            return this;
        }

        public HomeStoreBuilder price(Integer price) {
            this.price = price;
            return this;
        }

        public HomeStoreBuilder location(String location) {
            this.location = location;
            return this;
        }

        public HomeStoreBuilder status(String status) {
            this.status = status;
            return this;
        }

        //This method creates a new Home object using the values stored in the current HomeBuilder instance.
        // It passes all the field values as arguments to the Home constructor and returns the newly created Home object
        public Home build() {
            Home home = new Home(
                    this.id,
                    this.area,
                    this.rooms,
                    this.price,
                    this.location,
                    this.status
            );
            return home;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Home home)) return false;
        return Objects.equals(id, home.id) && Objects.equals(area, home.area) && Objects.equals(rooms, home.rooms) && Objects.equals(price, home.price) && Objects.equals(location, home.location) && Objects.equals(status, home.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, rooms, price, location, status);
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", area=" + area +
                ", rooms=" + rooms +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
