package io.anymobi.springbootdatajpafinal.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<T> findList(T t);

    void delete(T entity);

}
