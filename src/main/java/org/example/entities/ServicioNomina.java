package org.example.entities;

public class ServicioNomina {

    public double calcularNomina(Empleado empleado, int horasTrabajadas) {
        double salarioBase = empleado.getTarifaPorHora() * horasTrabajadas;
        if (empleado.getTipo() == TipoEmpleado.FULL_TIME) {
            return salarioBase;
        } else if (empleado.getTipo() == TipoEmpleado.PART_TIME) {
            return salarioBase * 0.8;
        } else {
            throw new IllegalArgumentException("Tipo de empleado desconocido");
        }
    }



}
