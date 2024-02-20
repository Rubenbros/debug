package visible;
import noMirar.CreaObjetos;
import noMirar.AnalizaObjetos;
/**
 * Exercise 3: Utilizando breakpoints condicionales para evitar
 * depuración innecesaria
 */
public class E3CrisisCondicional {

    public static void main(final String... args) {
        // En el Ej2, "getList" no funcionaba muy bien. Asi que probemos con un array esta vez...
        final Object[] miArray = CreaObjetos.getArray(100);

        boolean todoVaBien = true;
        int i = 0;
        while (i < miArray.length && todoVaBien) {
            // Esta vez usaremos una libreria externa para procesar los objetos.
            // Si algo va mal, esta es la linea donde querriamos poner un
            // breakpoint.
            todoVaBien = AnalizaObjetos.processElementAtIndex(miArray, i);
            i++;
        }

        if (!todoVaBien) {
            throw new RuntimeException(
                    "Oh oh- analisis incompleto!. Mira la consola para mas informacion.");
        }
    }
}