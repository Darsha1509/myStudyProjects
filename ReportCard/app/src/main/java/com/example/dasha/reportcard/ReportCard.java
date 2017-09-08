package com.example.dasha.reportcard;

/**
 * Created by Dasha on 26.08.2017.
 */

public class ReportCard {
    private String category;
    private String value;

    public ReportCard(String category, String value) {
        this.category = category;
        this.value = value;
    }

    @Override
    public String toString(){
        return category + "\n" + value;
    }
}
