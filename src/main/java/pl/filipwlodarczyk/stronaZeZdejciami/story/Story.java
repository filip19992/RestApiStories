package pl.filipwlodarczyk.stronaZeZdejciami.story;

import pl.filipwlodarczyk.stronaZeZdejciami.user.AppUser;

import javax.persistence.*;

@Entity
@Table
public class Story {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition="TEXT")
    private String content;

    @JoinColumn(referencedColumnName = "id", name = "app_user_id")
    @ManyToOne
    private AppUser appUser;

    public Story(String title, String content, AppUser appUser) {
        this.title = title;
        this.content = content;
        this.appUser = appUser;
    }

    public Story() {
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

    @Override
    public String toString() {
        return "Story{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
