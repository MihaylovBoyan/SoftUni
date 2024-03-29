package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
