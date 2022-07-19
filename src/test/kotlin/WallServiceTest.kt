import org.junit.Test

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
                listOf(AttachmentAudio(Audio(123,123,"ЛОПАТА НАВОЗА","Красный Кочегар",191,"www.org",
                null,null,MusicGenres.RAP_HIPHOP,1674656453,null,true)),
                AttachmentPhoto(Photo(345,345,345,345,"Как мы с Васяном шли в горы и упали",
                1647564756,1000,1500,null)),
                AttachmentVideo(Video(141,34,"Ржака","",122,1645576847,
                    VideoCover(300,400,null,"www.ru"),
                    VideoPreview(400,500,"www.www"),
                    1647584763,33,22,null,123,45, true,true,"f633oefn9",
                    true,false,false,false,false,false,false,true,
                    false,500,600,null,false,false,true,true,
                    VideoType.MUSICVIDEO,null,false,true,false,false,
                    VideoLikes(1,true),
                    VideoReposts(1,false,11,22)
                ))),2, false, false, false, false,
                Donut(false, 0, true, EditMode.ALL),
                false, false, 2
            )
        )
        val latest = WallService.getLastPost()
        assert(latest.id > 0)
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
            Donut(false, 123, true, EditMode.ALL),
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
            Donut(false, 123, true, EditMode.ALL),
            false, false, 123
        )

        val updated = WallService.update(999999999, updatedPost)

        assert(!updated)
    }


}