
package com.emergentes.modelo;

public class Pacientes {
    private int id;
    private String nombre;
    private int peso;
    private double talla;
    private String vacuna;

    public Pacientes(){
        id = 0;
        nombre = "";
        peso = 0;
        talla = 0.0;
        vacuna = "";
    }

    public Pacientes(int id, String nombre, int peso, double talla, String vacuna) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.talla = talla;
        this.vacuna = vacuna;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

}
