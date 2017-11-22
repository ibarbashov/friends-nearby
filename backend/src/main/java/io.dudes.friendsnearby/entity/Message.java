package io.dudes.friendsnearby.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;
    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @Column
    private String payload;
}
