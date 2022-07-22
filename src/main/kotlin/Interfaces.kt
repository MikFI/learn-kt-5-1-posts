interface Likes {
    //число пользователей, которым понравилась запись
    val count: Int
    //наличие отметки «Мне нравится» от текущего пользователя
    val userLikes: Boolean
}

interface Reposts {
    //число пользователей, скопировавших запись
    val count: Int
    //наличие репоста от текущего пользователя
    val userReposted: Boolean
}