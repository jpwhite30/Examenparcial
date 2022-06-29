/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examenParcial.service;

import com.examenParcial.entity.Concierto;
import java.util.List;

/**
 *
 * @author Jason Perez
 */
public interface IConciertoService {
    public List<Concierto> getAllConcierto();
    public Concierto getConciertoById(long id);
    public void saveConcierto(Concierto concierto);
    public void delete(long id);
}
