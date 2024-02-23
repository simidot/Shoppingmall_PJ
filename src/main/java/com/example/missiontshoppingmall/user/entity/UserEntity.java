package com.example.missiontshoppingmall.user.entity;

import com.example.missiontshoppingmall.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
//todo: Setter를 써야할지말지 고민이 된다. > 일단 accountId는 변경이 불가하기 때문에 변경이 가능한 필드에만 Setter를 써주었다.
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String accountId;
    @Column(nullable = false)
    @Setter
    private String password;
    @Setter
    private String authority; //권한을 ,로 구분지어 String으로 저장.

    //추가 입력 정보
    @Setter
    private String username;
    @Setter
    private String nickname;
    @Setter
    private Integer age;
    @Setter
    private String email;
    @Setter
    private String phone;

    //선택 입력 사항
    @Setter
    private String profile; //이미지 저장 경로를 저장 (이미지 자체를 저장하지 않음)
    @Setter
    private String businessNumber; //사업자 번호
    @Setter
    private boolean businessIsAllowed; //사업자 허가 여부


}