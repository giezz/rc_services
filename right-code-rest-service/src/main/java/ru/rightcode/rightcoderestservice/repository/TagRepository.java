package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    // get all tags by article id
    // List<Tag> findAllByArticleId(Long id);


}
