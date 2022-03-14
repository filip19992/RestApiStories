package pl.filipwlodarczyk.stronaZeZdejciami.story;

import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<Story> findStoryByAuthorId(Long id) {
        return storyRepo.findStoryByAuthorId(id);
    }

    public List<Story> findAllStories() {
        return storyRepo.findAll();
    }

    //TODO: This method must return 3 last stories wirtten by a particular user!!!
    public List<Story> findThreeLastStories(Long id) {
        List<Story> storyByAuthorId = findStoryByAuthorId(id);


return null;


    }
}
