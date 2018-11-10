package com.kotlin.samples.kotlinapp.model;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 11/3/18
 */
public class PersonaJava {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    public PersonaJava(int id, String nombre, String apellido, String email, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
