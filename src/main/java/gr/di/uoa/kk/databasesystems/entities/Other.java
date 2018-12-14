package gr.di.uoa.kk.databasesystems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="other_data", schema = "public")
public class Other {

    @Id
    @Column(name = "REQ_ID")
    private Long  reqId;

    @Column(name = "BLACK_CARTS_DELIVERED")
    private Long  blackCartDeliver;

    @Column(name = "NUMBER_OF_POTHOLES_FILLED")
    private Long  numOfPothFilled;

    @Column(name = "NATURE_OF_CODE_VIOLATION")
    private String  natOfCodViol;

    @Column(name = "DEBRIS_LOCATED")
    private String  debLocat;

    @Column(name = "LOCATION_OF_TREES")
    private String  locOfTr;

    public Other() {
    }

    public Other(Long reqId, Long blackCartDeliver, Long numOfPothFilled, String natOfCodViol, String debLocat, String locOfTr) {
        this.reqId = reqId;
        this.blackCartDeliver = blackCartDeliver;
        this.numOfPothFilled = numOfPothFilled;
        this.natOfCodViol = natOfCodViol;
        this.debLocat = debLocat;
        this.locOfTr = locOfTr;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public Long getBlackCartDeliver() {
        return blackCartDeliver;
    }

    public void setBlackCartDeliver(Long blackCartDeliver) {
        this.blackCartDeliver = blackCartDeliver;
    }

    public Long getNumOfPothFilled() {
        return numOfPothFilled;
    }

    public void setNumOfPothFilled(Long numOfPothFilled) {
        this.numOfPothFilled = numOfPothFilled;
    }

    public String getNatOfCodViol() {
        return natOfCodViol;
    }

    public void setNatOfCodViol(String natOfCodViol) {
        this.natOfCodViol = natOfCodViol;
    }

    public String getDebLocat() {
        return debLocat;
    }

    public void setDebLocat(String debLocat) {
        this.debLocat = debLocat;
    }

    public String getLocOfTr() {
        return locOfTr;
    }

    public void setLocOfTr(String locOfTr) {
        this.locOfTr = locOfTr;
    }
}
