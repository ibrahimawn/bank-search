package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankDetails {

    @JsonProperty("ifsc")
    private String ifsc;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("state")
    private String state;

    @JsonProperty("city")
    private String city;

    @JsonProperty("district")
    private String district;

    @JsonProperty("address")
    private String address;

    public BankDetails(String ifsc, String bankName, String branch,
                       String state, String city, String district, String address) {
        this.ifsc = ifsc;
        this.bankName = bankName;
        this.branch = branch;
        this.state = state;
        this.city = city;
        this.district = district;
        this.address = address;
    }

    public String getIfsc() {
        return ifsc;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranch() {
        return branch;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }
}
