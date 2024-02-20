package noMirar;
/**
 * DEJA DE MIRAR ESTA CLASE. ES COMO VER LA CARA DE UN ANGEL
 */
public class AnalizaObjetos {

    public static boolean processElementAtIndex(final Object[] myArray,
                                                final int i)
    {
        final Object o = myArray[i];

        if (o == null) {
            System.out.println("Hay un error con el " + (i + 1) + suffix(i +
                    1) + " objeto... :(\n\n");
            return false;
        }

        return true;
    }

    private static String suffix(int i) {
        String suffix = "º";
        switch (i) {
            case 1, 3:
                suffix = "er";
                break;
            case 2:
                suffix = "ndo";
                break;
        }
        return suffix;
    }

}