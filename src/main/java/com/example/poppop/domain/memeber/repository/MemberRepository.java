package com.example.poppop.domain.memeber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface MemberRepository extends JpaRepository<OAuth2User, Long> {
}
