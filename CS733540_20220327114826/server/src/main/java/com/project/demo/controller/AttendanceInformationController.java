package com.project.demo.controller;

import com.project.demo.entity.AttendanceInformation;
import com.project.demo.service.AttendanceInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *考勤信息：(AttendanceInformation)表控制层
 *
 */
@RestController
@RequestMapping("/attendance_information")
public class AttendanceInformationController extends BaseController<AttendanceInformation,AttendanceInformationService> {

    /**
     *考勤信息对象
     */
    @Autowired
    public AttendanceInformationController(AttendanceInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
