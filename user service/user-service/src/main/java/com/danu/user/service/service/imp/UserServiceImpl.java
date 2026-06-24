package com.danu.user.service.service.imp;

import com.danu.user.service.exception.UserException;
import com.danu.user.service.model.User;
import com.danu.user.service.repository.UserRepository;
import com.danu.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new UserException("user not found");
}

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("user not exist with id"+id);
        }
        userRepository.deleteById(otp.get().getId());
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("user not found with id"+id);
        }
        User existingUser=otp.get();
        if(user.getFullName() != null) {
            existingUser.setFullName(user.getFullName());
        }
        if(user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if(user.getRole() != null) {
            existingUser.setRole(user.getRole());
        }
        if(user.getPhone() != null) {
            existingUser.setPhone(user.getPhone());
        }
        if(user.getPhone() != null) {
            existingUser.setUserName(user.getUserName());
        }

        return userRepository.save(existingUser);
    }
}
