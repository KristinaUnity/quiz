package org.redlead.quiz.testdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.redlead.quiz.model.BlankForm;
import org.redlead.quiz.repository.BlankFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class TestData {

    @Autowired
    private BlankFormRepository blankFormRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${quiz.testdata.enable:false}")
    private Boolean testDataEnable;

    private String blankFormJson;

    @PostConstruct
    public void init() throws IOException {

        Resource resource = new ClassPathResource("testdata/blank-form.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        this.blankFormJson = reader.lines().collect(Collectors.joining("\n"));

        if (testDataEnable) {
            this.saveBlankForm();
        }
    }

    public void clear() {
        blankFormRepository.deleteAll();
    }

    public String getBlankFormJson() {
        return blankFormJson;
    }

    public BlankForm getBlankForm() throws IOException {
        return objectMapper.readValue(blankFormJson, BlankForm.class);
    }

    public BlankForm saveBlankForm() throws IOException {
        return blankFormRepository.save(getBlankForm());
    }

}