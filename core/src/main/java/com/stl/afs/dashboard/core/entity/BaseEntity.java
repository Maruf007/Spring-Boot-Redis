package com.stl.afs.dashboard.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "BRANCHCODE")
    private String branchCode;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "PROCESSDATE")
    private Date processDate;
}
