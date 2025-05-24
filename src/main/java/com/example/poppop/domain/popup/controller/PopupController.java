package com.example.poppop.domain.popup.controller;

import com.example.poppop.domain.memeber.entity.CustomOAuth2User;
import com.example.poppop.domain.popup.dto.PopupDetailDto;
import com.example.poppop.domain.popup.dto.PopupPlannedDto;
import com.example.poppop.domain.popup.service.PopupService;
import com.example.poppop.global.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/popups")
public class PopupController {
    private final PopupService popupService;

    // 팝업 상세 조회 api
    @GetMapping("/{popupId}")
    public ApiResponse<PopupDetailDto> getDetailPopup (
            @PathVariable Long popupId,
            @AuthenticationPrincipal CustomOAuth2User oauth2User
    ) {
        PopupDetailDto detailPopup = popupService.getDetailPopup(popupId);
        popupService.incrementViewCount(popupId,oauth2User);
        return ApiResponse.success(detailPopup);
    }

    // 오픈 예정 팝업
    @GetMapping("/planned")
    public ApiResponse<List<PopupPlannedDto>> getPlannedPopups (
            @RequestParam @Valid Integer page,
            @RequestParam @Valid Integer size) {
        List<PopupPlannedDto> plannedPopups = popupService.getPlannedPopup(page, size);
        return ApiResponse.success(plannedPopups);
    }

/*    // 트랜드 팝업 목록 조회
    @GetMapping("/trend")
    public ApiResponse<List<TrendPopupDto>> getTrendPopups (
        @RequestParam @Valid Integer page,
        @RequestParam @Valid Integer size
    ) {
        popupService.getTrendPopups(page,size)
    }*/

    // 팝업 검색

    // 위치 기반 팝업 검색
}
