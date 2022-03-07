package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.Entities.Person;
import Pracownia.Projekt.Spring.Entities.User;
import Pracownia.Projekt.Spring.Repositories.PersonRepository;
import Pracownia.Projekt.Spring.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
