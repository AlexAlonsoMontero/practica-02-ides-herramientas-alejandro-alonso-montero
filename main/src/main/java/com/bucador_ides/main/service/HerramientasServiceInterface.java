package com.bucador_ides.main.service;

import java.util.List;

import com.bucador_ides.main.model.HerramientasDto;

public interface HerramientasServiceInterface {
    public List<HerramientasDto> getHerramientas(String tecnologia);
}
