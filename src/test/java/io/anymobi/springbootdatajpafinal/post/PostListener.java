package io.anymobi.springbootdatajpafinal.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class PostListener /*implements ApplicationListener<PostPublishedEvent>*/ {
    /*@Override
    public void onApplicationEvent(PostPublishedEvent postPublishedEvent) {
        System.out.println("====================");
        System.out.println(postPublishedEvent.getPost().getTitle() + " is published");
    }*/

    @EventListener
    public void onApplicationEvent(PostPublishedEvent postPublishedEvent) {
        System.out.println("====================");
        System.out.println(postPublishedEvent.getPost().getTitle() + " is published");
        System.out.println("=====================");
    }
}
