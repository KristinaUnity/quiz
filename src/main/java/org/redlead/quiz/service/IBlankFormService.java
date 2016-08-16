package org.redlead.quiz.service;

import org.redlead.quiz.exception.NotFoundException;
import org.redlead.quiz.model.BlankForm;

public interface IBlankFormService {

    BlankForm findOneById(Long id) throws NotFoundException;
    BlankForm create(BlankForm blankForm);
    BlankForm update(Long id, BlankForm blankForm) throws NotFoundException;

}
