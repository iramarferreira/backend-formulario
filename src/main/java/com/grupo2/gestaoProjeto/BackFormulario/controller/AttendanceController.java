package com.grupo2.gestaoProjeto.BackFormulario.controller;

import com.grupo2.gestaoProjeto.BackFormulario.dto.AttendanceDto;
import com.grupo2.gestaoProjeto.BackFormulario.model.Attendance;
import com.grupo2.gestaoProjeto.BackFormulario.service.AttendanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping(path = "/webhook/attendance")
    public ResponseEntity<Attendance> save(@RequestBody @Valid AttendanceDto attendanceDto){
        Attendance attendance = Attendance.builder().build();
        BeanUtils.copyProperties(attendanceDto, attendanceDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(attendanceService.save(attendance));
    }

    @GetMapping(path = "/attendances")
    public ResponseEntity<List<Attendance>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(attendanceService.findAll());
    }
}
