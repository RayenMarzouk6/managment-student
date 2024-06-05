package com.example.projetspringboot.controller;


import com.example.projetspringboot.entities.DetailEquipe;
import com.example.projetspringboot.service.DetailEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DetailEquipe")
public class DetailEquipeController {
    @Autowired
    DetailEquipeService detailEquipeService;
    @GetMapping("/retrieve-all-DetailEquipe")
    public List<DetailEquipe> getDetailEquipes() {

        List<DetailEquipe> listDetailEquipes = detailEquipeService.findAll();
        return listDetailEquipes;
    }
    @GetMapping("/retrieve-all-DetailEquipeID/{id}")
    @ResponseBody
    public DetailEquipe getContratsbyid(@PathVariable Long id){

        DetailEquipe detailEquipe = detailEquipeService.findByIdDetailEquipe(id);
        return detailEquipe ;
    }

    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        detailEquipeService.addDetailEquipe(detailEquipe);
        return detailEquipe;
    }

    @DeleteMapping("/deleteDetailEquipe/{id}")
    @ResponseBody
    public void deleteDetailEquipe(@PathVariable Long id) {
        detailEquipeService.DeletedetailEquipe(id);

    }

    @PutMapping("/updateDetailEquipe/{id}")
    @ResponseBody
    public DetailEquipe updateDetailEquipe(@PathVariable Long id ,@RequestBody DetailEquipe c) {
        DetailEquipe detailEquipe =detailEquipeService.updateDetailEquipe(id,c);
        return detailEquipe;
    }
}
