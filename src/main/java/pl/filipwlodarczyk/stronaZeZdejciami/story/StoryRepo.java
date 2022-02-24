package pl.filipwlodarczyk.stronaZeZdejciami.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepo extends JpaRepository<Story, Long> {



    @Query("select content from Story s where s.id = :id")
    String findByContentById(@Param("id")Long id);


    @Query("select s from Story s where s.appUser = (select c from AppUser c where id=:id)")
    List<Story> findStoryByAuthorId(@Param("id")Long id);
}
