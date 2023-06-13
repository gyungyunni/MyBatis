package com.example.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
// 모든 필드에 대한 Getters와 Setters 메서드가 자동으로 생성.
// @Data를 사용하면 클래스의 toString() 메서드가 자동으로 생성됩니다.
// 이 메서드를 호출하면 객체의 필드 값을 문자열로 반환.
// 필드를 기반으로 equals()와 hashCode() 메서드가 자동으로 생성.
// 이를 통해 객체 간의 동등성 비교와 해시 코드 생성이 간편해짐.
// 필드를 가진 생성자를 자동으로 생성.
// 매개변수 없는 기본 생성자도 자동으로 생성.
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
}
