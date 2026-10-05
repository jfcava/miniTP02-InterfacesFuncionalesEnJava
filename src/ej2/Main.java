package ej2;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora(
                (a, b) -> a - b,
                (a, b) -> a * b,
                (a, b) -> (double)a / b
        );

        calc.mostrarResumen(10, 2);
        System.out.println();
        calc.mostrarResumen(9, 3);
        System.out.println();
        calc.mostrarResumen(7, 7);
    }
}
