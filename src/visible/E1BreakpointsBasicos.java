package visible;
/**
 * Ejercicio 1: Estableciendo breakpoints, avanzando paso a paso en el codigo y revisando variables
 * en perspectiva de debug
 */
public class E1BreakpointsBasicos {

    public static void main(final String... args) {
        // Aqui se crea nuestro objeto.
        // Si necesitamos deputar el proceso de creacion, podriamos
        // añadir un breakpoint en esta linea
        final Object o = hazUnObjeto();

        imprimeEsto(o);
    }

    private static Object hazUnObjeto() {
        final Object o = new Object();
        System.out.println(o);

        return null;
    }

    private static void imprimeEsto(final Object o) {
        // Este metodo no valida la entrada del usuario
        // Si "o" es nulo veremos una NullPointerException aqui,
        // sin embargo no nos dice POR QUE es nulo.
        //
        // Establecer un breakpoint aqui limita su utilidad,
        // ya que la validez de "o" ha sido determinada
        // previamente a este punto
        System.out.println(o.toString());
    }
}