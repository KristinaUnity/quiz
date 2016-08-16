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
public class BlankForm {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlankQuestion> questions;

}
