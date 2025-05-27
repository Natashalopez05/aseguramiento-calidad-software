package org.example.entities;

public class Empleado {
    private String nombre;
    private TipoEmpleado tipo;
    private double tarifaPorHora;


    public Empleado(String nombre, TipoEmpleado tipoEmpleado, double tarifaPorHora) {
        this.nombre = nombre;
        this.tipo = tipoEmpleado;
        this.tarifaPorHora = tarifaPorHora;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public TipoEmpleado getTipo() {
        return tipo;
    }
}
