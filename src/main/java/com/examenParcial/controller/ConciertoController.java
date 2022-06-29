/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenParcial.controller;
import com.examenParcial.entity.Concierto;
import com.examenParcial.entity.Lugar;
import com.examenParcial.service.IConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.examenParcial.service.ILugarService;
/**
 *
 * @author Jason Perez
 */
@Service
public class ConciertoController {
    
    @Autowired
    private IConciertoService ConciertoService;
    
    @Autowired
    private ILugarService LugarService;
    
    @GetMapping("/concierto")
    public String index (Model model){
        List<Concierto> listaConcierto = ConciertoService.getAllConcierto();
        model.addAttribute("titulo","Concierto");
        model.addAttribute("concierto",listaConcierto);
        return "concierto";
    }
    
    @GetMapping("/conciertoN")
    public String crearConcierto (Model model){
        List<Lugar> listaLugar = LugarService.listCountry();
        model.addAttribute("concierto",new Concierto());
        model.addAttribute("lugar",listaLugar);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarConcierto (@ModelAttribute Concierto concierto){
        ConciertoService.saveConcierto(concierto);
        return "redirect:/concierto";
    }
    
    @GetMapping("/editConcierto/{id}")
    public String editarConcierto (@PathVariable("id")Long idConcierto, Model model){
        Concierto concierto = ConciertoService.getConciertoById(idConcierto);
        List<Lugar> listaLugar = LugarService.listCountry();
        model.addAttribute("concierto",concierto);
        model.addAttribute("lugar",listaLugar);
        return "crear";
    }
    
    @GetMapping("/delete/{id}") //eliminar elemento
    public String eliminarProducto (@PathVariable("id") Long idProducto) {
        ConciertoService.delete(idProducto);
        return "redirect:/producto";
    }
}
