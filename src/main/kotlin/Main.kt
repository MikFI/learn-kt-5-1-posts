data class Post(
    //Идентификатор записи
    val id: Int,
    //Идентификатор владельца стены, на которой размещена запись
    val ownerId: Int,
    //Идентификатор автора записи (от чьего имени опубликована запись)
    val fromId: Int,
    //Идентификатор администратора, который опубликовал запись
    //(возвращается только для сообществ при запросе с ключом доступа администратора)
    //Возвращается в записях, опубликованных менее 24 часов назад
    val createdBy: Int?,
    //Время публикации записи в формате unixtime
    val date: Int,
    //Текст записи
    val text: String,
    //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyOwnerId: Int,
    //Идентификатор записи, в ответ на которую была оставлена текущая
    val replyPostId: Int,
    //true, если запись была создана с опцией «Только для друзей»
    val friendsOnly: Boolean,

    //Информация о комментариях к записи
    val comments: Comments?,

    //Источник материала
    val copyright: Copyright?,

    //Информация о лайках к записи
    val likes: Likes,

    //Информация о репостах записи («Рассказать друзьям»)
    val reposts: Reposts?,

    //Число просмотров записи
    val views: Int,
    //Тип записи
    val postType: PostType,

    //Медиавложения записи (фотографии, ссылки и т.п.)
    val attachments: List<Attachment>?,

    //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val signerId: Int?,
    //Может ли текущий пользователь закрепить запись
    val canPin: Boolean,
    //Может ли текущий пользователь удалить запись
    val canDelete: Boolean,
    //Может ли текущий пользователь редактировать запись
    val canEdit: Boolean,
    //Информация о том, что запись закреплена
    val isPinned: Boolean,

    //Информация о записи VK Donut
    val donut: PostDonut?,

    //Информация о том, содержит ли запись отметку «реклама»
    val markedAsAds: Boolean,
    //true, если объект добавлен в закладки у текущего пользователя
    val isFavorite: Boolean,
    //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    val postponedId: Int?
)

data class Comments(
    //количество комментариев
    val count: Int,
    //информация о том, может ли текущий пользователь комментировать запись
    val canPost: Boolean,
    //информация о том, могут ли сообщества комментировать запись
    val groupsCanPost: Boolean,
    //может ли текущий пользователь закрыть комментарии к записи
    val canClose: Boolean,
    //может ли текущий пользователь открыть комментарии к записи
    val canOpen: Boolean
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class PostLikes(
    //число пользователей, которым понравилась запись
    override val count: Int,
    //наличие отметки «Мне нравится» от текущего пользователя
    override val userLikes: Boolean,
    //информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    val canLike: Boolean,
    //информация о том, может ли текущий пользователь сделать репост записи
    val canPublish: Boolean,
) : Likes

data class PostReposts(
    //число пользователей, скопировавших запись
    override val count: Int,
    //наличие репоста от текущего пользователя
    override val userReposted: Boolean
) : Reposts

data class PostDonut(
    //запись доступна только платным подписчикам VK Donut
    val isDonut: Boolean,
    //время, в течение которого запись будет доступна только платным подписчикам VK Donut
    val paidDuration: Int,

    //заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи
    //val placeholder: Placeholder,

    //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut
    val canPublishFreeCopy: Boolean,
    //информация о том, какие значения VK Donut можно изменить в записи
    //all — всю информацию о VK Donut
    //duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut
    val editMode: EditMode
)

object WallService {
    private var posts = emptyArray<Post>()
    private var postId = 1

    fun add(post: Post): Post {
        val result = post.copy(id = postId)
        postId++
        posts += result
        return result
    }

    fun update(id: Int, newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] =
                    newPost.copy(id = posts[index].id, ownerId = posts[index].ownerId, date = posts[index].date)
                return true
            }
        }
        return false
    }

    fun getLastPost(): Post {
        return posts.last()
    }

    fun clearPosts() {
        posts = emptyArray<Post>()
        postId = 1
    }
}


fun main(args: Array<String>) {
    WallService.add(
        Post(
            0, 1, 2, 3, 4, "qq", 5, 6, false,
            Comments(1, true, false, false, false),
            Copyright(2, "www.ru", "aa", "zz"),
            PostLikes(3, false, true, true),
            PostReposts(3, false),
            10, PostType.POST, null, 2, false, false, false, false,
            PostDonut(false, 0, true, EditMode.ALL),
            false, false, 2
        )
    )
    WallService.add(
        Post(
            0, 22, 33, 44, 55, "xxg", 66, 77, true,
            Comments(40, true, false, false, false),
            Copyright(0, "", "", ""),
            PostLikes(23, true, true, true),
            PostReposts(17, true),
            100, PostType.SUGGEST,
            listOf(AttachmentFile(File(17,22,"bug",2030,"txt","www.ru",1627367475,FileTypes.TEXT)),
                AttachmentPhoto(Photo(44,22,11,55,"скриншот баги",1645364756,640,480,null))),
            2, false, false, false, false,
            PostDonut(false, 0, true, EditMode.ALL),
            false, false, 2
        )
    )
    WallService.add(
        Post(
            0, 2345, 2345, 3245, 245, "tgjrtu", 456, 2457, false,
            Comments(123, true, false, false, false),
            Copyright(0, "", "", ""),
            PostLikes(54, true, true, true),
            PostReposts(44, true),
            4573, PostType.REPLY, null, 2, false, false, false, false,
            PostDonut(false, 0, true, EditMode.ALL),
            false, false, 2
        )
    )

    val updatedPost = Post(
        123, 123, 123, 123, 123, "qweqwe", 123, 123, false,
        Comments(123, true, false, false, false),
        Copyright(123, "", "", ""),
        PostLikes(123, true, true, true),
        PostReposts(123, true),
        123, PostType.REPLY, null,123, false, false, false, false,
        PostDonut(false, 123, true, EditMode.ALL),
        false, false, 123
    )

    WallService.update(2, updatedPost)

}