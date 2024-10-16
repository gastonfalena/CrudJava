package com.example.demo.Controller;

import com.example.demo.Model.Persona;
import com.example.demo.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    @GetMapping("/traer")
    public List<Persona> getPersonas() {
        return persoServ.getPersonas();
    }
    @PostMapping("/crear")
    public String savePersona (@RequestBody Persona perso){
        persoServ.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PutMapping("/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
                               @RequestParam(required = false,name="id") Long nuevaId,
                               @RequestParam(required = false,name="nombre") String nuevoNombre,
                               @RequestParam(required = false,name="apellido") String nuevoApellido,
                               @RequestParam(required = false,name="edad") int nuevaEdad){
        persoServ.editPersona(id_original, nuevaId, nuevoNombre,nuevoApellido,nuevaEdad);
        Persona perso = persoServ.findPersona(nuevaId);
        return perso;

    }


}
