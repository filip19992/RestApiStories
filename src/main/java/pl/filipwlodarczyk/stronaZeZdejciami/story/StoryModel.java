package pl.filipwlodarczyk.stronaZeZdejciami.story;

import pl.filipwlodarczyk.stronaZeZdejciami.user.AppUser;

import javax.persistence.*;

@Entity
@Table
public class StoryModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @JoinColumn(referencedColumnName = "id", name = "app_user_id")
    @ManyToOne
    private AppUser appUser;

    public StoryModel(String title, String content, AppUser appUser) {
        this.title = title;
        this.content = content;
        this.appUser = appUser;
    }

    public StoryModel() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public AppUser getAppUser() {
        return appUser;
    }
}
