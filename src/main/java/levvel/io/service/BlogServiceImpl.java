package levvel.io.service;

import java.util.List;

import org.springframework.stereotype.Service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public void addBlog ( Blog blog ) {
        blogRepository.save( blog );
    }

    @Override
    public Blog getBlog ( String id ) {
        return blogRepository.findById( id ).orElseGet( null );
    }

    @Override
    public void addComment ( Comment comment, String id ) {
        Blog b = blogRepository.findById( id ).orElseGet( null );
        if ( b != null ) {
            b.getComments().add( comment );
            blogRepository.save( b );
        }
    }

    @Override
    public List<Comment> allComments ( String id ) {
        Blog b = blogRepository.findById( id ).orElseGet( null );
        if ( b != null ) {
            return b.getComments();
        }
        return null;
    }
}
