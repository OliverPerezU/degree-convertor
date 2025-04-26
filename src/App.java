import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        principal(scanner);
    }

    public static void limpiarConsola() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void muestraMenu() {
        System.out.println("¡Bienvenido!");
        System.out.println("¿Qué acción deseas realizar?");
        System.out.println("1. Convertir de Celsius a Fahrenheit. \n2. Convertir de Fahrenheit a Celsius. \n3. Salir.");
    }

    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    public static int obtenerOpcion(Scanner scanner) {
        try {
            System.out.println("Por favor ingresa un número con la acción que se desea realizar.");
            int numero = scanner.nextInt();
            if (numero > 3 || numero < 1) {
                System.out.print("Por favor ingresa un número entre 1 y 3 ");
                return obtenerOpcion(scanner);
            }
            return numero;
        } catch (Exception e) {
            System.out.println("Por favor ingresa un número");
            return obtenerOpcion(scanner);
        }
    }

    public static double obtenerTemperatura(Scanner scanner) {
        try {
            System.out.print("Ingresa la temperatura: ");
            return scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Por favor ingresa un número");
            return 0;
        }
    }

    public static void celsiusAFahrenheit(Double temperatura) {
        try {
            double resultado = (temperatura * 9 / 5) + 32;
            System.out.println("La temperatura en Fahrenheit es de: " + resultado + "°");

        } catch (Exception e) {
            System.out.println("¡Ha ocurrido un error al realizar la conversión!");
        }
    }

    public static void fahrenheitACelsius(Double temperatura) {
        try {
            double resultado = (temperatura - 32) * 5 / 9;
            System.out.println("La temperatura en Celsius es de: " + resultado + "°");

        } catch (Exception e) {
            System.out.println("¡Ha ocurrido un error al tratar de realizar la conversión.! \nIntenta de nuevo.");
        }
    }

    public static void principal(Scanner scanner) {
        limpiarConsola();
        muestraMenu();
        int opcion = -1;
        do {
            double temperatura;
            opcion = obtenerOpcion(scanner);
            switch (opcion) {
                case 1:
                    System.out.println("Conversión de Celsius a Fahrenheit");
                    temperatura = obtenerTemperatura(scanner);
                    celsiusAFahrenheit(temperatura);
                    pressEnterToContinue(scanner);
                    break;
                case 2:
                    System.out.println("Conversión de Fahreneit a Celsius");
                    temperatura = obtenerTemperatura(scanner);
                    fahrenheitACelsius(temperatura);
                    pressEnterToContinue(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa....");
                    break;
                default:
                    System.out.println("Por favor ingresa una opción");

                    break;
            }
        } while (opcion != 3);
        scanner.close();
    }
}
