package ej1;

public class Main {
    public static void main(String[] args) {
        Adder adder = (a, b) -> a + b;
        System.out.println(adder.add(2, 3));
        System.out.println(adder.add(3, 7));
    }
}

/*
 * EXPLICACIÓN:
 * =============================================================================
 *
 * 1. ¿Qué es una interfaz funcional?
 * Es una interfaz de Java que posee un único método abstracto.
 * Puede contener métodos por defecto o estáticos, pero solo uno
 * sin implementar.
 *
 * 2. ¿Por qué es fundamental que tenga un único método abstracto?
 * Porque el compilador necesita realizar inferencia de tipos inequívoca.
 * Al escribir una expresión lambda como `(a, b) -> a + b`, Java mapea directamente
 * esa lógica al único método disponible. Si hubiese dos o más métodos abstractos,
 * el compilador no sabría a cuál de ellos corresponde la firma y el cuerpo de la lambda.
 *
 * 3. ¿Para qué sirve la anotación @FunctionalInterface?
 * Es una validación informativa en tiempo de compilación. Si bien no es estrictamente
 * obligatoria para que una interfaz sea funcional, evita errores humanos: si alguien
 * agrega por error un segundo método abstracto o la interfaz no tiene ninguno, el
 * compilador arrojará un error inmediato impidiendo que el código compile.
 *
 * 4. ¿Cómo la lambda implementa el método add?
 * En Java, las lambdas no existen en el aire; necesitan un tipo destino. La lambda
 * `(a, b) -> a + b` coincide exactamente con la firma de `int add(int a, int b)`:
 * toma dos parámetros de tipo entero y retorna un entero. Tras bambalinas, Java
 * genera una instancia que implementa la interfaz `Adder`, haciendo que invocar
 * `adder.add(x, y)` ejecute directamente el cuerpo de la expresión lambda.
 */