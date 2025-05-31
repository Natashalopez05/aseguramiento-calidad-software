package nomina;


import org.example.entities.Empleado;
import org.example.entities.ServicioNomina;
import org.example.entities.TipoEmpleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicioNominaTest {

    @Test
    void calcularSalarioSinHorasExtraParaFullTime() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.FULL_TIME, 400);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularNomina(empleado, 40, false);
        assertEquals(16500, salario);
    }

    @Test
    void calcularSalarioConHorasExtraParaFullTime() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.FULL_TIME, 200);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularNomina(empleado, 45, false);
        assertEquals(10000, salario);
    }

    @Test
    void salarioSinHorasExtraParaPartTime() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.PART_TIME, 400);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularNomina(empleado, 40, false);
        assertEquals(13200, salario);
    }

    @Test
    void lanzarExcepcionPorHorasNegativas() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.FULL_TIME, 200);
        ServicioNomina servicio = new ServicioNomina();
        assertThrows(IllegalArgumentException.class, () -> servicio.calcularNomina(empleado, -5, false));
    }

    @Test
    void lanzarExcepcionSiEmpleadoEsNulo() {
        ServicioNomina servicio = new ServicioNomina();
        assertThrows(IllegalArgumentException.class, () -> servicio.calcularNomina(null, 40, false));
    }

    @Test
    void lanzarExcepcionSiSalarioSemanalExcedeLimiteSinAutorizacion() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.FULL_TIME, 500);
        ServicioNomina servicio = new ServicioNomina();
        assertThrows(IllegalArgumentException.class, () -> servicio.calcularNomina(empleado, 45, false));
    }

}
