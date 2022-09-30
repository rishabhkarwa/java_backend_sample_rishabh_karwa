package levvel.io.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping ( "/blog" )
public class BlogController {

    private BlogService blogService;

    @PostMapping ( "/post" )
    public ResponseEntity<Blog> addBlog ( @RequestBody Blog blog ) {
        blogService.addBlog( blog );
        return ResponseEntity.ok().body( blog );
    }

    @GetMapping ( "/post/{id}" )
    public ResponseEntity<Blog> getBlog ( @PathVariable String id ) {
        Blog blog = blogService.getBlog( id );
        return ResponseEntity.ok().body( blog );
    }

    @PostMapping ( "blog/post/{id}/comment" )
    public ResponseEntity<Comment> addCommentById ( @RequestBody Comment comment, @PathVariable String id ) {
        blogService.addComment( comment, id );
        return ResponseEntity.ok().body( comment );
    }

    @GetMapping ( "/blog/post/{id}/comment" )
    public ResponseEntity<List<Comment>> getCommentById ( @PathVariable String id ) {
        List<Comment> comments = blogService.allComments( id );
        return ResponseEntity.ok().body( comments );
    }
}
