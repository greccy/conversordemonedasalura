import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversiones {
    private final List<Conversion> historial = new ArrayList<>();

    public void agregarConversion(Conversion conversion) {
        historial.add(conversion);
    }

    public boolean estaVacio() {
        return historial.isEmpty();
    }

    public void imprimir() {
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones registradas aún.\n");
            return;
        }

        System.out.println("=== Historial de conversiones ===");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ") " + historial.get(i).formato());
        }
        System.out.println();
    }

    public void limpiar() {
        historial.clear();
        System.out.println("Historial limpiado.\n");
    }
}
