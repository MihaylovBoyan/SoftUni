package softuni.exam.instagraphlite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    private String caption;
    private User user;
    private Picture picture;

    @Column(nullable = false)
    public String getCaption() {
        return caption;
    }

    public Post setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    @ManyToOne(optional = false)
   // @Column(nullable = false)
    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne(optional = false)
   // @Column(nullable = false)
    public Picture getPicture() {
        return picture;
    }

    public Post setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
