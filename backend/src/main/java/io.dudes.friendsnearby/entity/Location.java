package io.dudes.friendsnearby.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseEntity {
    @Column(nullable = false)
    private Double longitude;
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Location(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = LocalDateTime.now();
    }
}
