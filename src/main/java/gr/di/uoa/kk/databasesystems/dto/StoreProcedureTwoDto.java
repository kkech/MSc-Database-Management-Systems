package gr.di.uoa.kk.databasesystems.dto;

import javax.persistence.Transient;
import java.util.Date;

public class StoreProcedureTwoDto {
    private Date day;
    private Long numberOfRequest;
//    @Transient
//    private String dateString;

    public StoreProcedureTwoDto() {
    }

    public StoreProcedureTwoDto(Date day, Long numberOfRequest) {
        this.day = day;
        this.numberOfRequest = numberOfRequest;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Long getNumberOfRequest() {
        return numberOfRequest;
    }

    public void setNumberOfRequest(Long numberOfRequest) {
        this.numberOfRequest = numberOfRequest;
    }

//    public String getDateString() {
//        return dateString;
//    }
//
//    public void setDateString(String dateString) {
//        this.dateString = dateString;
//    }
}
