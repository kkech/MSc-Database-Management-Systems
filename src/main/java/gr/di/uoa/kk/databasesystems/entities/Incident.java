package gr.di.uoa.kk.databasesystems.entities;

import gr.di.uoa.kk.databasesystems.dto.StoreProcedureOneDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@SqlResultSetMapping(name="StoreProcedureOneDto",
        classes={
                @ConstructorResult(targetClass= StoreProcedureOneDto.class,
                        columns={
                                @ColumnResult(name="reqtype", type=String.class),
                                @ColumnResult(name="reqnum", type=Long.class),
                        })
        }
)
@Entity
@Table(name="service_request", schema = "public")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQ_ID")
    private Long  reqId;

    @NotNull
    @Column(name = "SRV_REQ_NUM")
    private String serviceRequestNumber;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SRVT_ID")
    @NotNull
    private IncidentType  incidentType;

    @Column(name = "SSA")
    private Long ssa;

    @Column(name = "COMMUNITY_AREA")
    private Long comunityArea;

    @Column(name = "POLICE_DISTRICT")
    private Long policeDistrict;

    @Column(name = "WARD")
    private Long ward;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @Column(name = "LONGITUDE")
    private Double longtitude;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "X_COORDINATE")
    private Double xCoordinate;

    @Column(name = "Y_COORDINATE")
    private Double yCoordinate;

    @NotNull
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "COMPLETION_DATE")
    private Date completionDate;

    public Incident() {
    }

    public Incident(String serviceRequestNumber, IncidentType incidentType, Long ssa, Long comunityArea, Long policeDistrict, Long ward, String status, String zipCode, String streetAddress, Double longtitude, Double latitude, Double xCoordinate, Double yCoordinate, Date creationDate, Date completionDate) {
        this.serviceRequestNumber = serviceRequestNumber;
        this.incidentType = incidentType;
        this.ssa = ssa;
        this.comunityArea = comunityArea;
        this.policeDistrict = policeDistrict;
        this.ward = ward;
        this.status = status;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
    }

//    public Incident(Long reqId, String serviceRequestNumber, Long srvtId, Long ssa, Long comunityArea, Long policeDistrict, Long ward, String status, String zipCode, String streetAddress, Double longtitude, Double latitude, Double xCoordinate, Double yCoordinate, Date creationDate, Date completionDate) {
//        this.reqId = reqId;
//        this.serviceRequestNumber = serviceRequestNumber;
//        this.srvtId = srvtId;
//        this.ssa = ssa;
//        this.comunityArea = comunityArea;
//        this.policeDistrict = policeDistrict;
//        this.ward = ward;
//        this.status = status;
//        this.zipCode = zipCode;
//        this.streetAddress = streetAddress;
//        this.longtitude = longtitude;
//        this.latitude = latitude;
//        this.xCoordinate = xCoordinate;
//        this.yCoordinate = yCoordinate;
//        this.creationDate = creationDate;
//        this.completionDate = completionDate;
//    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getServiceRequestNumber() {
        return serviceRequestNumber;
    }

    public void setServiceRequestNumber(String serviceRequestNumber) {
        this.serviceRequestNumber = serviceRequestNumber;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    //    public Long getSrvtId() {
//        return srvtId;
//    }
//
//    public void setSrvtId(Long srvtId) {
//        this.srvtId = srvtId;
//    }

    public Long getSsa() {
        return ssa;
    }

    public void setSsa(Long ssa) {
        this.ssa = ssa;
    }

    public Long getComunityArea() {
        return comunityArea;
    }

    public void setComunityArea(Long comunityArea) {
        this.comunityArea = comunityArea;
    }

    public Long getPoliceDistrict() {
        return policeDistrict;
    }

    public void setPoliceDistrict(Long policeDistrict) {
        this.policeDistrict = policeDistrict;
    }

    public Long getWard() {
        return ward;
    }

    public void setWard(Long ward) {
        this.ward = ward;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}
