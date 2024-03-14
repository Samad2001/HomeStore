package com.example.HomeStore.controller;

import com.example.HomeStore.model.dto.request.HomeRequest;
import com.example.HomeStore.model.dto.response.HomeResponse;
import com.example.HomeStore.service.HomeStoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home-store")
public class HomeStoreController {

    private final HomeStoreService homeStoreService;

    public HomeStoreController(HomeStoreService homeStoreService){
        this.homeStoreService=homeStoreService;
    }

@GetMapping
public ResponseEntity<List<HomeResponse>> getAllHomes(){
        List<HomeResponse> homes = homeStoreService.getAllHomes();
        return ResponseEntity.ok(homes);
}

@GetMapping("/id/{id}")
  public ResponseEntity<HomeResponse> getHomeById(@PathVariable Long id){
        HomeResponse homeResponse= homeStoreService.getHomeById(id);
        return ResponseEntity.ok(homeResponse);
    }

@PostMapping
    public ResponseEntity<Void> addHome(@RequestBody HomeRequest homeRequest){
        homeStoreService.addHome(homeRequest);
        return ResponseEntity.ok().build();//TODO burda niye build istifade edirik
}

@PutMapping("/id/{id}")
public ResponseEntity<Void> updateHome(@PathVariable Long id,
                                       @RequestBody HomeRequest homeRequest){
        homeStoreService.updateHome(id,homeRequest);
        return ResponseEntity.ok().build();
}

@DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteHome(@PathVariable Long id){
        homeStoreService.deleteHome(id);
        return ResponseEntity.ok().build();
}

    }
