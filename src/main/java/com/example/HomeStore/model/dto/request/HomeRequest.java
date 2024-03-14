package com.example.HomeStore.model.dto.request;

import com.example.HomeStore.model.entity.Home;

import java.util.Objects;

public class HomeRequest {


    private Integer area;
    private Integer rooms;
    private Integer price;
    private String location;
    private String status;

    public HomeRequest(Integer area,
                       Integer rooms,
                       Integer price,
                       String location,
                       String status) {
        this.area = area;
        this.rooms = rooms;
        this.price = price;
        this.location = location;
        this.status = status;
    }


    public static class HomeStoreBuilder{
        private Integer area;
        private Integer rooms;
        private Integer price;
        private String location;
        private String status;

        public HomeStoreBuilder area(Integer area){
            this.area=area;
            return this;
        }
        public HomeStoreBuilder rooms(Integer rooms){
          this.rooms=rooms;
          return this;
        }

        public HomeStoreBuilder price(Integer price){
          this.price=price;
          return this;
        }

        public HomeStoreBuilder location(String location){
            this.location=location;
            return this;
        }

     public HomeStoreBuilder status(String status){
            this.status=status;
            return this;
        }

        public HomeRequest build(){
            HomeRequest homeRequest = new HomeRequest(
                    this.area,
                    this.rooms,
                    this.price,
                    this.location,
                    this.status
            );
            return homeRequest;
        }
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
        if (!(o instanceof HomeRequest that)) return false;
        return Objects.equals(area, that.area) && Objects.equals(rooms, that.rooms) && Objects.equals(price, that.price) && Objects.equals(location, that.location) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, rooms, price, location, status);
    }

    @Override
    public String toString() {
        return "HomeRequest{" +
                "area=" + area +
                ", rooms=" + rooms +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
