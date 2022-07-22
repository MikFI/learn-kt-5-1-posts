import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class WallServiceTest {

    @Test
    fun addingNewPost() {
        WallService.clearPosts()
        WallService.add(
            Post(
                0, 1, 2, 3, 4, "qq", 5, 6, false,
                Comments(1, true, false, false, false),
                Copyright(2, "www.ru", "aa", "zz"),
                PostLikes(3, false, true, true),
                PostReposts(3, false),
                10, PostType.POST,
                listOf(
                    AttachmentAudio(
                        Audio(
                            123, 123, "ЛОПАТА НАВОЗА", "Красный Кочегар", 191, "www.org",
                            null, null, MusicGenres.RAP_HIPHOP, 1674656453, null, true
                        )
                    ),
                    AttachmentPhoto(
                        Photo(
                            345, 345, 345, 345, "Как мы с Васяном шли в горы и упали",
                            1647564756, 1000, 1500, listOf(PhotoSize("M", "aaa", 1000, 1000))
                        )
                    ),
                    AttachmentVideo(
                        Video(
                            141, 34, "Ржака", "", 122, 1645576847,
                            VideoCover(300, 400, null, "www.ru"),
                            VideoPreview(400, 500, "www.www"),
                            1647584763, 33, 22, null, 123, 45, true, true, "f633oefn9",
                            true, false, false, false, false, false, false, true,
                            false, 500, 600, null, false, false, true, true,
                            VideoType.MUSICVIDEO, null, LiveStatus.FINISHED, true, false, false,
                            VideoLikes(1, true),
                            VideoReposts(1, false, 11, 22)
                        )
                    ),
                    AttachmentSticker(
                        Sticker(
                            34, 23, listOf(
                                StickerCopy("gaa", "www.gg", 100, 100)
                            ), null, "www.ru", true
                        )
                    ),
                    AttachmentFile(
                        File(33, 44, "PRON", 666_666, "mp4", "www.kek", 1456789, FileTypes.IMAGE)
                    )
                ), 2, false, false, false, false,
                PostDonut(false, 0, true, EditMode.ALL),
                false, false, 2
            )
        )
        val latest = WallService.getLastPost()
        assert(latest.id > 0)
    }

    @Test
    fun findExistingPost() {
        addingNewPost()

        val index = WallService.findPost(1)

        assertNotNull(index)
    }

    @Test
    fun findNotExistingPost() {
        addingNewPost()

        val index = WallService.findPost(999999999)

        assertNull(index)
    }

    @Test
    fun updatingExistingPost() {
        addingNewPost()

        val updatedPost = Post(
            123, 123, 123, 123, 123, "qweqwe", 123, 123, false,
            Comments(123, true, false, false, false),
            Copyright(123, "", "", ""),
            PostLikes(123, true, true, true),
            PostReposts(123, true),
            123, PostType.REPLY, null, 123, false, false, false, false,
            PostDonut(false, 123, true, EditMode.ALL),
            false, false, 123
        )

        val updated = WallService.update(1, updatedPost)

        assert(updated)
    }

    @Test
    fun updatingNotExistingPost() {
        addingNewPost()

        val updatedPost = Post(
            123, 123, 123, 123, 123, "qweqwe", 123, 123, false,
            Comments(123, true, false, false, false),
            Copyright(123, "", "", ""),
            PostLikes(123, true, true, true),
            PostReposts(123, true),
            123, PostType.REPLY, null, 123, false, false, false, false,
            PostDonut(false, 123, true, EditMode.ALL),
            false, false, 123
        )

        val updated = WallService.update(999999999, updatedPost)

        assert(!updated)
    }

    @Test
    fun commentExistingPost() {
        addingNewPost()

        val comment = Comment(
            1, 2, 3, "aa",
            CommentDonut(false, ""),
            4, null, null, null, null
        )

        val result = WallService.createComment(1, comment)

        assertEquals(comment, result)
    }

    @Test
    fun commentNotExistingPost() {
        addingNewPost()

        val comment = Comment(
            1, 2, 3, "aa",
            CommentDonut(false, ""),
            4, null, null, null, null
        )

        assertFailsWith<PostNotFoundException> {
            WallService.createComment(999999999, comment)
        }
    }

    @Test
    fun reportExistingComment() {
        addingNewPost()
        commentExistingPost()

        val result = WallService.reportComment(1, ReportReasons.SPAM)

        assertNotNull(result)
    }

    @Test
    fun reportNotExistingComment() {
        addingNewPost()
        commentExistingPost()

        assertFailsWith<CommentNotFoundException> {
            WallService.reportComment(999999999, ReportReasons.SPAM)
        }
    }


}