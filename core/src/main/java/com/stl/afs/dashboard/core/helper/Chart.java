package com.stl.afs.dashboard.helper;

public enum Chart {
    ACTIVE_USER(1),
    CUSTOMER_INFO(2);
    private final int id;
    private Chart(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
