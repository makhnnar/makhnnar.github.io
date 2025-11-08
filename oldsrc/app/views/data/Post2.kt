package app.views.data

import app.views.home.postslist.postlistitem.*

fun getPost2():PostItemData{
    return PostItemData(
            "2",
            "Tipos de datos en xml disponibles para Custom Views",
            "Una pequeña vista sobre los tipos de datos disponibles para definir en XML en Android",
            "https://i.postimg.cc/0j7Jdj19/img11.jpg",
            listOf(
                    H1Elment(
                            "Tipos de datos en xml disponibles para Custom Views"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Cuando creamos nuestros componentes custom, la siguiente pregunta que viene a la mente, es el como pasarle parametros mediante XML. Si bien es cierto, que podemos definir métodos setter y getter en nuestros componentes mediante kotlin y java, la realidad es que muchas veces resulta más práctico que el valor de inicialización sea ejecutado desde el momento en que se infla el layout, es decir, desde el XML.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Para el anterior caso, a través de la etiqueta attr podemos definir los siguientes tipos de datos:"),
                                    BElment(" string,"),
                                    BElment(" color,"),
                                    BElment(" boolean,"),
                                    BElment(" reference,"),
                                    BElment(" dimension,"),
                                    BElment(" enum,"),
                                    BElment(" flags,"),
                                    BElment(" float,"),
                                    BElment(" fraction,"),
                                    BElment(" integer.")

                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Si llegado a este punto, no entiendes aun la utilidad de este tipo de datos, es por que muy posiblemente estas acostumbrado a hardcodear (mala práctica, donde no se definen valores constantes que son usados frecuentemente en varias partes de nuestro código) el XML. Entonces si, la idea de definir estos tipos de datos es limitar la cantidad de opciones posibles de un valor, o en el otro caso, poder usar el sistema de recursos del ambiente de desarrollo android para poder pasar un valor. Veamos primero algo de código kotlin para entender mejor el contexto.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Imaginemos que queremos setear en un TextView un valor string que está definido en el archivo de strings de nuestro proyecto. Si hacemos eso desde código se vería así:")
                            )
                    ),
                    CodeElment(
                            "\n myTextView.text = context.resources.getString(R.string.myString) \n",
                            "javascript"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Gracias a que es kotlin y no java, la llamada es un poco más sencilla, pero no deja de ser larga y tediosa. En cambio, si invocamos el mismo string desde el XML, la cosa luce mucho mejor, veámoslo:")
                            )
                    ),
                    CodeElment(
                            "\n <TextView\n" +
                                    "   android:id=\"@+id/myTextView\"\n" +
                                    "   android:layout_width=\"wrap_content\"\n" +
                                    "   android:layout_height=\"wrap_content\"\n" +
                                    "   android:text=\"@string/myString\"\n" +
                                    "/>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Observa, como la el seteado de nuestro string en el TextView se simplifica, y lo mejor de todo, es que mantiene nuestra clase libre de código que podemos ejecutar directo en el XML, haciéndolas más cortas. Si ya sabes de qué estamos hablando, podrás imaginar que esto se extiende también a todos los archivos de recursos que podemos tener en nuestra app: los drawables, valores booleanos, numéricos, de dimensión y archivos en la carpeta raw(donde generalmente guardamos audio y video de forma estática para nuestros proyectos). Veamos un ejemplo para el uso de drawables.")
                            )
                    ),
                    CodeElment(
                            "\n <declare-styleable name=\"ColoredTitledIconButton\">\n" +
                                    "        <attr name=\"iconButton\" format=\"reference\" />\n" +
                                    "        <attr name=\"titleButton\" format=\"string\" />\n" +
                                    "        <attr name=\"colorButton\" format=\"color\" />\n" +
                                    "</declare-styleable>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Supongamos que la definición anterior es para un view, que muestra un icono con un texto debajo de este y detrás un background de bordes redondeados al que le podemos cambiar el color. Para el caso de los drawables, el tipo de valor recomendado a usar es el “reference”, el cual nos permite obtener archivos de la carpeta drawable, así como de la carpeta raw. Lo anterior nos da como ventaja la autocompletación de las referencias posibles para ese valor.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Esto es así, ya que tambien es valido pasar una referencia a un drawable como un integer. Si bien es posible, no es recomendable usar este tipo de datos para ello, ya que no hace distinción alguna entre los tipos de valores enteros permitidos y como ya te podrás imaginar, no nos permite autocompletación si el archivo es del tipo drawable, lo que facilita que cometamos algún error en la transcripción del nombre del mismo.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Ahora el siguiente tipo de dato de interés son los del tipo enum. Estos son bastante similares a los enum de programación de toda la vida (un valor asociado a un nombre para limitar la cantidad de valores posibles), con la diferencia de que aceptan un solo valor, y se definen puramente mediante XML, lo que implica que no podemos usar clases en Kotlin o Java para definir dichos enum. Supongamos ahora, que en la definición de nuestro componente podemos definir el estilo del texto del título que podemos usar en el, y que solo acepta dos opciones, bold o normal, es decir, no admite italic ni ningún otro estilo.")
                            )
                    ),
                    CodeElment(
                            "\n <declare-styleable name=\"ColoredTitledIconButton\">\n" +
                                    "        <attr name=\"iconButton\" format=\"reference\" />\n" +
                                    "        <attr name=\"titleButton\" format=\"string\" />\n" +
                                    "        <attr name=\"colorButton\" format=\"color\" />\n" +
                                    "        <attr name=\"titleStyle\" format=\"enum\">\n" +
                                    "            <enum name=\"normal\" value=\"0\"/>\n" +
                                    "            <enum name=\"bold\" value=\"1\"/>\n" +
                                    "        </attr>\n" +
                                    "</declare-styleable>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Al definir nuestro enum de la forma anterior, evitamos que el desarrollador puede setear una valor que no sea de indicado, manteniendo así el estilo del componente.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Otro valor de importancia son los flags, lo cuales nos permite colocar valores multivaluados, cuando la combinación de opciones es posible. Por ejemplo, en FrameLayout, un view puede tener dos values de gravity, para así setear su ubicación en el layout. Veamos a que nos referimos con esto.")
                            )
                    ),
                    CodeElment(
                            "\n <?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                    "<FrameLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                                    "   xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                                    "   android:layout_width=\"match_parent\"\n" +
                                    "   android:layout_height=\"match_parent\"\n" +
                                    "   android:orientation=\"vertical\">\n" +
                                    "\n" +
                                    "   <TextView\n" +
                                    "       android:id=\"@+id/myTextView\"\n" +
                                    "       android:layout_width=\"wrap_content\"\n" +
                                    "       android:layout_height=\"wrap_content\"\n" +
                                    "       android:text=\"@string/myString\"\n" +
                                    "       android:gravity=\"bottom|left\"\n" +
                                    "   />\n" +
                                    "</FrameLayout>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("En dicho ejemplo, podemos ver como en el campo gravity usamos dos valores predefinidos distintos para poder colocar la posición de nuestro TextView abajo y a la izquierda en el layout. Siguiendo esta lógica, si necesitas crear varias combinaciones de valores posibles, el tipo de dato flag resulta de utilidad. Si lo decides usar, ten en cuenta que cuando lo leas en tu view, lo que vas a obtener es la suma de un valor binario de n dígitos, por lo que las combinaciones de los posibles flags deben estar pensadas de antemano. En otro post vamos a indagar más sobre este tipo de valores. SI quieres algo mas de informacion puedes visitar este post en "),
                                    LinkElment(
                                            "https://medium.com/@JakobUlbrich/flag-attributes-in-android-how-to-use-them-ac4ec8aee7d1",
                                            "Medium"
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Por último, tenemos los del tipo fraction, los cuales no son más que simple valores porcentuales. Es necesario recordar que, dichos valores deben ser procesados y leídos desde el código Kotlin o Java de nuestro view, para lo que el framework de android nos brinda de una cantidad de métodos para dicha tarea. Sin mas nada que agregar, me despido hasta el próximo post.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("NOTA: Los demás tipos de datos no tocados en este post se dejaron de lado por considerarse triviales y de fácil uso.")
                            )
                    )
            )
    )
}