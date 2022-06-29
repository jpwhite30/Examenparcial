/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenParcial.service;

import com.examenParcial.entity.Lugar;
import com.examenParcial.repository.LugarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jason Perez
 */
@Service
public class LugarService implements ILugarService{

    @Autowired
    private LugarRepository lugarRepository;

    @Override
    public List<Lugar> listCountry() {
        return (List<Lugar>) lugarRepository.findAll();
    }
}
