package com.example.HomeStore.repository;

import com.example.HomeStore.model.entity.Home;

import java.util.List;

public interface HomeStoreRepository {

    List<Home>  getAll();
    Home  getById(Long id);
    boolean insert(Home home);
    boolean update(Home home);
    boolean delete(Long id);

}
