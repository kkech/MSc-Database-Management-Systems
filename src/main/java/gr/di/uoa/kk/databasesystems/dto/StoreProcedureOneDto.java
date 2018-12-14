package gr.di.uoa.kk.databasesystems.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.SqlResultSetMapping;


public class StoreProcedureOneDto {
    private String type;
    private Long numberOfRequest;

    public StoreProcedureOneDto() {
    }

    public StoreProcedureOneDto(String type, Long numberOfRequest) {
        this.type = type;
        this.numberOfRequest = numberOfRequest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNumberOfRequest() {
        return numberOfRequest;
    }

    public void setNumberOfRequest(Long numberOfRequest) {
        this.numberOfRequest = numberOfRequest;
    }
}
