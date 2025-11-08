package app.views.home.postslist

import app.views.home.OnPostActions
import app.views.home.postslist.postlistitem.PostItemData
import app.views.home.postslist.postlistitem.postListItem
import react.RBuilder
import react.dom.div

fun RBuilder.postsList(
        postsItems: List<PostItemData>,
        onPostActions: OnPostActions
) {
    div("listPost") {
        postsItems.map {
            postListItem(
                    it,
                    onPostActions
            )
        }
    }
}