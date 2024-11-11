package com.example.studyspringjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSeqNo;

    @NotNull(message = "ID는 필수입니다.")
    @Size(min = 4, max = 8, message = "ID는 4자 이상 8자 이하이어야 합니다.")
    private String id;

    @NotNull(message = "이름은 필수입니다.")
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Board> boards;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> comments;
}
