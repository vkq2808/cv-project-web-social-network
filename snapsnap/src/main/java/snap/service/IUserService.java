package snap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import snap.entities.User;

@Service
public interface IUserService {
	List<User> getAllUsers();

	Optional<User> getUserById(String userId);

	User addUser(User user);

	void updateUser(String userId, User updatedUser);

	void deleteUser(String userId);
}
