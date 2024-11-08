package com.example.studyspringjpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqNo;

    @NotNull(message = "내용은 필수입니다.")
    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userSeqNo")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "BoardSeqNo")
    private Board board;
}
