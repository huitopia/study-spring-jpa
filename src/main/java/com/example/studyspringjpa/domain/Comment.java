package com.example.studyspringjpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Integer commentSeqNo;

    @NotNull(message = "내용은 필수입니다.")
    private String content;

    @ManyToOne
    @JoinColumn(name = "userSeqNo")
    @JsonProperty("userSeqNo")
    private User user;

    @ManyToOne
    @JoinColumn(name = "BoardSeqNo")
    @JsonProperty("BoardSeqNo")
    private Board board;
}
