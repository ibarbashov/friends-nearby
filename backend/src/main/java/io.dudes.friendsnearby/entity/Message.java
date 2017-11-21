package io.dudes.friendsnearby.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity {
    @JoinColumn(name = "user_id")
    private User author;
    @JoinColumn(name = "chat_id")
    private Chat chat;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @Column
    private String payload;
}
