package gr.di.uoa.kk.databasesystems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="premise_data", schema = "public")
public class Premise {

    @Id
    @Column(name = "REQ_ID")
    private Long  reqId;

    @Column(name = "TYPE_OF_SURFACE")
    private String  typOfSur;

    @Column(name = "WHERE_IS_THE_GRAFFITI")
    private String  whIsTheGraf;

    @Column(name = "PREMISES_BAITED")
    private Long  premBait;

    @Column(name = "PREMISES_WITH_GARBAGE")
    private Long  premWithGarb;

    @Column(name = "PREMISES_WITH_RATS")
    private Long  premWithRats;

    public Premise() {
    }

    public Premise(Long reqId, String typOfSur, String whIsTheGraf, Long premBait, Long premWithGarb, Long premWithRats) {
        this.reqId = reqId;
        this.typOfSur = typOfSur;
        this.whIsTheGraf = whIsTheGraf;
        this.premBait = premBait;
        this.premWithGarb = premWithGarb;
        this.premWithRats = premWithRats;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getTypOfSur() {
        return typOfSur;
    }

    public void setTypOfSur(String typOfSur) {
        this.typOfSur = typOfSur;
    }

    public String getWhIsTheGraf() {
        return whIsTheGraf;
    }

    public void setWhIsTheGraf(String whIsTheGraf) {
        this.whIsTheGraf = whIsTheGraf;
    }

    public Long getPremBait() {
        return premBait;
    }

    public void setPremBait(Long premBait) {
        this.premBait = premBait;
    }

    public Long getPremWithGarb() {
        return premWithGarb;
    }

    public void setPremWithGarb(Long premWithGarb) {
        this.premWithGarb = premWithGarb;
    }

    public Long getPremWithRats() {
        return premWithRats;
    }

    public void setPremWithRats(Long premWithRats) {
        this.premWithRats = premWithRats;
    }
}
