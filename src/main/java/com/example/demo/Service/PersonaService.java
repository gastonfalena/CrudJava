package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Persona;
import com.example.demo.Repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public void savePersona(Persona perso) {
        personaRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        //busco el objeto original
        Persona perso = this.findPersona(idOriginal);

        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);

        //guardar los cambios

        this.savePersona(perso);
    }
}
