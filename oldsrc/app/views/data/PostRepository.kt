package app.views.data

import app.views.home.postslist.postlistitem.*

val allPostsData = listOf(
    getPost1(),
    getPost2(),
    getPost3()
)

fun getAllPostData():List<PostItemData>{
    return allPostsData
}

fun getPostDataById(idPost:String):PostItemData{
    return allPostsData.first{ it.id == idPost }
}