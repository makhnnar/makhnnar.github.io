package app.views.commons

import react.RBuilder
import react.dom.ul

@JsModule("src/app/views/home/profilebar/icons8-linkedin-out.svg")
external val linkedInLogo: dynamic

@JsModule("src/app/views/home/profilebar/icons8-github.svg")
external val githubLogo: dynamic

@JsModule("src/app/views/home/profilebar/icons8-twitter.svg")
external val twitterLogo: dynamic

@JsModule("src/app/views/home/profilebar/icons8-icons8.svg")
external val icons8Logo: dynamic

/**
 *todo:transform this using dynamic data, an array
 * */

fun RBuilder.socialGroupButtons(
        linkedIn: String = "https://www.linkedin.com/in/pedro-gomez-736b08145/",
        github: String = "https://github.com/makhnnar",
        twitter: String = "https://twitter.com/phgomez674",
        icon8: String = "https://icons8.com"
) {
    ul ("socialGroupButtons"){
        socialButton(
                linkedIn,
                "_blank",
                linkedInLogo,
                "linkedin"
        )
        socialButton(
                github,
                "_blank",
                githubLogo,
                "github"
        )
        socialButton(
                twitter,
                "_blank",
                twitterLogo,
                "twitter"
        )
        socialButton(
                icon8,
                "_blank",
                icons8Logo,
                "icons8"
        )
    }
}