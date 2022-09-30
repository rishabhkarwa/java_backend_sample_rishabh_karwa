package levvel.io.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class Blog {

    @Id
    String                id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    String                author;
    String                title;
    String                text;

    /**
     * @return the comments
     */
    public List<Comment> getComments () {
        return comments;
    }

    private List<Comment> comments;

    /**
     * @param id
     * @param createdDate
     * @param lastModifiedDate
     * @param author
     * @param title
     * @param text
     */
    public Blog ( String author, String title, String text ) {
        this.author = author;
        this.title = title;
        this.text = text;
        comments = new ArrayList<Comment>();
    }

    /**
     * @return the id
     */
    public String getId () {
        return id;
    }

    /**
     * @return the createdDate
     */
    public LocalDateTime getCreatedDate () {
        return createdDate;
    }

    /**
     * @return the lastModifiedDate
     */
    public LocalDateTime getLastModifiedDate () {
        return lastModifiedDate;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId ( String id ) {
        this.id = id;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate ( LocalDateTime createdDate ) {
        this.createdDate = createdDate;
    }

    /**
     * @param lastModifiedDate
     *            the lastModifiedDate to set
     */
    public void setLastModifiedDate ( LocalDateTime lastModifiedDate ) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
