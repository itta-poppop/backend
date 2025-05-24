package com.example.poppop.domain.popup.dto;

import com.example.poppop.domain.popup.entity.Popup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrendPopupDto {
    private String title;
    private String imageUrl;
    private String location;

    @Builder
    public TrendPopupDto(String title, String imageUrl, String location) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    public static TrendPopupDto from(Popup popup) {
        return TrendPopupDto.builder()
                .title(popup.getTitle())
                .imageUrl(popup.getImage())
                .location(extractLocation(popup.getLocation()))
                .build();
    }

    private static String extractLocation(String location) {
        String[] strArray = location.split(" ");
        String first = strArray[0];
        String second = strArray[1];
        return first + " " + second;
    }
}
