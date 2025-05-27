package nomina;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioNominaTest {
    @Test
    void calcularSalarioSinHorasExtraParaFullTime() {
        Empleado empleado = new Empleado("Natasha", TipoEmpleado.FULL_TIME, 400);
        ServicioNomina servicio = new ServicioNomina();
        double salario = servicio.calcularNomina(empleado, 40);
        assertEquals(16000, salario); // 40h x 400
    }

}
