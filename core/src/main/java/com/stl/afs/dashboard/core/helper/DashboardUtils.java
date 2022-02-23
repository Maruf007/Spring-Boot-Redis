package com.stl.afs.dashboard.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DashboardUtils {
    public static String getKey(int chart, String branchCode, Date date) {
        DateFormat dateFormat = new SimpleDateFormat("ddMM");
        String strDate = dateFormat.format(date);
        return chart + branchCode + strDate;
    }
}
