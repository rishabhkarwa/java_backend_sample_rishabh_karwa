package levvel.io.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class Comment {
    @Id
    String                id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    String                comment;

    String                author;

    /**
     * @param comment
     */
    public Comment ( String author, String comment ) {
        this.author = author;
        this.comment = comment;
    }

}
