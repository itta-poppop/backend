package com.example.poppop.domain.popup.repository;

import com.example.poppop.domain.popup.entity.PopUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopUpRepository extends JpaRepository<PopUp, Long> {
}
