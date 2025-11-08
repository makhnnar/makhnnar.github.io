package app.views.data

import app.views.home.postslist.postlistitem.*

fun getPost3(): PostItemData {
    return PostItemData(
            "3",
            "Uso de la etiqueta merge en Android",
            "Una guia para el uso de la etiqueta merge en los XML",
            "https://i.postimg.cc/DzQzhpzh/img15.jpg",
            listOf(
                    H1Elment(
                            "Tips de diseño para la creación de custom views: uso de la etiqueta merge"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Cuando hacemos cualquier tipo de layout en android, es importante tener conciencia de una característica importante. la cual es la profundidad de los layouts. La profundidad de los layouts corresponde a cuantas capas de grupos de layouts existen en el.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("El término grupo de layouts por su parte, se refiere a los diferentes layouts que nos permiten agrupar varios views en una vista. Ejemplos de estos grupos son el LinearLayout, RelativeLayout o ConstraintLayout entre otros. Veamos el siguiente gráfico.")
                            )
                    ),
                    ImgElment(
                            "https://docs.google.com/drawings/d/e/2PACX-1vST0dr8h0O_0Z21pbZQ3aDEgVuUtm4I2phFjEGCeHrFJnV5VnHjZWEo-6eMXa9rZvUNLomvd9v_Y5BM/pub?w=960&h=720"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Sin importar el tipo específico de cada layout o view, lo importante es ver que el view en rosado claro, se encuentra contenido en un layout, el cual a su vez está contenido dentro de otro. Si contamos la cantidad de veces que un layout o view está dentro de otro, podemos contar 5 veces, lo cual arroja un total de 5 capas.")

                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Ahora, ¿Por que es importante que la profundidad de los layouts no supere las 5 capas?, simple, para que cuando el sistema este renderizando nuestro layout no colapse y nos muestre el siguiente que se detalla aca en "),
                                    LinkElment(
                                            "https://stackoverflow.com/questions/2762924/java-lang-stackoverflow-error-suspected-too-many-views",
                                            "stackoverflow:"
                                    )
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Entonces, ¿Que hacemos cuando por la naturaleza de nuestros views, debemos tener profundidades mas grandes, o por el contrario, que hacer para disminuirlas lo maximo posible? Para ello, el framework nos facilita el tag "),
                                    LinkElment(
                                            "https://developer.android.com/training/improving-layouts/reusing-layouts#Merge",
                                            "merge"
                                    ),
                                    StrElment(", el cual nos permite poder integrar el el layout de nuestro view, tal como si lo hubiéramos declarado dentro de nuestro layout principal. Veamos esto con un ejemplo.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Supongamos que tenemos un layout, en donde tenemos la siguiente disposicion de elementos.")
                            )
                    ),
                    ImgElment(
                            "https://docs.google.com/drawings/d/e/2PACX-1vT8tLIBk_cEHrN4UZQKc0JoeAbklz-brg2Cj8vNJJhsqPDaMToxSIuwZ8OM-Z0QMDCJnaMM5kAaBO3Q/pub?w=960&h=720"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Por su estructura, dicho layout se podría realizar con un RelativeLayout, quedando de la siguiente manera.")
                            )
                    ),
                    CodeElment(
                            "\n <?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                    "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                                    "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                                    "    android:layout_width=\"match_parent\"\n" +
                                    "    android:layout_height=\"match_parent\">\n" +
                                    "\n" +
                                    "    <RelativeLayout\n" +
                                    "        android:id=\"@+id/toolbar\"\n" +
                                    "        android:layout_width=\"match_parent\"\n" +
                                    "        android:layout_height=\"wrap_content\"\n" +
                                    "     >\n" +
                                    "\t\n" +
                                    "\t<ImageButton\n" +
                                    "\t    android:id=\"@+id/btnBack\"\n" +
                                    "\t    android:layout_width=\"wrap_content\"\n" +
                                    "\t    android:layout_height=\"wrap_content\"\n" +
                                    "\t    android:layout_centerVertical=\"true\"\n" +
                                    "\t    android:layout_alignParentStart=\"true\"\n" +
                                    "\t    android:layout_margin=\"16dp\" />\n" +
                                    "\t\n" +
                                    "\t<TextView\n" +
                                    "\t    android:id=\"@+id/title\"\n" +
                                    "\t    android:layout_width=\"wrap_content\"\n" +
                                    "\t    android:layout_height=\"wrap_content\"\n" +
                                    "\t    android:layout_centerInParent=\"true\" />\n" +
                                    "\n" +
                                    "    </RelativeLayout>\n" +
                                    "\n" +
                                    "    <android.support.v4.widget.SwipeRefreshLayout\n" +
                                    "        android:id=\"@+id/swipeRefreshLayout\"\n" +
                                    "        android:layout_width=\"match_parent\"\n" +
                                    "        android:layout_height=\"match_parent\"\n" +
                                    "        android:layout_below=\"@id/toolbar\"\n" +
                                    "        >\n" +
                                    "\n" +
                                    "        <!-- ListView of news -->\n" +
                                    "        <android.support.v7.widget.RecyclerView\n" +
                                    "            android:id=\"@+id/rvListItems\"\n" +
                                    "            android:layout_width=\"match_parent\"\n" +
                                    "            android:layout_height=\"wrap_content\" />\n" +
                                    "\n" +
                                    "    </android.support.v4.widget.SwipeRefreshLayout>\n" +
                                    "\n" +
                                    "    <ImageButton\n" +
                                    "        android:id=\"@+id/btnToTop\"\n" +
                                    "        android:layout_width=\"wrap_content\"\n" +
                                    "        android:layout_height=\"wrap_content\"\n" +
                                    "        android:layout_alignParentBottom=\"true\"\n" +
                                    "        android:layout_alignParentEnd=\"true\"\n" +
                                    "        android:layout_margin=\"16dp\" />\n" +
                                    "\n" +
                                    "</RelativeLayout>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Con lo anterior, podríamos dar nuestro trabajo por hecho, hacer push y pull request del view para ir a tomarnos nuestro café con calma, pero, entonces nos dices que el toolbar deberá ser usado en más de una vista del app, y a su vez cuando detallamos nuestro trabajo nos percatamos de que usamos dos RelativeLayout, uno dentro del otro. ¿Eso está bien, o hay una mejor forma de hacerlo?")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("La realidad es que si existe una mejor forma. Evidentemente al pedirnos que la toolbar este en varias vistas del app, el paso lógico es convertirlo en un componente, para lo que puedes visitar este post(agregar direccionamiento) donde se explica más a detalle el cómo hacerlo. Al convertirlo en uno, el layout quedaría de la siguiente forma.")
                            )
                    ),
                    CodeElment(
                            "\n <?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                    "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                                    "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                                    "    android:layout_width=\"match_parent\"\n" +
                                    "    android:layout_height=\"match_parent\">\n" +
                                    "\n" +
                                    "\t<ImageButton\n" +
                                    "\t    android:id=\"@+id/btnBack\"\n" +
                                    "\t    android:layout_width=\"wrap_content\"\n" +
                                    "\t    android:layout_height=\"wrap_content\"\n" +
                                    "\t    android:layout_centerVertical=\"true\"\n" +
                                    "\t    android:layout_alignParentStart=\"true\"\n" +
                                    "\t    android:layout_margin=\"16dp\" />\n" +
                                    "\t\n" +
                                    "\t<TextView\n" +
                                    "\t    android:id=\"@+id/title\"\n" +
                                    "\t    android:layout_width=\"wrap_content\"\n" +
                                    "\t    android:layout_height=\"wrap_content\"\n" +
                                    "\t    android:layout_centerInParent=\"true\" />\n" +
                                    "\n" +
                                    "</RelativeLayout>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("La definición anterior sería la del layout de nuestro componente, y al invocarlo desde el layout anterior tendríamos los siguiente:")
                            )
                    ),
                    CodeElment(
                            "\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                    "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                                    "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                                    "    android:layout_width=\"match_parent\"\n" +
                                    "    android:layout_height=\"match_parent\">\n" +
                                    "\n" +
                                    "    <CustomToolbar\n" +
                                    "        android:id=\"@+id/toolbar\"\n" +
                                    "        android:layout_width=\"match_parent\"\n" +
                                    "        android:layout_height=\"wrap_content\"\n" +
                                    "     />\n" +
                                    "\t\n" +
                                    "    <android.support.v4.widget.SwipeRefreshLayout\n" +
                                    "        android:id=\"@+id/swipeRefreshLayout\"\n" +
                                    "        android:layout_width=\"match_parent\"\n" +
                                    "        android:layout_height=\"match_parent\"\n" +
                                    "        android:layout_below=\"@id/toolbar\"\n" +
                                    "        >\n" +
                                    "\n" +
                                    "        <!-- ListView of news -->\n" +
                                    "        <android.support.v7.widget.RecyclerView\n" +
                                    "            android:id=\"@+id/rvListItems\"\n" +
                                    "            android:layout_width=\"match_parent\"\n" +
                                    "            android:layout_height=\"wrap_content\" />\n" +
                                    "\n" +
                                    "    </android.support.v4.widget.SwipeRefreshLayout>\n" +
                                    "\n" +
                                    "    <ImageButton\n" +
                                    "        android:id=\"@+id/btnToTop\"\n" +
                                    "        android:layout_width=\"wrap_content\"\n" +
                                    "        android:layout_height=\"wrap_content\"\n" +
                                    "        android:layout_alignParentBottom=\"true\"\n" +
                                    "        android:layout_alignParentEnd=\"true\"\n" +
                                    "        android:layout_margin=\"16dp\" />\n" +
                                    "\n" +
                                    "</RelativeLayout>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Al tenerlo de la forma anterior, no hemos en realidad mejorado el asunto de la profundidad del layout, solo hemos mejorado el asunto de la reusabilidad del código. Entonces, ¿Qué hacemos?, Usamos la etiqueta merge. Para ello, reescribimos un poco el código del layout de nuestro componente.")
                            )
                    ),
                    CodeElment(
                            "\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                                    "<merge xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                                    "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                                    "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                                    "    android:layout_width=\"match_parent\"\n" +
                                    "    android:layout_height=\"match_parent\"\n" +
                                    "    tools:parentTag=\"android.widget.RelativeLayout\">\n" +
                                    "\n" +
                                    "\t<ImageButton\n" +
                                    "\t    android:id=\"@+id/btnBack\"\n" +
                                    "\t    android:layout_width=\"wrap_content\"\n" +
                                    "\t    android:layout_height=\"wrap_content\"\n" +
                                    "\t    android:layout_centerVertical=\"true\"\n" +
                                    "\t    android:layout_alignParentStart=\"true\"\n" +
                                    "\t    android:layout_margin=\"16dp\" />\n" +
                                    "\t\n"+
                                    "\t<TextView\n" +
                                    "\t    android:id=\"@+id/title\"\n" +
                                    "\t    android:layout_width=\"wrap_content\"\n" +
                                    "\t    android:layout_height=\"wrap_content\"\n" +
                                    "\t    android:layout_centerInParent=\"true\" />\n" +
                                    "\n" +
                                    "</merge>\n",
                            "xml"
                    ),
                    PElment(
                            listOf(
                                    StrElment("Lo único que cambiamos son el hecho de que la etiqueta principal de nuestro layout será "),
                                    BElment("merge"),
                                    StrElment(", y para poder visualizar que nuestro componente se va a visualizar cómo queremos, agregamos el campo "),
                                    BElment(" parentTag"),
                                    StrElment(", a los parámetros de la etiqueta "),
                                    BElment("merge"),
                                    StrElment(". Lo anterior nos permite mantener el comportamiento del layout señalado dentro de la ya mencionada etiqueta, la cual su única utilidad es la de combinar directamente nuestros componentes dentro del layout que escojamos como destino.")
                            )
                    ),
                    PElment(
                            listOf(
                                    StrElment("Cuando el sistema compile todo, para nuestra jerarquía del layout, RelativeLayout interno no existirá, lo que nos permitirá disminuir la profundidad del mismo, y tener un mejor rendimiento al momento de renderizar nuestros layout. Finalmente, cabe destacar que los niveles de profundidad descritos al inicio de este post, no son más que un lineamiento de diseño, ya que la verdad absoluta es que entre menos profundidad mejor. Muchas gracias por llegar hasta esta parte del post.")
                            )
                    )
            )
    )
}