package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.Tag;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

//    @EntityGraph(attributePaths = {"articles"})
    @Query("select t from Tag t where t.name like :name%")
    List<Tag> findAllByNameIgnoreCaseLike(@Param("name") String name);

}
