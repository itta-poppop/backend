package com.example.poppop.domain.review.repository;

import com.example.poppop.domain.popup.entity.PopUp;
import com.example.poppop.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByPopUpAndIsDeletedFalseOrderByCreatedAtDesc(PopUp popUp);
}
