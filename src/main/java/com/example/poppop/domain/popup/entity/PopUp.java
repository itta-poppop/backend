package com.example.poppop.domain.popup.entity;


import com.example.poppop.domain.review.entity.Review;
import com.example.poppop.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 임시 PopUp 엔티티
 *  - 실제 프로덕션에서는 날짜(기간), 주소, 태그 등 추가 필드가 더 붙을 수 있습니다.
 *  - Review ↔ PopUp 다대일 연관관계를 위해 reviews 컬렉션을 미리 열어둔 상태입니다.
 */
@Entity
@Table(name = "popup")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "reviews")
public class PopUp extends BaseEntity {

    /* PK */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* 팝업 이름 */
    @Column(nullable = false)
    private String title;

    /* 전시 기간·날짜
       - 디자인 시안에선 단순 문자열(“25.03.22 - 25.06.08”) 형태였으므로
         우선 String 으로 두되, 나중에 LocalDate / 기간 VO 로 교체해도 됨. */
    @Column(nullable = false)
    private String date;

    /* 대표 이미지 URL */
    @Column(length = 255)
    private String image;

    /* 한 줄 요약(카드에 노출) */
    private String comment;

    /* 상세 설명(소개 탭) */
    @Column(columnDefinition = "TEXT")
    private String detail;

    /* ----------------- 연관관계 ----------------- */
    @OneToMany(mappedBy = "popUp",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private final List<Review> reviews = new ArrayList<>();

    public void addReview(Review review) {
        reviews.add(review);
    }

    /* ----------------- 생성자 / 빌더 ----------------- */
    @Builder
    private PopUp(String title,
                  String date,
                  String image,
                  String comment,
                  String detail) {

        this.title   = title;
        this.date    = date;
        this.image   = image;
        this.comment = comment;
        this.detail  = detail;
    }

    /* ----------------- 도메인 메서드 ----------------- */
    public void updateInfo(String title,
                           String date,
                           String image,
                           String comment,
                           String detail) {

        this.title   = title;
        this.date    = date;
        this.image   = image;
        this.comment = comment;
        this.detail  = detail;
    }
}

