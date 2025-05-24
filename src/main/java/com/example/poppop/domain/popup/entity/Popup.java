package com.example.poppop.domain.popup.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Popup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String startDate;
    private String endDate;
    private String comment;
    @Column(columnDefinition = "TEXT")
    private String detail;
    @Column(columnDefinition = "TEXT")
    private String image;
    private String location;
    @Column(nullable = true)
    private Integer viewCount;

    @Builder
    public Popup(String title, String startDate, String endDate, String comment, String detail, String image, String location, int viewCount) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.detail = detail;
        this.image = image;
        this.location = location;
        this.viewCount = viewCount;
    }

    public void increaseViewCount(int count) {
        this.viewCount += count;
    }
}
