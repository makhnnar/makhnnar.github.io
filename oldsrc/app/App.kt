package app

import app.views.data.getAllPostData
import app.views.data.getPostDataById
import app.views.home.OnPostActions
import app.views.home.home
import app.views.home.postslist.postlistitem.*
import app.views.postdetail.postDetail
import firebase.FirebaseOptions
import firebase.fireBase
import react.*
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

const val DETAIL_PATH = "/postDetail"

interface RoutePostDetailProps : RProps {
    var idPost :String
}

interface AppState : RState {
    var idPost :String
    var secction:Section
}

class App : RComponent<RProps, AppState>(),OnPostActions {

    override fun AppState.init(props: RProps) {
        //initializeApp()
        idPost = "1"
        secction = Section.HOME
        //todo: no se esta ejecutando este init
    }

    override fun componentWillMount() {
        setState {
            idPost = "1"
            secction = Section.HOME
        }
        var firebaseOptions = FirebaseOptions()
        firebaseOptions.apply {
            this.apiKey = "AIzaSyB8o4J6qso5CbDXWFAtV1nqZn_8vBLw4UA"
            this.authDomain = "mykotlintips.firebaseapp.com"
            this.databaseURL = "https://mykotlintips.firebaseio.com"
            this.projectId = "mykotlintips"
            this.storageBucket = "mykotlintips.appspot.com"
            this.messagingSenderId = "204702118352"
            this.appId = "1:204702118352:web:ae99ab4a800cfcb5f409d5"
            this.measurementId = "G-0GTG4V7Q09"
        }
        fireBase.initializeApp(
                firebaseOptions
        )
        console.log("Inicializo el componente")
        //super.componentWillMount()
    }

    override fun RBuilder.render() {
        when(state.secction){
            Section.HOME -> {
                home(
                        getAllPostData(),
                        this@App
                )
            }
            Section.POST -> {
                postDetail(
                        getPostDataById(state.idPost),
                        this@App
                )
            }
        }
        /*browserRouter {
            switch {
                route("/", exact = true) {
                    home(
                        getAllPostData()
                    )
                }
                route<RoutePostDetailProps>("$DETAIL_PATH/:idPost") {
                    props -> postDetail(
                        getPostDataById(props.match.params.idPost)
                    )
                }
            }
        }*/
    }

    override fun goToPost(idPost: String) {
        setState {
            secction = Section.POST
            this.idPost = idPost
        }
    }

    override fun backToHome() {
        setState {
            secction = Section.HOME
        }
    }

}

fun RBuilder.app() = child(App::class) {}
