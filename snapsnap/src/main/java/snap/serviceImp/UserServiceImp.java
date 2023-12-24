package snap.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snap.entities.User;
import snap.repositories.UserRepository;
import snap.service.IUserService;

@Service
public class UserServiceImp implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(String userId) {
		return userRepository.findById(userId);
	}

	@Override
	public User addUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void updateUser(String userId, User updatedUser) {
		if (userRepository.existsById(userId)) {
			updatedUser.setId(userId);
			userRepository.save(updatedUser);
		}
		// Handle the case where the user with the given ID doesn't exist.
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}
}
