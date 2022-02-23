package com.stl.afs.dashboard.service;

import com.stl.afs.dashboard.entity.ActiveBorrower;
import com.stl.afs.dashboard.entity.CustomerInfo;

import java.util.Date;
import java.util.List;

public interface IDashboardService {
    public List<ActiveBorrower> getActiveBorrowerList(String branchCodes, Date processDate);

    public List<CustomerInfo> getCustomerInfoList(String branchCodes, Date processDate);
}
