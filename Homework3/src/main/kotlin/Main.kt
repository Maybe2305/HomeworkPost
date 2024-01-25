data class Post(
    val id: Int = 1,
    val ownerId: Int = 1,
    val fromId: Int = 2,
    val text: String = "Just post",
    val replyOwnerId: Int = 2,
    val signerId: Int = 1,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

object WallService {
    var posts = emptyArray<Post>()

    private var idPost = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = idPost++)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        if (index >= 0) {
            posts[index] = post
            return true
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        idPost = 1
    }
}

fun main() {
    val post1 = Post()
    WallService.add(post1)
    println(post1)

    val post2 = Post(id = 2)
    WallService.add(post2)
    println(post2)

    val updatedPost = Post(text = "Updated Post")
    val isUpdate = WallService.update(updatedPost)
    println(isUpdate)
}