package com.grupo2.gestaoProjeto.BackFormulario.service;

import com.grupo2.gestaoProjeto.BackFormulario.model.Attendance;
import com.grupo2.gestaoProjeto.BackFormulario.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    public Attendance save(Attendance attendance){
        attendance.setCreated(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> findAll(){
        return attendanceRepository.findAll();
    }

    public Attendance findById(UUID id){
        if(attendanceRepository.findById(id).isPresent()) {
            return attendanceRepository.findById(id).get();
        }else{
            return null;
        }
    }


}
