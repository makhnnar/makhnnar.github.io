package app.views.home.profilebar

data class ProfileData(
        val fullName: String,
        val description: String,
        val photo: String,
        val linkedIn: String,
        val github: String,
        val twitter: String,
        val icon8: String = ""
)