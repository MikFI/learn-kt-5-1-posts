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
                Likes(3, false, true, true),
                Reposts(3, false),
                10, PostType.POST, 2, false, false, false, false,
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
            Likes(123, true, true, true),
            Reposts(123, true),
            123, PostType.REPLY, 123, false, false, false, false,
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
            Likes(123, true, true, true),
            Reposts(123, true),
            123, PostType.REPLY, 123, false, false, false, false,
            Donut(false, 123, true, EditMode.ALL),
            false, false, 123
        )

        val updated = WallService.update(999999999, updatedPost)

        assert(!updated)
    }


}