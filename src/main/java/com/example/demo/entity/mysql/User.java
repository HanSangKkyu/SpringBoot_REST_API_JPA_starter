package com.example.demo.entity.mysql;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment를 적용
    Long id;

    @Column(name = "name") // 테이블의 column명 그대로 써주기
    String name;

}
