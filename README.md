## Sobre los ejercicios
Tener en cuenta que el código fuente se divide en dos paquetes:

* `visible` - código fuente para uso e inspección en ejercicios de resolución de problemas.
  Estas son las clases destinadas a la inspección y el establecimiento de breakpoints.
* `noMirar` - una "caja negra" simulada de métodos de utilidad. Estas clases no están
  destinado a la inspección.

El 'Troubleshooting' es el arte de determinar la causa y/o ubicación de un problema.
Si tienes un conocimiento completo y perfecto del código entonces no es realmente necesario
para solucionar problemas, ya que es trivial ver por qué algo se comporta incorrectamente.

La inspección del paquete `noMirar` normalmente te permitirá realizar el "troubleshoot" fácilmente en un ejercicio
sin utilizar la técnica prevista.

Recuerda que el objetivo de estos ejercicios no es resolver los problemas, sino aprender
cómo y cuándo utilizar la gran variedad de técnicas de "troubleshooting" disponibles.

## Qué no hacer: escribir prints
Muchos desarrolladores lo primero que hacen es imprimir instrucciones.
Es fácil apoyarse en las impresiones como apoyo de seguridad: no necesita ningún
conocimiento para usarlos y, a menudo, trabajan para responder preguntas comunes (por ejemplo, "¿por qué es esto?"
¿variable nula aquí?", "¿cuántos elementos hay en mi matriz aquí?").

Sin embargo, hay desventajas críticas al intentar depurar mediante "prints":

* Son lentos. Si te das cuenta de que necesitas mover o añadir un "print", necesitas recompilar y relanzar tu aplicacion.
* Son parte del código. Añadir "prints" cambia el número de líneas, hace que git guarde los cambios y puede afectar al
  rendimiento y/o comportamiento
* Son limitados. Hasta el más básico breakpoint y expresión evaluada en el modo debug de tu IDE
  te da más poder y flexibilidad contra los "prints"

## Instrucciones generales
El objetivo de estos ejercicios no es resolver los problemas, sino desarrollar tu caja de herramientas de técnicas de 
resolución de problemas y desarrollar tu intuición sobre cuándo aplicar cada técnica. Una vez que aprendas a depurar una
aplicación Java, tendrás el conocimiento para aplicar cualquiera de estas técnicas a cualquier aplicación rica y compleja.

Debéis considerar el paquete `noMirar` como una librería externa sobre la que no tienes control o acceso al código fuente.

Cambiar el código fuente para arreglar los bugs está fuera del alcance de los ejercicios, pero si estais lo suficientemente
motivados puedes modificar el código fuente como te parezca.

Si en algún momento necesitas revertir los cambios, siempre puedes hacerlo mediante el comando:

```
git reset --hard origin/master
```

# Ejercicios

## Ejercicio 1: Trazas y Breakpoints

**Metas**

* Interpretar una traza
* Practicar estableciendo breakpoints en IntelliJ/Eclipse
* Usar la ventana de variables para inspeccionar los valores de las variables
* Usar los comandos de navegación de código en modo Debug

Los "breakpoints" son una herramienta fundamental en la depuración. Proporcionan una forma de indicarle a Java que detenga 
la ejecución de código cuando se encuentra una determinada línea de código, lo que brinda la oportunidad de explorar el 
código que se ejecuta en ese momento.

Para empezar en este ejercicio, abre el fichero ``E1BreakpointsBasicos``, y
ejecútalo para hacernos una idea de lo que está pasando. Deberíamos ver una simple traza en la consola:

![E1 Trazas](images/e1.png "E1 Trazas")


Las trazas son un punto de partida común para la depuración, ya que normalmente se generan automáticamente cuando algo 
sale mal y el programa no estaba preparado para manejar el problema.

Los programas Java se ejecutan en orden "Last in, First out" es decir, comenzando con el método "main", a medida que se
llaman los métodos, se agregan a la parte superior de la pila, el método en la parte superior es el que se está ejecutando
actualmente y, cuando un método se completa, se elimina de la pila, volviendo al programa en el siguiente método de la pila.

Cuando ocurre una excepción, se imprime un seguimiento de la pila, que muestra el orden en que los métodos se han puesto
en cola, siendo la parte superior de la pila la ubicación de la excepción (y, por lo tanto, un lugar probable para comenzar
a buscar problemas)

Volviendo a las trazas que hemos obtenido, podemos observar lo que ha ido mal (hemos intentado usar un objeto nulo) y donde
ha ocurrido (el número de línea de la cima de las trazas), pero no sabemos por qué el objeto era nulo en ese punto - lo 
que sería la verdadera raíz de la causa de la excepción

Para investigar más, intenta completar los siguientes pasos de depuración:

1. Pon un breakpoint en el metodo main, antes de llamar a``hazUnObjeto``
2. Depura ``E1BreakpointsBasicos.main()``.
3. Cuando el breakpoint se encuentre, haz "step in" en el método``hazUnObjeto()`` 
4. Haz "Step over" sobre las líneas que construyen un objeto e imprimen la variable ``o``
5. Haz "Step out" del método ``hazUnObjeto()``
6. Haz "Step" a la próxima línea dentro del método ``main()``
7. En la ventana de variables, comprueba el valor de la variable ``o``
8. Haz "Resume execution" hasta que el programa termine

Ahora que has pasado por todo el programa ¿Sabes por qué hemos obtenido un ``NullPointerException``

**Conclusiones**

* Las trazas son útiles para identificar los puntos donde empezar la depuración
* La vista de Debug nos permite ejecutar el programa línea a línea e inspeccionar el valor de las variables para detectar
errores

## Ejercicio 2: Excepciones

**Goals**

* Set breakpoints on exception creation

Although breakpoints allow us a chance to peek inside running code, it is sometimes unclear where to start
looking. Many times you'll find yourself replacing breakpoints until you find the correct spot to start
debugging.

Start by opening the ``E2ExceptionCreation`` source and running it. Like the previous exercise, we have a
stack trace to start from:

![E2 Stack trace](images/e2.png "E2 Stack trace")

Try setting a breakpoint on the conditional line:

```
49 |    if (index < 0 || index >= list.size()) {
```

Try debugging now, using Resume any time a breakpoint is encountered. How many times do you hit a breakpoint?

Since we are only interested in the ``processElementAtIndex`` method when a problem actually occurs,
let's try something different:

1. In the Debug window, select _View Breakpoint_. You should now see the following dialog

![E2 View breakpoints](images/e2-view-breakpoint.png "E2 View Breakpoints")

2. Now add a new ``Java Exception Breakpoint`` by selecting the ``+`` and selecting
   `IllegalArgumentException`
3. Debug the program. Resume execution until the program hits the newly created breakpoint for `IllegalArgumentException`. When it does, inspect the Variables window.

At this point, we know there is a problem accessing the ``99999th`` element of the list, but
the variables window doesn't tell us exactly what the problem is. We can manually expand
and explore the list variable - but given its size that could be cumbersome.

Can you tell what went wrong in the program?

**Takeaways**

* Setting breakpoints on exceptions avoids unnecessary breakpoint hits (and can be useful when we
  aren't sure where to set the breakpoint)

## Exercise 3: Conditional breakpoints

**Goals**

* Create a breakpoint that triggers after a specified number of hits
* Create a breakpoint that triggers when a certain condition is ``true``

Breakpoints trigger every time the corresponding line would be executed, which may be
undesirable for repeated code blocks. It may be enough to carefully consider the breakpoint
placement - on an exception, or within a conditional block. But when these options are not
available, we can make our breakpoints more powerful by triggering only when there's
something of interest to see.

Start by opening the ``E3ConditionalCrisis`` source and running it. This time our console
output looks a bit different:

![E3 Stack trace](images/e3.png "E2 Stack trace ")

In addition to the exception stack trace, the program itself appears to have found an
invalid object, causing the processing to go unfinished. Although we could set a
breakpoint on the exception, as we did in exercise 2, the exception is actually
happening after the more interesting part of the program - the loop. As we learned
in exercise 2, breakpoints in code that is called repeatedly are annoying, so let's
see what we can find by attaching conditions to our breakpoint.

First set a breakpoint on the line after the ``everythingIsOK`` assignment:

```
39 |    everythingIsOK = ObjectAnalyzer.processElementAtIndex(myArray, i);
40 |    i++;
```

Then try the following:

1. Open the _Breakpoints_ dialog
2. Select the breakpoint from above.
3. Check the _Pass count_ checkbox and set it to the object number printed in the error message.
4. Try debugging

Was there a problem with the current object when/if your breakpoint is hit?

Using count-based conditional breakpoints can be very useful if the error is deterministic.
In this case it will not work, so we need to try something different.

We know the ``everythingIsOK`` flag reflects the integrity of the object at a given index
- So what we really want to use here is a breakpoint that stops in the loop when the
  ``everythingIsOK`` flag is set to ``false``. Fortunately, breakpoints have an optional
  _Condition_ flag - where we can enter any Java statement that resolves to a boolean value.
  Try it out:

1. Open the _Breakpoints_ dialog again
2. Uncheck the _Pass count_ checkbox
3. Check the _Condition_ box
5. Enter the condition we want to check
6. Try debugging again

Were you able to get the breakpoint to stop in the loop only when a problem is encountered?

What was suspicious about the object at that index?

**Takeaways**

* Setting a pass count on a breakpoint is useful if problematic code is called multiple times.
* If problems appear randomly, using a conditional expressions on the breakpoint can help.
