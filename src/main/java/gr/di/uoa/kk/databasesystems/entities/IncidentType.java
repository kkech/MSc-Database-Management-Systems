package gr.di.uoa.kk.databasesystems.entities;

import gr.di.uoa.kk.databasesystems.dto.StoreProcedureOneDto;
import gr.di.uoa.kk.databasesystems.dto.StoreProcedureTwoDto;

import javax.persistence.*;
import java.util.Date;


@SqlResultSetMapping(name="StoreProcedureTwoDto",
        classes={
                @ConstructorResult(targetClass= StoreProcedureTwoDto.class,
                        columns={
                                @ColumnResult(name="crdate", type= Date.class),
                                @ColumnResult(name="reqnum", type=Long.class),
                        })
        }
)
@Entity
@Table(name="service_request_types", schema = "public")
public class IncidentType {

    @Id
    @Column(name = "SRVT_ID")
    private Long srvtId;

    @Column(name = "SRVT_NAME")
    private String srvtName;

    public IncidentType() {
    }

    public IncidentType(Long srvtId, String srvtName) {
        this.srvtId = srvtId;
        this.srvtName = srvtName;
    }

    public Long getSrvtId() {
        return srvtId;
    }

    public void setSrvtId(Long srvtId) {
        this.srvtId = srvtId;
    }

    public String getSrvtName() {
        return srvtName;
    }

    public void setSrvtName(String srvtName) {
        this.srvtName = srvtName;
    }
}
