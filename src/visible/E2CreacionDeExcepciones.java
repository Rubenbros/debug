package visible;
import java.util.List;

import noMirar.CreaObjetos;

/**
 * Exercise 2: Usando la ventana de expresiones en la perspectiva de debug
 */
public class E2CreacionDeExcepciones {

    public static void main(final String... args) {
        // Vamos a hacer una lista de 100.000 objetos
        final List<Object> miLista = CreaObjetos.getList(100000);

        // Ahora procesemos algunos de los objetos de nuestra lista

        // Procesamos primer objeto
        procesarElementoEnIndice(miLista, 0);

        // Procesamos objeto del medio
        procesarElementoEnIndice(miLista, 100000 / 2);

        // Procesamos ultimo objeto
        procesarElementoEnIndice(miLista, 100000 - 1);
    }

    private static void procesarElementoEnIndice(final List<Object> lista,
                                              final int indice)
    {
        // Primero combrobamos si los argumentos del metodo son validos
        if (indice < 0 || indice >= lista.size()) {
            // El hecho de que este metodo ya este haciendo validacion de entrada
            // vuelve la depuración mucho mas facil.
            // La siguiente linea de codigo solo se ejecutara si se detecta un problema,
            // asi que es un lugar ideal para colocar un breakpoint
            throw new IllegalArgumentException(
                    "Preferiria no procesar tu objeto, si no te importa...");
        }

        // OK ahora podemos procesar el objeto
        // ... nah, mejor lo destruyo junto a tus sueños y esperanzas de aprobar la asignatura
        lista.set(indice, null);
    }
}