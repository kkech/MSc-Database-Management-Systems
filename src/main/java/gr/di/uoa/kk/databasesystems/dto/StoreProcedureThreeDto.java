package gr.di.uoa.kk.databasesystems.dto;

public class StoreProcedureThreeDto {
    private String zipCode;
    private String requestName;

    public StoreProcedureThreeDto() {
    }

    public StoreProcedureThreeDto(String zipCode, String requestName) {
        this.zipCode = zipCode;
        this.requestName = requestName;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
