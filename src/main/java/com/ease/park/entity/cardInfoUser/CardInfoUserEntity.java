package com.ease.park.entity.cardInfoUser;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card_info_user")
public class CardInfoUserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_id", length = 50, unique = true)
    private String cardId;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "ph", length = 10)
    private String ph;
}
