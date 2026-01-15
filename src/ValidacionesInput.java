import java.util.Scanner;

public class ValidacionesInput {

    public static int validarNumeroEntero(Scanner lectura, String mensaje, int min, int max){
        while (true) {
            System.out.print(mensaje);
            String input = lectura.nextLine().trim();

            try {
                int valor = Integer.parseInt(input);
                if (valor < min || valor > max) {
                    System.out.println("Por favor ingresa un número entre " + min + " y " + max + ".\n");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar solo números (por ejemplo: 1, 2, 3...).\n");
            }
        }
    }



}
