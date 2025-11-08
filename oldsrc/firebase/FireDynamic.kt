package firebase

external fun require(module: String): dynamic
external val exports: dynamic

val firebaseIntance = require("firebase/app")

val firebaseAnalytics = require("firebase/analytics")

fun initializeApp(){
    firebaseIntance.initializeApp(js("{\n" +
            "    apiKey: \"AIzaSyB8o4J6qso5CbDXWFAtV1nqZn_8vBLw4UA\",\n" +
            "    authDomain: \"mykotlintips.firebaseapp.com\",\n" +
            "    databaseURL: \"https://mykotlintips.firebaseio.com\",\n" +
            "    projectId: \"mykotlintips\",\n" +
            "    storageBucket: \"mykotlintips.appspot.com\",\n" +
            "    messagingSenderId: \"204702118352\",\n" +
            "    appId: \"1:204702118352:web:ae99ab4a800cfcb5f409d5\",\n" +
            "    measurementId: \"G-0GTG4V7Q09\"\n" +
            "  }"))
}

fun logEvent(event:String){
    firebaseIntance.app().analytics().logEvent(event)
    //firebaseAnalytics.FirebaseApp.logEvent(event)
}