package com.stl.afs.dashboard.app.controller;

import com.stl.afs.dashboard.entity.ActiveBorrower;
import com.stl.afs.dashboard.entity.CustomerInfo;
import com.stl.afs.dashboard.service.IDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api-1.0.0/dashboard")
public class DashboardController {

    @Autowired
    private IDashboardService dashboardService;

    @GetMapping("/active-borrower/{branchCodes}/{processDate}")
    public ResponseEntity<?> getActiveBorrowerList(
            @PathVariable(value = "branchCodes") String branchCodes,
            @PathVariable(value = "processDate") Date processDate){
        List<ActiveBorrower> activeBorrowerList = dashboardService.getActiveBorrowerList(branchCodes, processDate);
        return new ResponseEntity<>( activeBorrowerList, HttpStatus.MULTI_STATUS.OK);
    }

    @GetMapping("/customer-info/{branchCodes}/{processDate}")
    public ResponseEntity<?> getCustomerList(
            @PathVariable(value = "branchCodes") String branchCodes,
            @PathVariable(value = "processDate") Date processDate){
        List<CustomerInfo> customerInfoList = dashboardService.getCustomerInfoList(branchCodes, processDate);
        return new ResponseEntity<>( customerInfoList, HttpStatus.MULTI_STATUS.OK);
    }
}
