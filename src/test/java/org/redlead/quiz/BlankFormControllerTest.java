package org.redlead.quiz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redlead.quiz.model.BlankForm;
import org.redlead.quiz.testdata.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("build-tests")
public class BlankFormControllerTest {

    private MockMvc mockMvc;
    private @Autowired WebApplicationContext context;
    private @Autowired
    TestData testData;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void requestGetById() throws Exception{
        testData.clear();
        BlankForm blankForm = testData.saveBlankForm();

        mockMvc.perform(get("/api/blank-form/{id}", blankForm.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void requestGetByIdNotFound() throws Exception{
        testData.clear();

        mockMvc.perform(get("/api/blank-form/{id}", 0L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void requestCreate() throws Exception {
        testData.clear();
        String blankFormJson = testData.getBlankFormJson();

        mockMvc.perform(post("/api/blank-form")
                .contentType(APPLICATION_JSON_UTF8)
                .content(blankFormJson))
                .andExpect(status().isOk());
    }

    @Test
    public void requestUpdate() throws Exception {
        testData.clear();
        BlankForm blankForm = testData.saveBlankForm();
        String blankFormJson = testData.getBlankFormJson();

        mockMvc.perform(put("/api/blank-form/{id}", blankForm.getId())
                .contentType(APPLICATION_JSON_UTF8)
                .content(blankFormJson))
                .andExpect(status().isOk());
    }

    @Test
    public void requestUpdateNotFound() throws Exception {
        testData.clear();
        String blankFormJson = testData.getBlankFormJson();

        mockMvc.perform(put("/api/blank-form/{id}", 0L)
                .contentType(APPLICATION_JSON_UTF8)
                .content(blankFormJson))
                .andExpect(status().isNotFound());
    }

}