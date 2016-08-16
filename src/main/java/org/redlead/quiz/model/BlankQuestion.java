package org.redlead.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlankQuestion {

    @Id
    @GeneratedValue
    private Long id;
    private Long num;
    private String text;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlankAnswer> answers;

}
