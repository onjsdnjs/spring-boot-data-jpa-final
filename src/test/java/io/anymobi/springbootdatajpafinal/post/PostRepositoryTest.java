package io.anymobi.springbootdatajpafinal.post;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void event() {
        Post post = new Post();
        post.setTitle("onjsdnjs");
        PostPublishedEvent postPublishedEvent = new PostPublishedEvent(post);

        applicationContext.publishEvent(postPublishedEvent);
    }

    @Test
    public void domainEvent() {

        Post post = new Post();
        post.setTitle("onjsdnjs");
        post.setContent("seumstone");
        post.setDate(new Date());

        assertThat(postRepository.contains(post)).isFalse();

        Post newPost = postRepository.save(post.publish());

        assertThat(postRepository.contains(post)).isTrue();

    }

    @Test
    public void crud() {

        Post post = new Post();
        post.setTitle("onjsdnjs");
        post.setContent("seumstone");
        post.setDate(new Date());

        assertThat(postRepository.contains(post)).isFalse();

        Post newPost = postRepository.save(post);

        assertThat(postRepository.contains(post)).isTrue();

//        postRepository.findList(post);

        postRepository.delete(newPost);

        postRepository.flush();

    }


}