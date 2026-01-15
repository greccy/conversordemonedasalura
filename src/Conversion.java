import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Conversion(LocalDateTime fecha,
                         String baseCode,
                         String targetCode,
                         double amount,
                         double result,
                         double rate) {

    public String formato() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("[%s] %.2f %s -> %.2f %s (rate: %.6f)", fecha.format(formato), amount, baseCode, result, targetCode, rate);
    }
}
