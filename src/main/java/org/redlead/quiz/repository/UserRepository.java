package org.redlead.quiz.repository;

import org.redlead.quiz.model.User;
import org.springframework.data.repository.CrudRepository;

public interface  UserRepository extends CrudRepository<User, Long> {
}
