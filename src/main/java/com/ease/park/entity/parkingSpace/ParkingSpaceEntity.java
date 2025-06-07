package com.ease.park.entity.parkingSpace;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "parking_space", indexes = {
        @Index(name = "idx_parking_space_id", columnList = "parking_space_id")
})
public class ParkingSpaceEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "parking_space_id", length = 50, unique = true)
    private String parkingSpaceId;
    @Column(name = "direction_to_reach", length = 300)
    private String directionToReach;
    @Column(name = "floor", length = 10)
    private String floor;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @PrePersist
    protected void onCreate() {
        if (isActive == null) {
            isActive = true;
        }
    }
}
