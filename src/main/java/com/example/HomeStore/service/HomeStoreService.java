package com.example.HomeStore.service;

import com.example.HomeStore.model.dto.request.HomeRequest;
import com.example.HomeStore.model.dto.response.HomeResponse;

import java.util.List;

public interface HomeStoreService {

    List<HomeResponse> getAllHomes();
    HomeResponse getHomeById(Long id);
    void addHome(HomeRequest homeRequest);
    void updateHome(Long id, HomeRequest homeRequest);
    void deleteHome(Long id);


}
