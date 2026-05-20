package ec.edu.poo;

public class GestorActivos {
    private ActivoDigital[] activos;
    private int contador;
    // Constructor que inicializa el arreglo y el contador
    public GestorActivos() {
        this.activos = new ActivoDigital[10]; // Capacidad máxima de 10
        this.contador = 0;
    }
    public boolean registrarActivo(ActivoDigital activo) {

        if (contador >= 10) {
            return false;
        }

        if (buscarPorCodigo(activo.getCodigo()) != null) {
            return false;
        }

        activos[contador] = activo;
        contador++;
        return true;
    }
    public ActivoDigital buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (activos[i].getCodigo().equals(codigo)) {
                return activos[i];
            }
        }
        return null;
    }
    public int contarActivosCriticos() {
        int cantidadCriticos = 0;
        for (int i = 0; i < contador; i++) {
            if (activos[i].getNivelRiesgo() >= 8) {
                cantidadCriticos++;
            }
        }
        return cantidadCriticos;
    }
    public double calcularPromedioRiesgo() {

        if (contador == 0) {
            return 0.0;
        }
        double sumaRiesgo = 0;
        for (int i = 0; i < contador; i++) {
            sumaRiesgo += activos[i].getNivelRiesgo();
        }
        return sumaRiesgo / contador;
    }
    public boolean aplicarParcheActivo(String codigo) {
        ActivoDigital activo = buscarPorCodigo(codigo);

        if (activo != null) {
            activo.setParcheAplicado(true);
            return true;
        }

        return false;
    }
    public int obtenerCantidadActivos() {
        return contador;
    }
    public ActivoDigital[] obtenerActivos() {
        return activos;
    }
    public void reiniciar() {

        this.activos = new ActivoDigital[10];
        this.contador = 0;
    }
}