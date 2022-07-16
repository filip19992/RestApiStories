package pl.filipwlodarczyk.stronaZeZdejciami.story;

import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StoryService {

    private final StoryRepo storyRepo;

    public StoryService(StoryRepo storyRepo) {
        this.storyRepo = storyRepo;
    }

    public void saveStory(Story story) {
        storyRepo.save(story);
    }

    public String findContent(Long id) {
       return storyRepo.findByContentById(id);
    }


    public Optional<List<Story>> findStoryByAuthorId(Long id) {
        try {
            return storyRepo.findStoryByAuthorId(id);
        } catch(Exception e) {
            throw new FileSystemNotFoundException("Couldnt find the story");
        }
    }


    public List<Story> findAllStories() {
        return storyRepo.findAll();
    }

    //TODO: This method must return 3 last stories wirtten by a particular user!!!
    public List<Story> findThreeLastStories(Long id) {
     //   List<Story> storyByAuthorId = findStoryByAuthorId(id);


return null;


    }
}
