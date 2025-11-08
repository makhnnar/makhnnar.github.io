package app.views.data

import app.views.home.postslist.postlistitem.*

fun getPost1():PostItemData{
    return PostItemData(
            "1",
            "Custom View Components en Android",
            "Un breve tutorial de como iniciar el desarrollo de componentes custom en Android.",
            "https://i.postimg.cc/nzhBNPcr/img12.jpg",
            listOf(
                    H1Elment(
                            "Custom View Components en Android"
                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Cuando se realiza cualquier tipo software, una" +
                                                    " de las herramientas más útiles es la reusabilidad del código," +
                                                    " y al codificar interfaces de usuario esto es realmente importante." +
                                                    " En Android, el desarrollo de interfaces de usuario puede convertirse " +
                                                    "en un infierno de forma muy rápida, como consecuencia de que aún no es " +
                                                    "posible (al menos en una versión estable), el crear componentes visuales " +
                                                    "de forma declarativa como lo hacen otros ambientes de desarrollo" +
                                                    " como React o Flutter."
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Si bien es cierto que existen algunas alternativas" +
                                                    " como Anko Layouts (el cual está deprecado como consecuencia" +
                                                    " del soporte nativo que tendrá Android con Jetpack Compose)," +
                                                    " las cuales permiten crear interfaces de usuario de forma más" +
                                                    " sencilla, los Custom View Components, solo agregar más " +
                                                    "funcionalidad a estos mismos, ya que nos permitirán rehusar de" +
                                                    " forma sencilla nuestras cápsulas visuales en nuestra app."
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "De forma concreta un Custom View Component, es una pieza de" +
                                                    " código (clase) que encapsula toda la lógica de un " +
                                                    "component visual con su apariencia. Estas clases, heredan " +
                                                    "de alguna otra(View, Button, TextView, entre otras) de la" +
                                                    " cual nosotros queramos extender sus funcionalidades, o " +
                                                    "simplemente crear una nueva que herede de cualquiera " +
                                                    "de los layouts padres(linear layout, relative layout, " +
                                                    "frame layout, constraint layout), para piezas de código" +
                                                    " reusables, permitiendo un uso simple de las mismas en" +
                                                    " cualquier parte del app."
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Para entender mejor esto, supongamos que deseamos hacer un" +
                                                    " boton que se bloquee cuando sea presionado, y que se" +
                                                    " libere asi mismo luego de “n” segundos. Para ello haremos" +
                                                    " uso de la clase CountDownTimer para generar la cuentra " +
                                                    "atras, y desbloquear el boton una vez pase el tiempo determinado." +
                                                    " Nuestro Layout padre sera un Relativelayout, por lo que nuestro" +
                                                    " SelfBlockButton heredara de la clase Relativelayout."
                                    )
                            )
                    ),
                    CodeElment(
                            "\nclass SelfBlockButton @JvmOverloads constructor(\n" +
                                    "       context: Context,\n" +
                                    "       attrs: AttributeSet? = null,\n" +
                                    "       defStyle: Int = 0\n" +
                                    ") : RelativeLayout(context, attrs, defStyle){\n" +
                                    "}\n",
                            "javascript"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "una vez hecho lo anterior, lo mas " +
                                                    "importante para nosotros sera el bloque init, donde inflaremos " +
                                                    "nuestro layout y usaremos el objeto attrs. Para inflar nuestro" +
                                                    " layout:"
                                    )
                            )
                    ),
                    CodeElment(
                            "\ninit {\n" +
                                    "   LayoutInflater.from(context)\n" +
                                    "           .inflate(\n" +
                                    "                   R.layout.selfBlockButtonLayout,\n" +
                                    "                   this,\n" +
                                    "                   true\n" +
                                    "           )\n" +
                                    "\n" +
                                    "   attrs.let {\n" +
                                    "       var a = context.obtainStyledAttributes(\n" +
                                    "       it,\n" +
                                    "       R.styleable.SelfBlockButton\n" +
                                    "       )\n" +
                                    "\n" +
                                    "       a.recycle()\n" +
                                    "   }\n" +
                                    "\n" +
                                    "}\n",
                            "javascript"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Ahora, detengámonos un momento a entender estas lineas de codigo. Primeramente abriendo el bloque init, tenemos el LayoutInflater, el cual simplemente nos “infla” el layout del view que queremos dibujar en pantalla. Seguidamente, tenemos el bloque de attrs, con su respectivo lambda en let, con el cual podremos setear los parámetros básicos a renderizar en el mismo."
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Para ello obtenemos una referencia al objeto que contiene todos los atributos que definimos para el view en el archivo attrs.xml, que esta en el directorio values de la carpeta res."
                                    )
                            )
                    ),
                    CodeElment(
                            "\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                    "<resources>\n" +
                                    "\n" +
                                    "  <declare-styleable name=\"SelfBlockButton\">\n" +
                                    "       <attr name=\"timeBlocked\" format=\"integer\" />\n" +
                                    "   </declare-styleable>\n" +
                                    "\n" +
                                    "</resources>\n",
                            "xml"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Es necesario, que existan tantas etiquetas del tipo declare-styleable, como componentes custom tengamos definidos en nuestro proyecto. En estos hacemos uso de la etiqueta attr, con la cual definimos el nombre y el tipo de dato asociado al atributo. Por ahora definiremos el atributo como timeBlocked y será de tipo entero, y con este valor podremos pasar el tiempo que queramos que el botón se bloque al ser presionado. "
                                    )
                            )
                    ),
                    CodeElment(
                            "\nvar BLOCKED_TIME = 0\n" +
                                    "attrs.let {\n" +
                                    "       var a = context.obtainStyledAttributes(\n" +
                                    "       it,\n" +
                                    "       R.styleable.SelfBlockButton\n" +
                                    "       )\n" +
                                    "       BLOCKED_TIME = a.getInteger(\n" +
                                    "R.styleable.SelfBlockButton_timeBlocked,\n" +
                                    "30\n" +
                                    "      )\n" +
                                    "       a.recycle()\n" +
                                    "   }\n",
                            "javascript"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "dentro del bloque let, hacemos uso de la instancia “a”, la cual es una referencia de "
                                    ),
                                    BElment(
                                            "StyledAttributes"
                                    ),
                                    StrElment(
                                            ", con el cual podemos acceder a los parámetros definidos en el xml que se mencionó anteriormente. En este caso específico, se usa el método getInteger, el cual recibe dos parámetros, siendo el primero el nombre del parámetro a leer como entero, y su valor por defecto, si el parámetro no es definido en el xml, en donde nuestro caso hemos colocado 30."
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Para finalizar nuestro componente, nos toca definir lo que sucederá cuando se presione el mismo. Para este objetivo hacemos uso de CountDownTimer, deshabilitado el boton antes de iniciar el conteo, y habilitando nuevamente al finalizar el mismo."
                                    )
                            )
                    ),
                    CodeElment(
                            "\nblockedButton.setOnClickListener{\n" +
                                    "\tblockedButton.isEnable = false\n" +
                                    "\tcounter = object : CountDownTimer(BLOCKED_TIME,1000){\n" +
                                    "            override fun onTick(millisUntilFinished: Long) {\n" +
                                    "\n" +
                                    "            }\n" +
                                    "           \n" +
                                    "            override fun onFinish() {\n" +
                                    "               blockedButton.isEnable = true\n" +
                                    "            }\n" +
                                    "\n" +
                                    "        }.start()\n" +
                                    "}\n",
                            "javascript"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Finalmente nuestra clase completa quedaría de la siguiente manera."
                                    )
                            )
                    ),
                    CodeElment(
                            "\nclass SelfBlockButton @JvmOverloads constructor(\n" +
                                    "       context: Context,\n" +
                                    "       attrs: AttributeSet? = null,\n" +
                                    "       defStyle: Int = 0\n" +
                                    ") : RelativeLayout(context, attrs, defStyle){\n" +
                                    "\n" +
                                    "   init {\n" +
                                    "       LayoutInflater.from(context)\n" +
                                    "           .inflate(\n" +
                                    "                   R.layout.selfBlockButtonLayout,\n" +
                                    "                   this,\n" +
                                    "                   true\n" +
                                    "       )\n" +
                                    "\n" +
                                    "       attrs.let {\n" +
                                    "           var a = context.obtainStyledAttributes(\n" +
                                    "               it,\n" +
                                    "               R.styleable.SelfBlockButton\n" +
                                    "           )\n" +
                                    "           BLOCKED_TIME = a.getInteger(\n" +
                                    "               R.styleable.SelfBlockButton_timeBlocked,\n" +
                                    "               30\n" +
                                    "           )\n" +
                                    "           a.recycle()\n" +
                                    "       }\n" +
                                    "       blockedButton.setOnClickListener{\n" +
                                    "           blockedButton.isEnable = false\n" +
                                    "           counter = object : CountDownTimer(BLOCKED_TIME,1000){\n" +
                                    "               override fun onTick(millisUntilFinished: Long) {\n" +
                                    "\n" +
                                    "               }\n" +
                                    "           \n" +
                                    "               override fun onFinish() {\n" +
                                    "                   blockedButton.isEnable = true\n" +
                                    "               }\n" +
                                    "\n" +
                                    "           }.start()\n" +
                                    "       }\n" +
                                    "\n" +
                                    "   }\n" +
                                    "\n" +
                                    "}\n",
                            "javascript"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "y nuestro layout selfBlockButtonLayout"
                                    )
                            )
                    ),
                    CodeElment(
                            "\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                    "<merge xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                                    "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                                    "    tools:parentTag=\"android.widget.RelativeLayout\"\n" +
                                    "    android:layout_width=\"match_parent\"\n" +
                                    "    android:layout_height=\"match_parent\">\n" +
                                    "\n" +
                                    "    <Button\n" +
                                    "        android:id=\"@+id/blockedButton\"\n" +
                                    "        android:layout_width=\"match_parent\"\n" +
                                    "        android:layout_height=\"match_parent\"/>\n" +
                                    "\n" +
                                    "</merge>\n",
                            "xml"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Por último, donde queramos usar nuestro botón, deberemos usarlo como si de otro componente de android mediante el xml. Suponiendo que definimos el componente en un directorio llamado views, él mismo se llamaría de la siguiente forma."
                                    )
                            )
                    ),
                    CodeElment(
                            "\n<com.example.views.SelfBlockButton\n" +
                                    "        android:id=\"@+id/customBlockedButton\"\n" +
                                    "        android:layout_width=\"200dp\"\n" +
                                    "        android:layout_height=\"50dp\"\n" +
                                    "        app:timeBlocked=\"60\"/>\n",
                            "xml"

                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Con todo esto ya estamos listos para poder usar nuestro botón en cualquier parte del app, sin tener que volver a reescribir su comportamiento."
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment(
                                            "Sin mas nada que agregar, me despido, esperando escribir otro post que pueda ser de ayuda en tu vida como desarrollador android nativo, y mientras mira a este lindo gatito."
                                    )
                            )
                    ),
                    ImgElment(
                            "https://i.postimg.cc/tCHPJKYK/gatito.jpg"
                    )
            )
    )
}