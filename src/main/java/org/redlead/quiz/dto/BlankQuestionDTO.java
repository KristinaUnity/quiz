package org.redlead.quiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BlankQuestionDTO {

    private Long num;
    private String text;
    private List<BlankAnswerDTO> answers;

}
