package pl.filipwlodarczyk.stronaZeZdejciami.story;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }


    @GetMapping("/story/utilsstory/{id}")
    public String findContentById(@PathVariable("id") Long id) {
        return storyService.findContent(id);
    }


    //TODO: make method returns json with list of stories from author id!!!
    @GetMapping("/story/{authorId}")
    public List<StoryModel> findStoriesByAuthorId(@PathVariable("authorId") Long authorId) {
        return storyService.findStoryByAuthorId(authorId);
    }

    @GetMapping("/stories/all")
    public List<StoryModel> findAllStories(Model model) {
        return storyService.findAllStories();
    }

    @GetMapping("/stories")
    public String getStories(Model model) {
        List<StoryModel> allStories = storyService.findAllStories();
        Model stories = model.addAttribute("stories", allStories);
        return "stories/allString";
    }



}
