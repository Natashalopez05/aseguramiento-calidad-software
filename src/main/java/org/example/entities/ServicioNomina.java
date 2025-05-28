package org.example.entities;

public class ServicioNomina {

    public double calcularSalarioBase(Empleado empleado, int horasTrabajadas) {
        return empleado.getTarifaPorHora() * horasTrabajadas;
    }

    public double calcularSalarioExtra(Empleado empleado, int horasExtra) {
        if(empleado.getTipo() == TipoEmpleado.FULL_TIME) {
            return empleado.getTarifaPorHora() * horasExtra * 1.5;
        } else if (empleado.getTipo() == TipoEmpleado.PART_TIME) {
            return empleado.getTarifaPorHora() * horasExtra;
        } else {
            throw new IllegalArgumentException("Tipo de empleado desconocido");
        }
    }

    public double calcularNomina(Empleado empleado, int horasTrabajadas, boolean autorizacionLimite) {
        double salarioBase = calcularSalarioBase(empleado, horasTrabajadas);
        double salarioExtra = 0.0;

        if (horasTrabajadas > 40) {
            int horasExtra = horasTrabajadas - 40;
            salarioExtra = calcularSalarioExtra(empleado, horasExtra);
        }

        double salarioSemanal = salarioBase + salarioExtra;
        if(salarioSemanal > 20000 && !autorizacionLimite) {
            throw new IllegalArgumentException("El salario semanal no puede superar los 20,000 sin autorización");
        }

        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
        }

        if (empleado.getTipo() == TipoEmpleado.FULL_TIME) {
            return salarioBase;
        } else if (empleado.getTipo() == TipoEmpleado.PART_TIME) {
            return salarioBase * 0.8;
        } else {
            throw new IllegalArgumentException("Tipo de empleado desconocido");
        }
    }



}
