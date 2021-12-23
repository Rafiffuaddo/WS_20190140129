/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.c.pws.c9;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rafif Fuaddoshofha
 */
@Controller
public class DataContoroller {
      /**
     *
     * @return
     */
    @CrossOrigin
     @RequestMapping(value = "/xml/datamaahasiswa", produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Datamaahasiswa> getDatamaahasiswaXML() {
        List<Datamaahasiswa> datamahasiswati = new ArrayList<>();
        
        DatamaahasiswaJpaController controller = new DatamaahasiswaJpaController();
        
        try {
            datamahasiswati = controller.findDatamaahasiswaEntities();
        } catch (Exception e) {}
        return datamahasiswati;
  
    } 
    
    @CrossOrigin
    @RequestMapping(value = "/json/datamaahasiswa", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    
    public List<Datamaahasiswa> getDataMahasiswatiJSON() {
    
        
        List <Datamaahasiswa> datamahasiswati = new ArrayList<>();
        
        DatamaahasiswaJpaController controller = new DatamaahasiswaJpaController();
        
        try {
            datamahasiswati = controller.findDatamaahasiswaEntities();
        } catch (Exception e) {}
        
        return datamahasiswati;
    }  
    
}
