package com.ease.park.entity.bookingStatus;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "booking_status")
public class BookingEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "phone_number", length = 20)
    private String ph;
    @Column(name = "parking_space_id")
    private String parkingSpaceId;

    private Timestamp inTTime;
    private Timestamp outTTime;
    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status;

    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = true;
        }
    }
}
