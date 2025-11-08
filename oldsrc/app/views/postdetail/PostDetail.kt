package app.views.postdetail

import app.views.home.OnPostActions
import app.views.home.postslist.postlistitem.*
import app.views.postdetail.titlepostbar.titlePostBar
import react.*
import react.dom.div
import react.dom.h1
import react.dom.img
import react.dom.p
import react.dom.b
import react.dom.a
import reactshare.*
import simpleprismcomponent.prismComponent
import kotlin.browser.window


interface PostDetailProps : RProps {
    var postItemData: PostItemData
    var onPostActions:OnPostActions
}

class PostDetail : RComponent<PostDetailProps, RState>(){


    override fun componentDidMount() {

    }

    override fun RBuilder.render() {
        div("postPage"){
            titlePostBar(
                    props.postItemData.title,
                    props.onPostActions
            )
            div("postDetail") {
                props.postItemData.content.map {
                    when(it){
                        is ImgElment ->{
                            img {
                                attrs{
                                    src = it.src
                                }
                            }
                        }
                        is H1Elment -> {
                            h1 {
                                +it.title
                            }
                        }
                        is PElment -> {
                            p {
                                it.content.map{
                                    when(it){
                                        is BElment ->{
                                            b {
                                                +it.strongText
                                            }
                                        }
                                        is LinkElment -> {
                                            a(
                                                    it.link,
                                                    "_blank"
                                            ) {
                                                +it.word
                                            }
                                        }
                                        is StrElment -> {
                                            +it.str
                                        }
                                        else -> {

                                        }
                                    }
                                }
                            }
                        }
                        is CodeElment -> {
                            div("codeContainer") {
                                prismComponent{
                                    attrs {
                                        codeToShow = it.code
                                        langSintax = it.lang
                                    }
                                }
                            }
                        }
                        else -> {

                        }
                    }
                }
                div("socialShare") {
                    p {
                        +"Si te ha gustado, comparte!"
                    }
                    div {
                        telegramShareButton {
                            attrs.url = window.location.href
                            telegramIcon {
                                attrs.size = 32
                                attrs.round = true
                            }
                        }
                        whatsappShareButton {
                            attrs.url = window.location.href
                            whatsappIcon {
                                attrs.size = 32
                                attrs.round = true
                            }
                        }
                        facebookShareButton {
                            attrs.url = window.location.href
                            facebookIcon {
                                attrs.size = 32
                                attrs.round = true
                            }
                        }
                        twitterShareButton {
                            attrs.url = window.location.href
                            twitterIcon {
                                attrs.size = 32
                                attrs.round = true
                            }
                        }
                    }
                }
            }
        }
    }

}


fun RBuilder.postDetail(
        postItemData: PostItemData,
        onPostActions: OnPostActions
) = child(PostDetail::class) {
    attrs.postItemData = postItemData
    attrs.onPostActions = onPostActions
}

