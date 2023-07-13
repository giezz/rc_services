package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.Tag;
import ru.rightcode.rightcoderestservice.model.TagsCount;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

//    @EntityGraph(attributePaths = {"articles"})
    @Query("select t from Tag t where t.name like :name%")
    List<Tag> findAllByNameIgnoreCaseLike(@Param("name") String name);

    @Query("select count(*) as count, t.id as id, t.name as name from Tag t join t.articles group by t.id, t.name order by count(*) desc")
    Page<TagsCount> findPopularTags(Pageable pageable);

}
