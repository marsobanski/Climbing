package pl.coderslab.comment;

import org.springframework.stereotype.Service;
import pl.coderslab.user_route.UserRoute;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> findAllByUserRouteId(Long id) {
        return commentRepository.findAllByUserRouteId(id);
    }

    public List<Comment> findAllByUserRouteIdOrderByCreationDateAsc(Long id) {
        return commentRepository.findAllByUserRouteIdOrderByCreationDateAsc(id);
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    public void deleteUserRouteConnection(Long id) {
        commentRepository.deleteUserRouteConnection(id);
    }
}
