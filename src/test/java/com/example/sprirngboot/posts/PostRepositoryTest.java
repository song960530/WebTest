package com.example.sprirngboot.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsrepository;

    @After
    public void cleanup() {
        postsrepository.deleteAll();
    }

    @Test
    public void saveAndWrite() {

        String title = "테스트 게시물";
        String content = "테스트 본분";

        postsrepository.save(
                Posts.builder().
                        title(title).
                        content(content).
                        author("test@test.com").
                        build());

        List<Posts> postsList = postsrepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
