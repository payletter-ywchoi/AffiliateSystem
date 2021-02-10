package com.afiliate.ywchoi.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 추가
@Entity //JPA용 anootation. 테이블과 링크될 클래스. 카멜케이스 클래스명을 언더스코어 케이스 테이블명에 매칭
public class Posts {

    @Id //PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙. 자동증가 값
    private Long id;

    @Column(length = 500, nullable = false) //컬럼으로 명시. 선언하지 않아도 되나, 옵션값 설정이 필요할 경우에 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//빌드 클래스 생성
    public Posts(String title, String content, String author) {
        this.title   = title;
        this.content = content;
        this.author  = author;
    }
}
