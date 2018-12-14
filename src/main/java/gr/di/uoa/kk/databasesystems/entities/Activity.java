package gr.di.uoa.kk.databasesystems.entities;


import javax.persistence.*;

@Entity
@Table(name="activity", schema = "public")
public class Activity {

    @Id
    @Column(name = "REQ_ID")
    private Long  reqId;

    @Column(name = "CURRENT_ACTIVITY")
    private String  curActivity;

    @Column(name = "MOST_RECENT_ACTION")
    private String  mosRecAct;

    public Activity() {
    }

    public Activity(Long reqId, String curActivity, String mosRecAct) {
        this.reqId = reqId;
        this.curActivity = curActivity;
        this.mosRecAct = mosRecAct;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getCurActivity() {
        return curActivity;
    }

    public void setCurActivity(String curActivity) {
        this.curActivity = curActivity;
    }

    public String getMosRecAct() {
        return mosRecAct;
    }

    public void setMosRecAct(String mosRecAct) {
        this.mosRecAct = mosRecAct;
    }
}
