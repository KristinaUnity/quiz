package org.redlead.quiz;

import ma.glasnost.orika.MapperFacade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redlead.quiz.dto.BlankAnswerDTO;
import org.redlead.quiz.dto.BlankFormDTO;
import org.redlead.quiz.dto.BlankQuestionDTO;
import org.redlead.quiz.model.BlankAnswer;
import org.redlead.quiz.model.BlankForm;
import org.redlead.quiz.model.BlankQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("build-tests")
public class MapperTest {

    @Autowired
    private MapperFacade mapper;

    @Test
    public void BlankAnswerMapTest() {
        BlankAnswer blankAnswer = new BlankAnswer(0L, 0L, "test");
        BlankAnswerDTO blankAnswerDTO = mapper.map(blankAnswer, BlankAnswerDTO.class);
        Assert.assertEquals("blank answer num doesn't match", blankAnswerDTO.getNum(), blankAnswer.getNum());
    }

    @Test
    public void BlankQuestionMapTest() {
        BlankAnswer blankAnswer = new BlankAnswer(0L, 0L, "test");
        BlankQuestion blankQuestion = new BlankQuestion(0L, 0L, "test", Arrays.asList(blankAnswer));
        BlankQuestionDTO blankQuestionDTO = mapper.map(blankQuestion, BlankQuestionDTO.class);
        Assert.assertEquals("blank question num doesn't match", blankQuestionDTO.getNum(), blankQuestionDTO.getNum());
    }

    @Test
    public void BlankFormMapTest() {
        BlankAnswer blankAnswer = new BlankAnswer(0L, 0L, "test");
        BlankQuestion blankQuestion = new BlankQuestion(0L, 0L, "test", Arrays.asList(blankAnswer));
        BlankForm blankForm = new BlankForm(0L, "test", "test", Arrays.asList(blankQuestion));
        BlankFormDTO blankFormDTO = mapper.map(blankForm, BlankFormDTO.class);
        Assert.assertEquals("blank form id doesn't match", blankFormDTO.getId(), blankFormDTO.getId());
    }

}