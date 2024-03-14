package com.example.HomeStore.mapper;

import com.example.HomeStore.model.dto.request.HomeRequest;
import com.example.HomeStore.model.dto.response.HomeResponse;
import com.example.HomeStore.model.entity.Home;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //This annotation indicates that this class is a Spring component, meaning it can be automatically detected and managed by Spring during application startup.
public class HomeStoreMapper {


    public List<HomeResponse>  toHomeResponseList(List<Home> homeList){
        List<HomeResponse> homeResponseList = new ArrayList<>();

        for (Home home : homeList){
            HomeResponse homeResponse = toHomeResponse(home);
            homeResponseList.add(homeResponse);
        }
        return homeResponseList;
    }

    public HomeResponse toHomeResponse(Home home){
        HomeResponse homeResponse = HomeResponse.builder()
                .id(home.getId())
                .area(home.getArea())
                .rooms(home.getRooms())
                .price(home.getPrice())
                .location(home.getLocation())
                .status(home.getStatus())
                .build();
        return homeResponse;
    }


    public Home toHome(HomeRequest homeRequest){
         return  Home.builder()
                 .area(homeRequest.getArea())
                 .rooms(homeRequest.getRooms())
                 .price(homeRequest.getPrice())
                 .location(homeRequest.getLocation())
                 .status(homeRequest.getStatus())
                 .build();
    }


    public Home toHome(Long id,HomeRequest homeRequest){
        return Home.builder()
                .id(id)/*burda niye get etmirik*/
                .area(homeRequest.getArea())
                .rooms(homeRequest.getRooms())
                .price(homeRequest.getPrice())
                .location(homeRequest.getLocation())
                .status(homeRequest.getStatus())
                .build();




    }

}
