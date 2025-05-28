package nomina;


import org.example.entities.Empleado;
import org.example.entities.ServicioNomina;
import org.example.entities.TipoEmpleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioNominaTest {

    @Test
    void calcularSalarioSinHorasExtraParaFullTime() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.FULL_TIME, 400);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularNomina(empleado, 40, false);
        assertEquals(16500, salario); // 40h x 400
    }

    @Test
    void calcularSalarioConHorasExtraParaFullTime() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.FULL_TIME, 200);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularNomina(empleado, 45, false);
        assertEquals(10000, salario);
    }

}
