package io.dudes.friendsnearby.repository;

import io.dudes.friendsnearby.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChatId(Long chatId);
}
