package com.example.poppop.domain.review.dto.request;

import java.util.List;

public record ReviewCreateRequest(
        Long memberId,
        String content,
        List<String> imageUrls
) {}
