package gr.di.uoa.kk.databasesystems.RestControllers;

import gr.di.uoa.kk.databasesystems.dto.StoreProcedureOneDto;
import gr.di.uoa.kk.databasesystems.dto.StoreProcedureThreeDto;
import gr.di.uoa.kk.databasesystems.dto.StoreProcedureTwoDto;
import gr.di.uoa.kk.databasesystems.entities.*;
import gr.di.uoa.kk.databasesystems.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/")
class RestControllerAPIs {

    @Autowired
    IncidentService incidentService;

    @Autowired
    IncidentTypeService incidentTypeService;

    @Autowired
    ActivityService activityService;

    @Autowired
    QueriesService queriesService;

    @Autowired
    UserService userService;

    @Autowired
    VehicleDataService vehicleDataService;

    @Autowired
    PremiseService premiseService;

    @Autowired
    OtherService otherService;

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping(value = "find", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ModelAndView findIncident( @RequestParam String zip,
                            @RequestParam String streetAddress,
                            Authentication authentication ) throws Exception {

        ModelAndView modelAndView = new ModelAndView("find");
        modelAndView.addObject("incidents", incidentService.findIncidentByZipOrStreetAddress(zip,streetAddress));
        modelAndView.addObject("userName",authentication.getName());
        logUserAction(authentication.getName(), "Search zip : " + zip + " and address : " + streetAddress);
        return modelAndView;
    }

    @PostMapping(value = "storeProcedureOne", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ModelAndView storeProcedureOne( @RequestParam String startDate,
                             @RequestParam String endDate,
                             Authentication authentication ) throws Exception {

        ModelAndView modelAndView = new ModelAndView("storeProcedureOne");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateSQL = format.parse(startDate);
        Date endDateSQL = format.parse(endDate);


        String sql = "select * from q1(:startDate,:endDate)";

        List<StoreProcedureOneDto> storeProcedureOneDtoList = entityManager.createNativeQuery(sql, "StoreProcedureOneDto")
                .setParameter("startDate", new java.sql.Date(startDateSQL.getTime()))
                .setParameter("endDate", new java.sql.Date(endDateSQL.getTime()))
                .getResultList();

        modelAndView.addObject("results", storeProcedureOneDtoList);
        modelAndView.addObject("userName",authentication.getName());
        logUserAction(authentication.getName(), "Call SP1");
        return modelAndView;
    }


    @PostMapping(value = "storeProcedureTwo", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ModelAndView storeProcedureTwo( @RequestParam String requestType,
                                    @RequestParam String startDate,
                                    @RequestParam String endDate,
                                      Authentication authentication ) throws Exception {

        ModelAndView modelAndView = new ModelAndView("storeProcedureTwo");
        IncidentType incidentType = incidentTypeService.getIncidentTypeIdByName(requestType);
        List<IncidentType> incidentTypeList = incidentTypeService.findAllIncidentTypeNames();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateSQL = format.parse(startDate);
        Date endDateSQL = format.parse(endDate);

        String sql = "select * from q2(:startDate,:endDate,:type)";

        List<StoreProcedureTwoDto> storeProcedureTwoDtoList = entityManager.createNativeQuery(sql, "StoreProcedureTwoDto")
                .setParameter("startDate", new java.sql.Date(startDateSQL.getTime()))
                .setParameter("endDate", new java.sql.Date(endDateSQL.getTime()))
                .setParameter("type", incidentType.getSrvtId())
                .getResultList();

        modelAndView.addObject("results", storeProcedureTwoDtoList);
        modelAndView.addObject("types",incidentTypeList);
        modelAndView.addObject("userName",authentication.getName());
        logUserAction(authentication.getName(), "Call SP2");
        return modelAndView;
    }

    @PostMapping(value = "storeProcedureThree", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ModelAndView storeProcedureThree( @RequestParam String dateString,
                                    Authentication authentication ) throws Exception {

        ModelAndView modelAndView = new ModelAndView("storeProcedureThree");

        String sql = "select * from q3(:date)";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateSQL = format.parse(dateString);

        List<StoreProcedureThreeDto> storeProcedureThreeDtoList = entityManager.createNativeQuery(sql, "StoreProcedureThreeDto")
                .setParameter("date", new java.sql.Date(dateSQL.getTime()))
                .getResultList();

        modelAndView.addObject("results", storeProcedureThreeDtoList);
        modelAndView.addObject("userName",authentication.getName());
        logUserAction(authentication.getName(), "Call SP3");
        return modelAndView;
    }

    @PostMapping(value = "insert", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ModelAndView insertIncident( @RequestParam String reqNum,
                                 @RequestParam String status,
                                 @RequestParam String crDate,
                                 @RequestParam(required = false) String cmplDate,
                                 @RequestParam(required = false) String strAddr,
                                 @RequestParam(required = false) String zip,
                                 @RequestParam(required = false) String xCor,
                                 @RequestParam(required = false) String yCor,
                                 @RequestParam(required = false) String longt,
                                 @RequestParam(required = false) String latit,
                                 @RequestParam(required = false) String ward,
                                 @RequestParam(required = false) String polDis,
                                 @RequestParam(required = false) String comArea,
                                 @RequestParam(required = false) String ssa,
                                 @RequestParam(required = false) String requestType,
                                 @RequestParam(required = false) String mostRecAct,
                                 @RequestParam(required = false) String curAct,
                                 @RequestParam(required = false) String licPlat,
                                 @RequestParam(required = false) String vehMod,
                                 @RequestParam(required = false) String vehCol,
                                 @RequestParam(required = false) String dVehRep,
                                 @RequestParam(required = false) String typOfSur,
                                 @RequestParam(required = false) String wIsTheGraf,
                                 @RequestParam(required = false) String premBait,
                                 @RequestParam(required = false) String premWithGarb,
                                 @RequestParam(required = false) String blaCarDel,
                                 @RequestParam(required = false) String numOfPothFill,
                                 @RequestParam(required = false) String natOfCodViol,
                                 @RequestParam(required = false) String debLoc,
                                 @RequestParam(required = false) String locOfTrees,
                                 @RequestParam(required = false) String premWithRats,
                                 Authentication authentication ) throws Exception {

        ModelAndView modelAndView = new ModelAndView("insert");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date crDateSQL = format.parse(crDate);
        Date cmplDateSQL = null;
        if(cmplDate != null && (!cmplDate.isEmpty()))
            cmplDateSQL = format.parse(cmplDate);

        IncidentType incidentType = incidentTypeService.getIncidentTypeIdByName(requestType);
        Incident incident;
        if(ssa != null && (!ssa.isEmpty()))
            incident = new Incident(reqNum,incidentType,Long.parseLong(ssa),Long.parseLong(comArea),
                    Long.parseLong(polDis),Long.parseLong(ward),status,zip,
                    strAddr,Double.parseDouble(longt),Double.parseDouble(latit),Double.parseDouble(xCor),Double.parseDouble(yCor),
                    crDateSQL,cmplDateSQL);
        else
            incident = new Incident(reqNum,incidentType,null,Long.parseLong(comArea),
                    Long.parseLong(polDis),Long.parseLong(ward),status,zip,
                    strAddr,Double.parseDouble(longt),Double.parseDouble(latit),Double.parseDouble(xCor),Double.parseDouble(yCor),
                    crDateSQL,cmplDateSQL);
        incident = incidentService.addIncident(incident);

        switch(incident.getIncidentType().getSrvtId().intValue()){
            case 1:
                activityService.addActivity(new Activity(incident.getReqId(),curAct,mostRecAct));
                vehicleDataService.addVehicle(new VehicleData(incident.getReqId(),licPlat,vehMod,vehCol,Long.parseLong(dVehRep)));
                break;
            case 3:
                activityService.addActivity(new Activity(incident.getReqId(),curAct,mostRecAct));
                otherService.addOther(new Other(incident.getReqId(),Long.parseLong(blaCarDel),null,null,null,null));
                break;
            case 4:
                premiseService.addPremise(new Premise(incident.getReqId(),typOfSur,wIsTheGraf,null,null,null));
                break;
            case 5:
                activityService.addActivity(new Activity(incident.getReqId(),curAct,mostRecAct));
                otherService.addOther(new Other(incident.getReqId(),null,Long.parseLong(numOfPothFill),null,null,null));
                break;
            case 6:
                activityService.addActivity(new Activity(incident.getReqId(),curAct,mostRecAct));
                premiseService.addPremise(new Premise(incident.getReqId(),null,null,Long.parseLong(premBait),Long.parseLong(premWithGarb),Long.parseLong(premWithRats)));
                break;
            case 7:
                otherService.addOther(new Other(incident.getReqId(),null,null,natOfCodViol,null,null));
                break;
            case 10:
                activityService.addActivity(new Activity(incident.getReqId(),curAct,mostRecAct));
                otherService.addOther(new Other(incident.getReqId(),null,null,null,debLoc,null));
                break;
            case 11:
                otherService.addOther(new Other(incident.getReqId(),null,null,null,null,locOfTrees));
                break;
            default:
                break;

        }

        List<IncidentType> incidentTypeList = incidentTypeService.findAllIncidentTypeNames();
        modelAndView.addObject("types",incidentTypeList);
        modelAndView.addObject("userName",authentication.getName());
        logUserAction(authentication.getName(), "Insert new incident with type : " + incidentType.getSrvtName());
        modelAndView.addObject("message","Completed");
        return modelAndView;
    }

    private void logUserAction(String name, String action) {
        User user = userService.findUserByName(name);
        Queries queries = new Queries(user.getId(),new Date(),action);
        queriesService.addQueryHistory(queries);
    }
}
