package org.example.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;

import org.example.userservice.event.UserCreatedEvent;
import org.example.userservice.publisher.UserEventPublisher;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEventPublisher userEventPublisher;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User register(User user) {
        User savedUser = userRepository.save(user);

        UserCreatedEvent event = new UserCreatedEvent(
                savedUser.getId().toString(),
                savedUser.getFirstName(),
                savedUser.getEmail()
        );

        userEventPublisher.publishUserCreated(event);

        System.out.println("UserCreatedEvent published for user ID: " + savedUser.getId());

        return savedUser;
    }

}
