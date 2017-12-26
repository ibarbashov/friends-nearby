package io.dudes.friendsnearby.repository;

import io.dudes.friendsnearby.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {}
