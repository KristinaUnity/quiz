package org.redlead.quiz.service;

import org.redlead.quiz.exception.NotFoundException;
import org.redlead.quiz.model.User;
import org.redlead.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOneById(Long id) throws NotFoundException {

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new NotFoundException("User not found");
        }

        return user;
    }

    @Override
    @Transactional
    public User create(User user) {
        user.setId(null);
        user = userRepository.save(user);

        return user;
    }

    @Override
    @Transactional
    public User update(Long id, User user) throws NotFoundException {

        if (userRepository.findOne(id) == null) {
            throw new NotFoundException("user not found");
        }

        user.setId(id);
        user = userRepository.save(user);

        return user;
    }
}
