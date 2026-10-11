package com.bucador_ides.main.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bucador_ides.main.model.HerramientasDto;
import com.bucador_ides.main.service.HerramientasService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class HerramientasController {

    private HerramientasService herramientasService;

    public HerramientasController(HerramientasService herramientasService) {
        this.herramientasService = herramientasService;
    }

    @GetMapping(value = "tecnologia", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HerramientasDto> getMethodName(@RequestParam String tecnologia) {
        return herramientasService.getHerramientas(tecnologia);
    }

}
