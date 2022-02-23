package com.stl.afs.dashboard.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "BI_CUSTOMERINFO")
public class CustomerInfo extends BaseEntity{
    @Id
    @Column(name = "CIFID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CIFMALEADMISSION")
    private Integer maleAdmission;

    @Column(name = "CIFFEMALEADMISSION")
    private Integer femaleAdmission;

    @Column(name = "CIFOTHERADMISSION")
    private Integer otherAdmission;

    @Column(name = "CIFMALEDROPOUT")
    private Integer maleDropout;

    @Column(name = "CIFFEMALEDROPOUT")
    private Integer femaleDropout;

    @Column(name = "CIFOTHERDROPOUT")
    private Integer otherDropout;

}
