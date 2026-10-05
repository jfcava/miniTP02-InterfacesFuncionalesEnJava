package ej3;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> esPositivo = a -> a > 0;
        System.out.println("Practica con Predicate: ");
        System.out.println(esPositivo.test(5));
        System.out.println(esPositivo.test(-2));

        Supplier<Double> numeroAleatorio = () -> Math.random();
        System.out.println("Practica con Supplier: ");
        System.out.println(numeroAleatorio.get());
        System.out.println(numeroAleatorio.get());

        List<String> nombres = List.of("Juan", "Mia", "Juliana", "Ginebra", "Eduardo", "Zoe");

        System.out.println("Practica con Streams: ");
        nombres.stream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
    /*
     * EXPLICACIÓN:
     * =============================================================================
     *
     * 1. esPositivo -> Implementa java.util.function.Predicate<Integer>
     *    - Método abstracto: boolean test(T t)
     *    - Función: Recibe un elemento de tipo Integer y evalúa una condición booleana
     *      (a > 0), retornando true o false sin modificar el valor de entrada.
     *
     * 2. numeroAleatorio -> Implementa java.util.function.Supplier<Double>
     *    - Método abstracto: T get()
     *    - Función: No recibe parámetros de entrada y suministra un resultado
     *      de tipo Double (en este caso, a través de Math.random()).
     *
     * 3. En la cadena de Streams (nombres.stream()...):
     *
     *    a) .filter(n -> n.length() > 3) -> Implementa Predicate<String>
     *       - El método intermedio .filter(...) espera un Predicate. Recibe cada nombre
     *         y evalúa la expresión booleana; si devuelve true, el elemento pasa a la
     *         siguiente etapa del stream; si es false, se descarta.
     *
     *    b) .map(String::toUpperCase) -> Implementa Function<String, String>
     *       - El método intermedio .map(...) espera un Function<T, R> (método R apply(T t)).
     *         Transforma el elemento recibido en otro: toma un String en su estado original
     *         y devuelve un nuevo String en mayúsculas. La referencia a método
     *         `String::toUpperCase` es equivalente a la lambda `n -> n.toUpperCase()`.
     *
     *    c) .forEach(System.out::println) -> Implementa Consumer<String>
     *       - La operación terminal .forEach(...) espera un Consumer<T> (método void accept(T t)).
     *         Consume cada elemento procesado por el stream ejecutando un efecto colateral
     *         (imprimirlo por consola con System.out.println) sin devolver ningún resultado.
     */
