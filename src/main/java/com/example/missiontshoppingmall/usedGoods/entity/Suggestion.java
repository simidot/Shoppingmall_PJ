package com.example.missiontshoppingmall.usedGoods.entity;

import com.example.missiontshoppingmall.utils.BaseEntity;
import com.example.missiontshoppingmall.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Suggestion extends BaseEntity {
    @Column(nullable = false)
    private String suggestionMessage;

    @Enumerated(EnumType.STRING)
    @Setter
    private SuggestionStatus suggestionStatus;

    @Enumerated(EnumType.STRING)
    @Setter
    private PurchaseStatus purchaseStatus;

    @ManyToOne
    @Setter
    private UsedGoods usedGoods;

    @ManyToOne
    private UserEntity buyer; //buyer

    // 연관관계 편의 메서드
    public void addUsedGoods(UsedGoods ug) {
        this.setUsedGoods(ug);
        ug.getSuggestionList().add(this);
    }
}
