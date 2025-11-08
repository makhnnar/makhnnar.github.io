package app.views.home.postslist.postlistitem

import app.views.home.OnPostActions
import firebase.fireBase
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.dom.div
import react.dom.h3
import react.dom.img
import react.dom.p
import kotlin.browser.document
import kotlin.browser.window


fun RBuilder.postListItem(
        postItemData: PostItemData,
        onPostActions: OnPostActions
) {
    div("itemListPost") {

        div("titlePhotoItemListPost") {

            img {
                attrs{
                    id = "imgItemListPost"
                    src = postItemData.photo
                }
            }

            h3("titleItemListPost") {
                +postItemData.title
            }
        }

        p("descriptionItemListPost") {
            +postItemData.description
        }

        attrs{
            onClickFunction = {
                fireBase.app().analytics().logEvent("click_post:${postItemData.id}")
                //logEvent("click_post:${postItemData.id}")
                //window.location.href = "$DETAIL_PATH/${postItemData.id}"
                window.scrollTo(0.0,0.0)
                onPostActions.goToPost(postItemData.id)
            }
        }
    }
}