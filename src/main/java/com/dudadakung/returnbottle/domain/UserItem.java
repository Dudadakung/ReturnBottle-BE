package com.dudadakung.returnbottle.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "user_item")
public class UserItem extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "is_valid")
    @ColumnDefault("true")
    private boolean isValid;

    @Column(name = "d_day", nullable = false)
    private int dDay;

    public static UserItem createUserItem(User user, Item item, int dDay) {
        return UserItem.builder()
                .user(user)
                .item(item)
                .dDay(dDay)
                .build();
    }
}
