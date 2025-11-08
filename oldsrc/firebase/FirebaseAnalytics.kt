@file:JsModule("firebase/analytics")
@file:JsNonModule

package firebase


@JsName("AnalyticsCallOptions")
external interface AnalyticsCallOptions {
    var global: Boolean
}

@JsName("FirebaseAnalytics")
external interface FirebaseAnalytics {

    fun logEvent(
            eventName: String
    )

    fun logEvent(
            eventName: String,
            eventParams: String?
    )

    fun logEvent(
        eventName: String,
        eventParams: String?,
        options: AnalyticsCallOptions
    )

    fun setCurrentScreen(screenName: String, options: AnalyticsCallOptions?)
}