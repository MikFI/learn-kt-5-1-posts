enum class PostType {
    POST, COPY, REPLY, POSTPONE, SUGGEST
}

enum class EditMode {
    ALL, DURATION
}

enum class AttachmentType {
    PHOTO, VIDEO, AUDIO, FILE, STICKER
}

enum class VideoType {
    VIDEO, MUSICVIDEO, MOVIE
}

enum class LiveStatus {
    WAITING, STARTED, FINISHED, FAILED, UPCOMING
}

enum class MusicGenres {
    ROCK, POP, RAP_HIPHOP, EASY_LISTENING, HOUSE_DANCE,
    INSTRUMENTAL, METAL, ALTERNATIVE, DUBSTEP,
    JAZZ_BLUES, DRUM_BASS, TRANCE, CHANSON, ETHNIC,
    ACOUSTIC_VOCAL, REGGAE, CLASSICAL, INDIE_POP,
    SPEECH, ELECTROPOP_DISCO, OTHER
}

enum class FileTypes {
    TEXT, ARCHIVE, GIF, IMAGE, AUDIO, VIDEO, EBOOK, UNKNOWN
}