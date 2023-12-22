package snap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import snap.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
