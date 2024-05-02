package com.fastcampus.loan.domain;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert // insert 시 null인 필드 제외
@DynamicUpdate // update 시 변경된 필드만 대응
// @DynamicInsert와 @DynamicUpdate 어노테이션은 Hibernate에서 제공하는 어노테이션으로, insert와 update 시에 변경된 필드만 대응하도록 하는 기능을 제공합니다.
@Where(clause = "is_deleted = false") /// is_deleted가 false인 데이터만 조회
//@Where 어노테이션은 Hibernate에서 제공하는 어노테이션으로, 특정 조건을 만족하는 데이터만 조회할 수 있도록 하는 기능을 제공합니다.
public class Counsel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long counselId;

    @Column(nullable = false,columnDefinition = "datetime Comment '신청일자'")
    private LocalDateTime appliedAt;//상담신청일


    @Column(nullable = false,columnDefinition = "varchar(12) Comment '상담요청자'")
    private String name; //이름

    @Column(nullable = false,columnDefinition = "varchar(20) Comment '전화번호'")
    private String cellPhone; //전화번호

    @Column(columnDefinition = "varchar(50) DEFAULT NULL Comment '이메일'")
    private String email; //이메일

    @Column(columnDefinition = "text DEFAULT NULL Comment '상담메모'")
    private String memo; //상담내용

    @Column(columnDefinition = "varchar(100) DEFAULT NULL Comment '주소'")
    private String address; //주소

    @Column(columnDefinition = "varchar(100) DEFAULT NULL Comment '상세주소'")
    private String addressDetail; // 상세주소

    @Column(columnDefinition = "varchar(5) DEFAULT NULL Comment '우편번호'")
    private String zipCode; //우편번호
}
