package gr.di.uoa.kk.databasesystems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_data", schema = "public")
public class VehicleData {

    @Id
    @Column(name = "REQ_ID")
    private Long  reqId;

    @Column(name = "LICENSE_PLATE")
    private String  licPlate;

    @Column(name = "VEHICLE_MAKE_MODEL")
    private String  vehMakeModel;

    @Column(name = "VEHICLE_COLOR")
    private String  vehColor;

    @Column(name = "DAYS_VEHICLE_REPORTED_PARKED")
    private Long  dVehRepPark;

    public VehicleData() {
    }

    public VehicleData(Long reqId, String licPlate, String vehMakeModel, String vehColor, Long dVehRepPark) {
        this.reqId = reqId;
        this.licPlate = licPlate;
        this.vehMakeModel = vehMakeModel;
        this.vehColor = vehColor;
        this.dVehRepPark = dVehRepPark;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getLicPlate() {
        return licPlate;
    }

    public void setLicPlate(String licPlate) {
        this.licPlate = licPlate;
    }

    public String getVehMakeModel() {
        return vehMakeModel;
    }

    public void setVehMakeModel(String vehMakeModel) {
        this.vehMakeModel = vehMakeModel;
    }

    public String getVehColor() {
        return vehColor;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    public Long getdVehRepPark() {
        return dVehRepPark;
    }

    public void setdVehRepPark(Long dVehRepPark) {
        this.dVehRepPark = dVehRepPark;
    }
}
