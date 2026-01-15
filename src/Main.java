import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;
        double amountConversion;


        try{

            while (opcion != 7){
                System.out.println("*****************************************************");
                System.out.println("Sea bienvenido/a al Conversor de moneda =] \n");

                System.out.println("""
                        1) Dólar =>> Peso Argentino
                        2) Peso Argentino =>> Dólar
                        3) Dólar =>> Real Brasileño
                        4) Real Brasileño =>> Dólar 
                        5) Dólar =>> Peso Colombiano
                        6) Peso Colombiano =>> Dólar
                        7) Salir
                        """);

                opcion = ValidacionesInput.validarNumeroEntero(lectura, "Elija una opción válida (1-7): ", 1, 7);

                System.out.println("***************************************************** \n");

                if (opcion == 7) {
                    System.out.println("Gracias por usar el conversor 👋");
                    break;
                }

                String baseCode = "";
                String targetCode = "";

                switch (opcion) {
                    case 1 -> { baseCode = "USD"; targetCode = "ARS"; }
                    case 2 -> { baseCode = "ARS"; targetCode = "USD"; }
                    case 3 -> { baseCode = "USD"; targetCode = "BRL"; }
                    case 4 -> { baseCode = "BRL"; targetCode = "USD"; }
                    case 5 -> { baseCode = "USD"; targetCode = "COP"; }
                    case 6 -> { baseCode = "COP"; targetCode = "USD"; }
                    default -> {
                        System.out.println("Opción inválida.\n");
                        continue;
                    }
                }

                double amount = ValidacionesInput.validarDoubleAmount(lectura, "Ingrese el valor que desea convertir: ");

                Moneda moneda = consulta.conversionMoneda(baseCode, targetCode, amount);

                System.out.println(
                        "El valor " + amount + " [" + baseCode + "] corresponde al valor final de =>>> "
                                + moneda.conversion_result() + " [" + targetCode + "]\n"
                );
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }

    }
}