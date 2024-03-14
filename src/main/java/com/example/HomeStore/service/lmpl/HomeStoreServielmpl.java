package com.example.HomeStore.service.lmpl;

import com.example.HomeStore.mapper.HomeStoreMapper;
import com.example.HomeStore.model.dto.request.HomeRequest;
import com.example.HomeStore.model.dto.response.HomeResponse;
import com.example.HomeStore.model.entity.Home;
import com.example.HomeStore.repository.HomeStoreRepository;
import com.example.HomeStore.service.HomeStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeStoreServielmpl implements HomeStoreService {


    private HomeStoreMapper homeStoreMapper;
    private HomeStoreRepository homeStoreRepository;

    public HomeStoreServielmpl(HomeStoreRepository homeStoreRepository, HomeStoreMapper homeStoreMapper){
        this.homeStoreRepository=homeStoreRepository;
        this.homeStoreMapper=homeStoreMapper;
    }

    @Override
    public List<HomeResponse> getAllHomes() {
        List<Home>  homes = homeStoreRepository.getAll();
        List<HomeResponse> homeResponseList =  homeStoreMapper.toHomeResponseList(homes);

        return homeResponseList;
    }

    @Override
    public HomeResponse getHomeById(Long id) {
       Home home = homeStoreRepository.getById(id);

        return homeStoreMapper.toHomeResponse(home);
    }

    @Override
    public void addHome(HomeRequest homeRequest) {
        Home home = homeStoreMapper.toHome(homeRequest);
        homeStoreRepository.insert(home);
    }

    @Override
    public void updateHome(Long id, HomeRequest homeRequest) {
        Home home = homeStoreMapper.toHome(id,homeRequest);
        homeStoreRepository.update(home);
    }

    @Override
    public void deleteHome(Long id) {
        homeStoreRepository.delete(id);
    }
}
