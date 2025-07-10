package com.example;

import java.util.Optional;

//Creamos un dto para uusar la interfaz optional que nos permite manejar de mejor manera los null
public class PersonaDTO {
    private Optional <String>  nombre;
    private Optional <String>  correo;
    private Optional <String>  edad;

    
    
    public PersonaDTO(Optional<String> nombre, Optional<String> correo, Optional<String> edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }
    public PersonaDTO() {
    }
    public Optional<String> getNombre() {
        return nombre;
    }
    public void setNombre(Optional<String> nombre) {
        this.nombre = nombre;
    }
    public Optional<String> getCorreo() {
        return correo;
    }
    public void setCorreo(Optional<String> correo) {
        this.correo = correo;
    }
    public Optional<String> getEdad() {
        return edad;
    }
    public void setEdad(Optional<String> edad) {
        this.edad = edad;
    }
    

}
