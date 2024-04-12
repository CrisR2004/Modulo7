import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraFigurasGeometricas {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Resultado> resultados = new ArrayList<>();

    public static void main(String[] args) {
        // Menú principal
        while (true) {
            mostrarMenu();
            int opcionFigura = scanner.nextInt();

            switch (opcionFigura) {
                case 1:
                    calcularCirculo();
                    break;
                case 2:
                    calcularCuadrado();
                    break;
                case 3:
                    calcularTriangulo();
                    break;
                case 4:
                    calcularRectangulo();
                    break;
                case 5:
                    calcularPentagono();
                    break;
                case 6:
                    mostrarResultados();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Ingrese un número del 0 al 6.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Calculadora de Figuras Geométricas");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Calcular área y perímetro de un círculo");
        System.out.println("2. Calcular área y perímetro de un cuadrado");
        System.out.println("3. Calcular área de un triángulo");
        System.out.println("4. Calcular área y perímetro de un rectángulo");
        System.out.println("5. Calcular área y perímetro de un pentágono");
        System.out.println("6. Mostrar resultados");
        System.out.println("0. Salir");
    }

    private static void calcularCirculo() {
        System.out.println("Ingrese el radio del círculo:");
        double radio = scanner.nextDouble();
        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;
        resultados.add(new Resultado("Círculo", area, perimetro));
        System.out.println("Área del círculo: " + area);
        System.out.println("Perímetro del círculo: " + perimetro);
    }

    private static void calcularCuadrado() {
        System.out.println("Ingrese el lado del cuadrado:");
        double lado = scanner.nextDouble();
        double area = lado * lado;
        double perimetro = 4 * lado;
        resultados.add(new Resultado("Cuadrado", area, perimetro));
        System.out.println("Área del cuadrado: " + area);
        System.out.println("Perímetro del cuadrado: " + perimetro);
    }

    private static void calcularTriangulo() {
        System.out.println("Ingrese la base del triángulo:");
        double base = scanner.nextDouble();
        System.out.println("Ingrese la altura del triángulo:");
        double altura = scanner.nextDouble();
        double area = (base * altura) / 2;
        resultados.add(new Resultado("Triángulo", area, Double.NaN));
        System.out.println("Área del triángulo: " + area);
    }

    private static void calcularRectangulo() {
        System.out.println("Ingrese la base del rectángulo:");
        double base = scanner.nextDouble();
        System.out.println("Ingrese la altura del rectángulo:");
        double altura = scanner.nextDouble();
        double area = base * altura;
        double perimetro = 2 * (base + altura);
        resultados.add(new Resultado("Rectángulo", area, perimetro));
        System.out.println("Área del rectángulo: " + area);
        System.out.println("Perímetro del rectángulo: " + perimetro);
    }

    private static void calcularPentagono() {
        System.out.println("Ingrese la longitud de un lado del pentágono:");
        double lado = scanner.nextDouble();
        System.out.println("Ingrese la apotema del pentágono:");
        double apotema = scanner.nextDouble();
        double area = (5 * lado * apotema) / 2;
        double perimetro = 5 * lado;
        resultados.add(new Resultado("Pentágono", area, perimetro));
        System.out.println("Área del pentágono: " + area);
        System.out.println("Perímetro del pentágono: " + perimetro);
    }

    private static void mostrarResultados() {
        System.out.println("Resultados:");
        for (Resultado resultado : resultados) {
            System.out.println(resultado);
        }
    }

    private static class Resultado {
        private String figura;
        private double area;
        private double perimetro;

        public Resultado(String figura, double area, double perimetro) {
            this.figura = figura;
            this.area = area;
            this.perimetro = perimetro;
        }

        @Override
        public String toString() {
            if (!Double.isNaN(perimetro)) {
                return figura + ": Área = " + area + ", Perímetro = " + perimetro;
            } else {
                return figura + ": Área = " + area;
            }
        }
    }
}
