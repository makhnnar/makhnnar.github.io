package app.views.home.postslist.postlistitem

data class PostItemData(
        val id:String,
        val title: String,
        val description:String,
        val photo:String,
        val content:List<ElementData>
)

sealed class ElementData

data class ImgElment(val src:String):ElementData()
data class H1Elment(val title:String):ElementData()
data class PElment(val content:List<ElementData>):ElementData()
data class BElment(val strongText:String):ElementData()
data class LinkElment(val link:String,val word:String):ElementData()
data class StrElment(val str:String):ElementData()
data class CodeElment(val code:String,val lang:String):ElementData()