data class Comment (
    //Идентификатор комментария
    val id: Int,
    //Идентификатор автора комментария
    val fromId: Int,
    //Дата создания комментария в формате Unixtime
    val date: Int,
    //Текст комментария
    val text: String,

    //Информация о VK Donut
    val donut: CommentDonut,

    //Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо)
    val replyToUser: Int?,
    //Идентификатор комментария, в ответ на который оставлен текущий (если применимо)
    val replyToComment: Int?,

    //Медиавложения комментария (фотографии, ссылки и т.п.)
    val attachments: Attachment?,

    //Массив идентификаторов родительских комментариев
    val parentsStack: List<Int>?,

    //Информация о вложенной ветке комментариев
    val thread: CommentThread?
)

data class CommentDonut(
    //является ли комментатор подписчиком VK Donut
    val isDonut: Boolean,
    //заглушка для пользователей, которые не оформили подписку VK Donut
    val placeholder: String
)

data class CommentThread(
    //количество комментариев в ветке
    val count: Int,
    //массив объектов комментариев к записи (только для метода wall.getComments
    val items: List<Comment>?,
    //может ли текущий пользователь оставлять комментарии в этой ветке
    val canPost: Boolean,
    //нужно ли отображать кнопку «ответить» в ветке
    val showReplyButton: Boolean,
    //могут ли сообщества оставлять комментарии в ветке
    val groupsCanPost: Boolean
)

data class ReportComment(
    //Идентификатор пользователя или сообщества, которому принадлежит комментарий
    val ownerId: Int,
    //Идентификатор комментария
    val commentId: Int,
    //Причина жалобы
    val reason:ReportReasons
)