package ec.edu.poo;

public class main {
    public class Main {
        public static void main(String[] args) {

            GestorActivos gestor = new GestorActivos();

            Servidor servidor1 = new Servidor("S01", "Servidor Web Principal", 9, false, "Linux Ubuntu");
            Servidor servidor2 = new Servidor("S02", "Servidor de Base de Datos", 8, true, "Windows Server");
            Firewall firewall1 = new Firewall("FW01", "Firewall Perimetral", 5, true, 150);

            System.out.println("Registrando S01: " + gestor.registrarActivo(servidor1));
            System.out.println("Registrando S02: " + gestor.registrarActivo(servidor2));
            System.out.println("Registrando FW01: " + gestor.registrarActivo(firewall1));

            System.out.println("Registrando duplicado S01: " + gestor.registrarActivo(servidor1));

            System.out.println("\nTotal de activos registrados: " + gestor.obtenerCantidadActivos());

            System.out.println("Activos críticos (Riesgo >= 8): " + gestor.contarActivosCriticos());

            System.out.printf("Promedio de riesgo general: %.2f\n", gestor.calcularPromedioRiesgo());

            System.out.println("\nEstado de parche S01 antes: " + gestor.buscarPorCodigo("S01").isParcheAplicado());
            System.out.println("Aplicando parche a S01: " + gestor.aplicarParcheActivo("S01"));
            System.out.println("Estado de parche S01 después: " + gestor.buscarPorCodigo("S01").isParcheAplicado());

            System.out.println("Aplicando parche a activo inexistente (X99): " + gestor.aplicarParcheActivo("X99"));

            gestor.reiniciar();
            System.out.println("\nActivos tras el reinicio: " + gestor.obtenerCantidadActivos());
        }
    }
}
