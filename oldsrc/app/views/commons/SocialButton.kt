package app.views.commons

import firebase.fireBase
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.dom.a
import react.dom.img
import react.dom.li

fun RBuilder.socialButton(
        href:String,
        target:String,
        imgSrc: dynamic,
        tag:String
){
    li {
        a(
                href,
                target
        ) {
            img {
                attrs{
                    src = imgSrc
                    onClickFunction = {
                        fireBase.app().analytics().logEvent("click_social:$tag")
                    }
                }
            }
        }
    }
}
