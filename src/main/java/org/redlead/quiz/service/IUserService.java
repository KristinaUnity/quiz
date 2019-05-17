package org.redlead.quiz.service;

import org.redlead.quiz.exception.NotFoundException;
import org.redlead.quiz.model.User;

public interface IUserService {
    User findOneById(Long id) throws NotFoundException;
    User create(User user);
    User update(Long id, User user) throws NotFoundException;
}
