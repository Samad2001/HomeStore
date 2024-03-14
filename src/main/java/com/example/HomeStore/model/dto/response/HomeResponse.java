package com.example.HomeStore.model.dto.response;

import com.example.HomeStore.model.entity.Home;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Objects;

public class HomeResponse {

    private Long id;
    private Integer area;
    private Integer rooms;
    private Integer price;
    private String location;
    private String status;

    public HomeResponse(Long id,
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

    public static HomeStoreBuilder builder(){
        return new HomeStoreBuilder();
    }
    public static class HomeStoreBuilder{
        private Long id;
        private Integer area;
        private Integer rooms;
        private Integer price;
        private String location;
        private String status;

       public HomeStoreBuilder id(Long id){
           this.id=id;
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

        public HomeResponse build(){
           HomeResponse homeResponse = new HomeResponse(
                   this.id,
                   this.area,
                   this.rooms,
                   this.price,
                   this.location,
                   this.status
           );
           return homeResponse;
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
        if (!(o instanceof HomeResponse that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(area, that.area) && Objects.equals(rooms, that.rooms) && Objects.equals(price, that.price) && Objects.equals(location, that.location) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, rooms, price, location, status);
    }

    @Override
    public String toString() {
        return "HomeResponse{" +
                "id=" + id +
                ", area=" + area +
                ", rooms=" + rooms +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
