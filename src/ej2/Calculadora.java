package ej2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Calculadora {
    private Subtractor restador;
    private Multiplier multiplicador;
    private Divider divisor;

    public Calculadora(Subtractor restador, Multiplier multiplicador, Divider divisor) {
        this.restador = restador;
        this.multiplicador = multiplicador;
        this.divisor = divisor;
    }

    public void mostrarResumen(int a, int b) {
        double resResta = (double)this.restador.subtract(a, b);
        double resMultiplicacion = (double)this.multiplicador.multiply(a, b);
        double resDivision = this.divisor.divide(a, b);

        Function<Double, String> formater = valor -> "Resultado: " + valor;

        List<String> lista = List.of(formater.apply(resResta), formater.apply(resMultiplicacion), formater.apply(resDivision));

        Consumer<String> impresor = System.out::println;

        lista.stream().forEach(impresor);


    }
}
