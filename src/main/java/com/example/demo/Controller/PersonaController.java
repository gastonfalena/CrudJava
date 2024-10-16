package com.example.demo.Controller;

import com.example.demo.Model.Persona;
import com.example.demo.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return persoServ.getPersonas();
    }
    @PostMapping("personas/crear")
    public String savePersona (@RequestBody Persona perso){
        persoServ.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        
    }


}
