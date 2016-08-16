package org.redlead.quiz.controller;

import ma.glasnost.orika.MapperFacade;
import org.redlead.quiz.dto.BlankFormDTO;
import org.redlead.quiz.exception.NotFoundException;
import org.redlead.quiz.model.BlankForm;
import org.redlead.quiz.service.IBlankFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/api/blank-form")
public class BlankFormController {

    private @Autowired
    IBlankFormService blankFormService;
    private @Autowired MapperFacade mapper;

    @RequestMapping(path = "/{id}", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public BlankFormDTO getOneById(@PathVariable Long id) throws NotFoundException {
        BlankForm blankForm = blankFormService.findOneById(id);
        return mapper.map(blankForm, BlankFormDTO.class);
    }

    @RequestMapping(path = "", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public BlankFormDTO create(@RequestBody BlankFormDTO blankFormDTO) {
        BlankForm blankForm = blankFormService.create(mapper.map(blankFormDTO, BlankForm.class));
        return mapper.map(blankForm, BlankFormDTO.class);
    }

    @RequestMapping(path = "/{id}", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public BlankFormDTO update(@PathVariable Long id, @RequestBody BlankFormDTO blankFormDTO) throws NotFoundException {
        BlankForm blankForm = blankFormService.update(id, mapper.map(blankFormDTO, BlankForm.class));
        return mapper.map(blankForm, BlankFormDTO.class);
    }


}
