package com.stl.afs.dashboard.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "BI_ACTIVEBORROWER")
public class ActiveBorrower extends BaseEntity{
    @Id
    @Column(name = "ATBID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ATBCURRENT")
    private Integer current;

    @Column(name = "ATBREGULAR")
    private Integer regular;

    @Column(name = "ATBOVERDUE")
    private Integer overdue;

    @Column(name = "ATBEXPIRE")
    private Integer expire;
}
