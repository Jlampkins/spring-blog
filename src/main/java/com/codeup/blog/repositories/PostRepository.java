package com.codeup.blog.repositories;
import com.codeup.blog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    // List<Property> findAll():
    // Property findOne(Long id);  -- this already exist thanks to CrudRepo
    // void save (Property property); handles Create and Update
    // void delete(Property prop);
//    Post findByUserId(long userId);
    List<Post> findAllByUserId(long userId);


}