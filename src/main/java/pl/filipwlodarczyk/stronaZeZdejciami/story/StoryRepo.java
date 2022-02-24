package pl.filipwlodarczyk.stronaZeZdejciami.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import pl.filipwlodarczyk.stronaZeZdejciami.user.AppUser;

import java.util.List;

@Repository
public interface StoryRepo extends JpaRepository<StoryModel, Long> {



    @Query("select content from StoryModel s where s.id = :id")
    String findByContentById(@Param("id")Long id);


    @Query("select s from StoryModel s where s.appUser = (select c from AppUser c where id=:id)")
    List<StoryModel> findStoryByAuthorId(@Param("id")Long id);
}
