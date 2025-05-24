package com.example.poppop.domain.review.service;

import com.example.poppop.domain.review.dto.request.ReviewCreateRequest;
import com.example.poppop.domain.review.dto.request.ReviewUpdateRequest;
import com.example.poppop.domain.review.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {

    ReviewResponse create(Long popupId, ReviewCreateRequest dto);
    List<ReviewResponse> findAllByPopup(Long popupId);
    ReviewResponse update(Long reviewId, ReviewUpdateRequest dto);
    void delete(Long reviewId);
}

