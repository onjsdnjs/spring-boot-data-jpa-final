package io.anymobi.springbootdatajpafinal.post;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository<Post> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> findList(Post post) {

        return entityManager.createQuery("select p from Post as p", Post.class).getResultList();
    }

    @Override
    public void delete(Post post) {

        System.out.println("====== delete Post ===========");
        entityManager.remove(post);
    }
}
