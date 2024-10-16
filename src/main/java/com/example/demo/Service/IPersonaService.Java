package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Persona;

public interface IPersonaService {

    // método para traer a todas las personas
    // lectura
    public List<Persona> getPersonas();

    // alta
    public void savePersona(Persona perso);

    // baja
    public void deletePersona(Long id);

    // lectura de un solo objeto
    public Persona findPersona(Long id);

    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);

}
