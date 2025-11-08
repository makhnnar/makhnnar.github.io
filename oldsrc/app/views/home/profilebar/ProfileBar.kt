package app.views.home.profilebar

import app.views.commons.socialGroupButtons
import kotlinx.html.id
import react.RBuilder
import react.dom.*

@JsModule("src/app/views/home/profilebar/photo-profile.jpg")
external val profilePhoto: dynamic


fun RBuilder.profileBar(
        profileData: ProfileData
) {
    div("profileBar") {
        img {
            attrs{
                id = "imgProfile"
                src = profilePhoto
            }
        }
        h1 {
           +profileData.fullName
        }
        p {
            +"\"${profileData.description}\""
        }
        div("socialContainer") {
            socialGroupButtons(
                    profileData.linkedIn,
                    profileData.github,
                    profileData.twitter,
                    profileData.icon8
            )
        }
    }
}