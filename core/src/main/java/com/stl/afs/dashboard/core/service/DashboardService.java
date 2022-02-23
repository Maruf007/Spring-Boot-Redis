package com.stl.afs.dashboard.service;

import com.stl.afs.dashboard.entity.ActiveBorrower;
import com.stl.afs.dashboard.entity.CustomerInfo;
import com.stl.afs.dashboard.repository.ActiveBorrowerRepository;
import com.stl.afs.dashboard.repository.CustomerInfoRepository;
import com.stl.afs.dashboard.helper.Chart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.stl.afs.dashboard.helper.DashboardUtils;

@Slf4j
@Service
public class DashboardService implements IDashboardService{

    @Autowired
    private ActiveBorrowerRepository activeBorrowerRepository;

    @Autowired
    private RedisTemplate<String, ActiveBorrower> redisTemplateActiveBorrower;

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Autowired
    private RedisTemplate<String, CustomerInfo> redisTemplateCustomerInfo;

    @Override
    public List<ActiveBorrower> getActiveBorrowerList(String branchCodes, Date processDate) {
        return Arrays.stream(branchCodes.split(",")).collect(Collectors.toList())
                .stream().map(obj->getActiveBorrower(obj, processDate)).filter(obj-> obj != null).collect(Collectors.toList());
    }

    private ActiveBorrower getActiveBorrower(String branchCode, Date processDate) {
        final String key = DashboardUtils.getKey(Chart.ACTIVE_USER.getId(), branchCode, processDate);
        final ValueOperations<String, ActiveBorrower> operations = redisTemplateActiveBorrower.opsForValue();
        final boolean hasKey = redisTemplateActiveBorrower.hasKey(key);

        if (hasKey) {
            ActiveBorrower activeBorrower = operations.get(key);
            log.info("cache activeBorrower Get >> " + activeBorrower.toString());
            return activeBorrower;
        }
        final Optional<ActiveBorrower> activeBorrower = activeBorrowerRepository.findByBranchCodeAndProcessDate(branchCode, processDate);
        if(activeBorrower.isPresent()) {
            operations.set(key, activeBorrower.get(), 12, TimeUnit.HOURS);
            log.info("cache activeBorrower Insert >> " + activeBorrower.get().toString());
            return activeBorrower.get();
        }

        return null;
    }

    @Override
    public List<CustomerInfo> getCustomerInfoList(String branchCodes, Date processDate) {
        return Arrays.stream(branchCodes.split(",")).collect(Collectors.toList())
                .stream().map(obj->getCustomerInfo(obj, processDate)).filter(obj-> obj != null).collect(Collectors.toList());
    }

    private CustomerInfo getCustomerInfo(String branchCode, Date processDate) {
        final String key = DashboardUtils.getKey(Chart.CUSTOMER_INFO.getId(), branchCode, processDate);
        final ValueOperations<String, CustomerInfo> operations = redisTemplateCustomerInfo.opsForValue();
        final boolean hasKey = redisTemplateCustomerInfo.hasKey(key);

        if (hasKey) {
            CustomerInfo customerInfo = operations.get(key);
            log.info("cache CustomerInfo Get >> " + customerInfo.toString());
            return customerInfo;
        }
        final Optional<CustomerInfo> customerInfo = customerInfoRepository.findByBranchCodeAndProcessDate(branchCode, processDate);
        if(customerInfo.isPresent()) {
            operations.set(key, customerInfo.get(), 12, TimeUnit.HOURS);
            log.info("cache CustomerInfo Insert >> " + customerInfo.get().toString());
            return customerInfo.get();
        }

        return null;
    }

}
