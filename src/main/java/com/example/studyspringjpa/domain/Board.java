package com.example.studyspringjpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqNo;

    @NotNull(message = "제목은 필수입니다.")
    @Size(min = 2, max = 20, message = "제목은 2자 이상 20자 이하이어야 합니다.")
    private String title;

    @NotNull(message = "내용은 필수입니다.")
    private String content;

    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonBackReference  // 순환 참조 방지
    @ManyToOne
    @JoinColumn(name = "userSeqNo")
    private User user;

    /*
     * 영속성 전이(Cascade)
     *   ALL : 모든 Cascade 적용
     *   PERSIST : 상위 엔티티를 저장할 때 하위 엔티티도 함께 저장
     *   MERGE : 상위 엔티티를 병합할 때 하위 엔티티도 함께 병합
     *   REMOVE : 상위 엔티티를 삭제할 때 하위 엔티티도 함께 삭제
     *   DEATH : 상위 엔티티를 분리할 때 하위 엔티티도 함께 분리
     *   REFRESH : 상위 엔티티를 새로고침할 때 하위 엔티티도 함께 새로고침
     *
     *   연관된 엔티티를 어떻게 처리할지에 대한 규칙 정의하는 것으로 선택적 옵션임
     *   상위와 하위의 생명주기가 완전히 함께하는 경우 유용
     */
    @JsonIgnoreProperties("board")
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true) // Board 삭제 시 Comment 함께 삭제됨
    private List<Comment> comments;
}
