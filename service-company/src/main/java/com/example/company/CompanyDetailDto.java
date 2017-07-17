package com.example.company;

/**
 * Created by Administrator on 2017/7/17.
 */
public class CompanyDetailDto {
    private long companyId;
    private String companyName;
    private boolean enableFeedback;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isEnableFeedback() {
        return enableFeedback;
    }

    public void setEnableFeedback(boolean enableFeedback) {
        this.enableFeedback = enableFeedback;
    }
}
