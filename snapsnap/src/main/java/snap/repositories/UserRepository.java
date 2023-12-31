package snap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import snap.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
