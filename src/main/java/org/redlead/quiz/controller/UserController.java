package org.redlead.quiz.controller;

import ma.glasnost.orika.MapperFacade;
import org.redlead.quiz.dto.UserDTO;
import org.redlead.quiz.exception.NotFoundException;
import org.redlead.quiz.model.User;
import org.redlead.quiz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    MapperFacade mapper;

    @RequestMapping(path = "/{id}", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDTO getOneById(@PathVariable Long id) throws NotFoundException {
        User user = userService.findOneById(id);
        return mapper.map(user, UserDTO.class);
    }

    @RequestMapping(path = "", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDTO create(@RequestBody UserDTO userDTO) {
        User user = userService.create(mapper.map(userDTO, User.class));
        return mapper.map(user, UserDTO.class);
    }

    @RequestMapping(path = "/{id}", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) throws NotFoundException {
        User user = userService.update(id, mapper.map(userDTO, User.class));
        return mapper.map(user, UserDTO.class);
    }
}
