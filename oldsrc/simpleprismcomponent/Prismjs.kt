@file:JsModule("simpleprisimreactcomponent")
@file:JsNonModule

package simpleprismcomponent

import react.RClass
import react.RProps

external interface PrismComponentProps : RProps {
    var codeToShow: String
    var langSintax: String
}

@JsName("default")
external val prismComponent: RClass<PrismComponentProps>
