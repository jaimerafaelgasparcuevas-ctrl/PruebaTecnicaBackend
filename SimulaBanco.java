import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.generation.util.ReciboSaldo;
import org.generation.util.TarjetaRegalo;
import org.generation.util.banco.Cuenta;
import org.generation.util.banco.CuentaCredito;
import org.generation.util.banco.CuentaDebito;

public class SimulaBanco {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2025, Calendar.MAY, 1);
		Calendar calendarCorte = Calendar.getInstance();
		calendarCorte.set(2025, Calendar.MAY, 31);
		HashMap<Integer, Cuenta> cuentas = new HashMap<>();
		cuentas.put(1001, new CuentaDebito(2000, "D8001", calendar.getTime(), 1000, "Juan Pérez"));
		cuentas.put(1002, new CuentaCredito(0, "C7001", calendarCorte.getTime(), calendar.getTime(), 0.35f, 3000.00,
				"María Díaz"));
		cuentas.put(1001, new CuentaDebito(1500, "D8002", calendar.getTime(), 1000, "Jorge Martínez"));
		cuentas.put(1002, new CuentaCredito(0, "C7002", calendarCorte.getTime(), calendar.getTime(), 0.35f, 4500.00,
				"Mónica Hernández"));

		cuentas.get(1001).deposito(200);
		cuentas.get(1001).retiro(100);
		cuentas.get(1002).retiro(500);
		cuentas.get(1002).deposito(150);

		System.out.println(cuentas.get(1001));
		System.out.println(cuentas.get(1002));

		ReciboSaldo.Imprimir(cuentas.get(1001));
		ReciboSaldo.Imprimir(cuentas.get(1002));
		TarjetaRegalo regalo = new TarjetaRegalo(9001, 500);
		ReciboSaldo.Imprimir(regalo);

	}// main
}// class Banco
