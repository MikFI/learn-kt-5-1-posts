class PostNotFoundException(id: Int) : RuntimeException("Пост с id=$id не найден")

class CommentNotFoundException(id: Int) : RuntimeException("Комментарий с id=$id не найден")