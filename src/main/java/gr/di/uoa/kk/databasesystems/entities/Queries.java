package gr.di.uoa.kk.databasesystems.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="queries", schema = "public")
public class Queries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QRY_ID")
    private Long queryId;

    @Column(name = "USER_ID")
    private Long usrId;

    @Column(name = "QRY_DATE")
    private Date queryDate;

    @Column(name = "QRY_DATA")
    private String queryData;

    public Queries() {
    }

    public Queries(Long usrId, Date queryDate, String queryData) {
        this.usrId = usrId;
        this.queryDate = queryDate;
        this.queryData = queryData;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public Long getUsrId() {
        return usrId;
    }

    public void setUsrId(Long usrId) {
        this.usrId = usrId;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public String getQueryData() {
        return queryData;
    }

    public void setQueryData(String queryData) {
        this.queryData = queryData;
    }
}
