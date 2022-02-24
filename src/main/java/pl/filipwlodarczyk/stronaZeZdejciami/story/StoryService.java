package pl.filipwlodarczyk.stronaZeZdejciami.story;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    private final StoryRepo storyRepo;

    public StoryService(StoryRepo storyRepo) {
        this.storyRepo = storyRepo;
    }

    public void saveStory(StoryModel storyModel) {
        storyRepo.save(storyModel);
    }

    //TODO: Send stories with the author's username, its title and content as a JSON object!!!
    public String findContent(Long id) {
       return storyRepo.findByContentById(id);
    }


    public List<StoryModel> findStoryByAuthorId(Long id) {
        return storyRepo.findStoryByAuthorId(id);
    }

    public List<StoryModel> findAllStories() {
        return storyRepo.findAll();
    }
}
