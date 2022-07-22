sealed class Attachment(
    //тип вложения
    val type: AttachmentType
)

data class AttachmentVideo(
    val video: Video
) : Attachment(AttachmentType.VIDEO)

data class AttachmentAudio(
    val audio: Audio
) : Attachment(AttachmentType.AUDIO)

data class AttachmentPhoto(
    val photo: Photo
) : Attachment(AttachmentType.PHOTO)

data class AttachmentFile(
    val file: File
) : Attachment(AttachmentType.FILE)

data class AttachmentSticker(
    val sticker: Sticker
) : Attachment(AttachmentType.STICKER)

data class Video(
    //Идентификатор видеозаписи
    val id: Int,
    //Идентификатор владельца видеозаписи
    val ownerId: Int,
    //Название видеозаписи
    val title: String,
    //Текст описания видеозаписи
    val description: String,
    //Длительность ролика в секундах
    val duration: Int,
    //Дата создания видеозаписи в формате Unixtime
    val date: Int,

    //Изображение обложки
    val cover: VideoCover,

    //Изображение первого кадра
    val preview: VideoPreview,

    //Дата добавления видеозаписи пользователем или группой в формате Unixtime
    val addingDate: Int,
    //Количество просмотров видеозаписи
    val views: Int,
    //Если видео внешнее, количество просмотров ВКонтакте
    val localViews: Int,
    //Количество комментариев к видеозаписи. Поле не возвращается, если комментарии недоступны
    val comments: Int?,
    //URL страницы с плеером, который можно использовать для воспроизведения ролика в браузере
    val player: Int,
    //Название платформы (для видеозаписей, добавленных с внешних сайтов)
    val platform: Int,
    //Может ли пользователь добавить видеозапись к себе
    val canAdd: Boolean,
    //Поле возвращается, если видеозапись приватная (например, была загружена в личное сообщение), всегда содержит 1
    val isPrivate: Boolean?,
    //Ключ доступа к объекту
    val accessKey: String,
    //Поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1
    val processing: Boolean?,
    //true, если объект добавлен в закладки у текущего пользователя
    val isFavorite: Boolean,
    //Может ли пользователь комментировать видео
    val canComment: Boolean,
    //Может ли пользователь редактировать видео
    val canEdit: Boolean,
    //Может ли пользователь добавить видео в список <<Мне нравится>>
    val canLike: Boolean,
    //Может ли пользователь сделать репост видео
    val canRepost: Boolean,
    //Может ли пользователь подписаться на автора видео
    val canSubscribe: Boolean,
    //Может ли пользователь добавить видео в избранное
    val canAddToFaves: Boolean,
    //Может ли пользователь прикрепить кнопку действия к видео
    val canAttachLink: Boolean,
    //Ширина видео
    val width: Int,
    //Высота видео
    val height: Int,
    //Идентификатор пользователя, загрузившего видео, если оно было загружено в группу одним из участников
    val userId: Int?,
    //Конвертируется ли видео
    val converting: Boolean,
    //Добавлено ли видео в альбомы пользователя
    val added: Boolean,
    //Подписан ли пользователь на автора видео
    val isSubscribed: Boolean,
    //Поле возвращается в том случае, если видео зациклено, всегда содержит 1
    val repeat: Boolean?,
    //Тип видеозаписи
    val videoType: VideoType,
    //Баланс донатов в прямой трансляции
    val balance: Int?,
    //Статус прямой трансляции
    val liveStatus: LiveStatus,
    //Поле возвращается в том случае, если видеозапись является прямой трансляцией, всегда содержит 1.
    //(в этом случае в поле duration содержится значение 0)
    val live: Boolean?,
    //Поле свидетельствует о том, что трансляция скоро начнётся. Для live =1
    val upcoming: Boolean,
    //Количество зрителей прямой трансляции
    val spectators: Boolean,

    //Содержит объект отметки «Мне нравится»
    val likes: VideoLikes,

    //Содержит объект репоста
    val reposts: VideoReposts
)

data class Audio(
    //Идентификатор аудиозаписи
    val id: Int,
    //Идентификатор владельца аудиозаписи
    val ownerId: Int,
    //Исполнитель
    val artist: String,
    //Название композиции
    val title: String,
    //Длительность аудиозаписи в секундах
    val duration: Int,
    //Ссылка на mp3
    val url: String,
    //Идентификатор текста аудиозаписи (если доступно)
    val lyricsId: Int?,
    //Идентификатор альбома, в котором находится аудиозапись (если присвоен)
    val albumId: Int?,
    //Идентификатор жанра
    val genreId: MusicGenres,
    //Дата добавления в формате Unixtime
    val date: Int,
    //1, если включена опция «Не выводить при поиске». Если опция отключена, поле не возвращается
    val noSearch: Boolean?,
    //1, если аудио в высоком качестве
    val isHQ: Boolean
)

data class Photo(
    //Идентификатор фотографии
    val id: Int,
    //Идентификатор альбома, в котором находится фотография
    val albumId: Int,
    //Идентификатор владельца фотографии
    val ownerId: Int,
    //Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе).
    //Для фотографий, размещенных от имени сообщества, user_id = 100
    val userId: Int,
    //Текст описания фотографии
    val description: String,
    //Дата добавления в формате Unixtime
    val date: Int,
    //Ширина оригинала фотографии в пикселах
    val width: Int,
    //Высота оригинала фотографии в пикселах
    val height: Int,
    //Массив с копиями изображения в разных размерах
    //Поле возвращается только при передаче параметра photo_sizes = 1 в запросе
    val sizes: List<PhotoSize>?
)

data class File(
    //Идентификатор файла
    val id: Int,
    //Идентификатор пользователя, загрузившего файл
    val ownerId: Int,
    //Название файла
    val title: String,
    //Размер файла в байтах
    val size: Int,
    //Расширение файла
    val ext: String,
    //Адрес файла, по которому его можно загрузить
    val url: String,
    //Дата добавления в формате Unixtime
    val date: Int,
    //Тип файла
    val fileType: FileTypes
)

data class Sticker(
    //Идентификатор набора
    val ProductId: Int,
    //Идентификатор стикера
    val stickerId: Int,
    //Изображения для стикера (с прозрачным фоном)
    val images: List<StickerCopy>?,
    //Изображения для стикера (с непрозрачным фоном)
    val imagesWithBackground: List<StickerCopy>?,
    //URL анимации стикера
    val animationUrl: String,
    //Информация о том, доступен ли стикер
    val isAllowed: Boolean
)


//Изображение обложки видеофайла
data class VideoCover(
    //высота изображения
    val height: Int,
    //ширина изображения
    val width: Int,
    //поле возвращается, если изображение с отбивкой, всегда содержит 1
    val with_padding: Boolean?,
    //ссылка на изображение
    val url: String
)

//Изображение первого кадра
data class VideoPreview(
    //высота изображения
    val height: Int,
    //ширина изображения
    val width: Int,
    //ссылка на изображение
    val url: String
)

data class VideoLikes(
    //количество лайков
    override val count: Int,
    //добавлено ли видео в список «Мне нравится» текущего пользователя
    override val userLikes: Boolean
) : Likes

data class VideoReposts(
    //счетчик общего количества репостов. Содержит сумму репостов на стену и в личные сообщения
    override val count: Int,
    //информация о том, сделал ли текущий пользователь репост этого видео
    override val userReposted: Boolean,
    //счетчик репостов на стену
    val wallCount: Int,
    //счетчик репостов в личные сообщения
    val mailCount: Int
) : Reposts

//копия изображения в другом размере
data class PhotoSize(
    //тип копии
    val type: String,
    //URL копии
    val url: String,
    //ширина в px
    val width: Int,
    //высота в px
    val height: Int,
)

//копия изображения в другом размере
data class StickerCopy(
    //тип копии
    val type: String,
    //URL копии изображения
    val url: String,
    //ширина копии в px
    val width: Int,
    //высота копии в px
    val height: Int,
)