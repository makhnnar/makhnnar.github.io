package app.views.home

import app.views.home.postslist.postlistitem.PostItemData
import app.views.home.postslist.postsList
import app.views.home.profilebar.ProfileData
import app.views.home.profilebar.profileBar
import react.*
import react.dom.*

interface HomeProps : RProps {
    var postsItems: List<PostItemData>
    var onPostActions:OnPostActions
}

interface OnPostActions{

    fun goToPost(idPost:String)
    fun backToHome()

}

class Home : RComponent<HomeProps, RState>(){

    override fun RBuilder.render() {
        div("home") {
            profileBar(
                    ProfileData(
                            "El Blog de Pedro",
                            "Las aventuras de un programador que quiere compartir algo con el mundo",
                            "https://i.postimg.cc/qtMKQ920/orange-tabby-cat-near-window-2071873.jpg",
                            "https://www.linkedin.com/in/pedro-gomez-736b08145/",
                            "https://github.com/makhnnar",
                            "https://twitter.com/phgomez674",
                            "https://icons8.com"
                    )
            )
            postsList(
                    props.postsItems,
                    props.onPostActions
            )
        }
    }

}

fun RBuilder.home(
        postsItems: List<PostItemData>,
        onPostActions: OnPostActions
) = child(Home::class) {
    attrs.postsItems = postsItems
    attrs.onPostActions = onPostActions
}