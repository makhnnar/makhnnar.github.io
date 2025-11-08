@file:JsModule("react-share")
@file:JsNonModule

package reactshare

import react.RClass
import react.RProps

@JsName("TwitterIcon")
external val twitterIcon: RClass<IconProps>

@JsName("TwitterShareButton")
external val twitterShareButton: RClass<ShareButtonProps>

@JsName("FacebookIcon")
external val facebookIcon: RClass<IconProps>

@JsName("FacebookShareButton")
external val facebookShareButton: RClass<ShareButtonProps>

@JsName("WhatsappIcon")
external val whatsappIcon: RClass<IconProps>

@JsName("WhatsappShareButton")
external val whatsappShareButton: RClass<ShareButtonProps>

@JsName("TelegramIcon")
external val telegramIcon: RClass<IconProps>

@JsName("TelegramShareButton")
external val telegramShareButton: RClass<ShareButtonProps>

external interface ShareButtonProps : RProps {
    var url: String
}

external interface IconProps : RProps {
    var size: Int
    var round: Boolean
}