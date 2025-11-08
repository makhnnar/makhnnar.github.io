@file:JsModule("firebase/app")
@file:JsNonModule

package firebase


@JsName("FirebaseApp")
external class FirebaseApp {

    var options: FirebaseOptions

    fun analytics(): FirebaseAnalytics

}

@JsName("FirebaseNamespace")
external interface FirebaseNamespace {

    fun initializeApp(
            firebaseConfig: FirebaseOptions
    ):FirebaseApp

    fun initializeApp(
            options: FirebaseOptions,
            name: String?
    ):FirebaseApp

    fun app():FirebaseApp

}

@JsName("default")
external val fireBase: FirebaseNamespace



