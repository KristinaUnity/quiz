package org.redlead.quiz.service;

import org.redlead.quiz.exception.NotFoundException;
import org.redlead.quiz.model.BlankForm;
import org.redlead.quiz.repository.BlankFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlankFormServiceImpl implements IBlankFormService {

    private @Autowired BlankFormRepository blankFormRepository;

    @Override
    public BlankForm findOneById(Long id) throws NotFoundException {

        BlankForm blankForm = blankFormRepository.findOne(id);
        if (blankForm == null) {
            throw new NotFoundException("blank form not found");
        }

        return blankForm;
    }

    @Override
    @Transactional
    public BlankForm create(BlankForm blankForm) {
        blankForm.setId(null);
        blankForm = blankFormRepository.save(blankForm);
        return blankForm;
    }

    @Override
    @Transactional
    public BlankForm update(Long id, BlankForm blankForm) throws NotFoundException {

        if (blankFormRepository.findOne(id) == null) {
            throw new NotFoundException("blank form not found");
        }

        blankForm.setId(id);
        blankForm = blankFormRepository.save(blankForm);

        return blankForm;
    }
}