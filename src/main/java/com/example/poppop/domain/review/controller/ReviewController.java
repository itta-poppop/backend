package com.example.poppop.domain.review.controller;

import com.example.poppop.domain.review.dto.request.ReviewCreateRequest;
import com.example.poppop.domain.review.dto.request.ReviewUpdateRequest;
import com.example.poppop.domain.review.dto.response.ReviewResponse;
import com.example.poppop.domain.review.service.ReviewService;
import com.example.poppop.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/popups/{popupId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponse> createReview(
            @PathVariable Long popupId,
            @RequestBody @Valid ReviewCreateRequest request) {

        return ApiResponse.success(reviewService.create(popupId, request),
                "리뷰가 등록되었습니다.");
    }

    @GetMapping
    public ApiResponse<List<ReviewResponse>> getReviews(@PathVariable Long popupId) {

        return ApiResponse.success(reviewService.findAllByPopup(popupId));
    }

    @PostMapping("/{reviewId}/patch")
    public ApiResponse<ReviewResponse> updateReview(
            @PathVariable Long reviewId,
            @RequestBody @Valid ReviewUpdateRequest request) {

        return ApiResponse.success(reviewService.update(reviewId, request),
                "리뷰가 수정되었습니다.");
    }

    @PostMapping("/{reviewId}/delete")
    public ApiResponse<Object> deleteReview(@PathVariable Long reviewId) {

        reviewService.delete(reviewId);
        return ApiResponse.success("리뷰가 삭제되었습니다.");
    }
}

