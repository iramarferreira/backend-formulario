package com.grupo2.gestaoProjeto.BackFormulario.controller;

import com.grupo2.gestaoProjeto.BackFormulario.dto.AttendanceDto;
import com.grupo2.gestaoProjeto.BackFormulario.model.Attendance;
import com.grupo2.gestaoProjeto.BackFormulario.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(originPatterns = "${spring.application.originPatterns}")
@RestController
@RequestMapping(path = "/api")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @Operation(summary = "Rota para receber o webhook de salvar o formulário de Atendimento")
    @PostMapping(path = "/webhook/attendance")
    public ResponseEntity<Attendance> save(@RequestBody @Valid AttendanceDto attendanceDto){
        Attendance attendance = Attendance.builder().build();
        BeanUtils.copyProperties(attendanceDto, attendance);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(attendanceService.save(attendance));
    }

    @Operation(summary = "Retorna todos os cadadastros de Atendimento")
    @GetMapping(path = "/attendances")
    public ResponseEntity<List<Attendance>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(attendanceService.findAll());
    }

    @Operation(summary = "Retorna todos os cadadastros de Atendimento com paginação")
    @GetMapping(path = "/attendances/pageable")
    public ResponseEntity<Page<Attendance>> findAllPage(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(attendanceService.findAllPage(pageable));
    }


    @Operation(summary = "Retorna um cadadastro de Atendimento à imprensa pelo seu ID")
    @GetMapping(path = "/attendance/{id}")
    public ResponseEntity<Attendance> findById(@PathVariable UUID id){
        Attendance attendance = attendanceService.findById(id);
        if(attendance != null){
            return ResponseEntity.status(HttpStatus.OK).body(attendance);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
