package com.grupo2.gestaoProjeto.BackFormulario.controller;

import com.grupo2.gestaoProjeto.BackFormulario.dto.AccreditationDto;
import com.grupo2.gestaoProjeto.BackFormulario.model.Accreditation;
import com.grupo2.gestaoProjeto.BackFormulario.service.AccreditationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AccreditationController {

    @Autowired
    AccreditationService accreditationService;

    // rota para o webhook de credenciamento
    @PostMapping(path = "/webhook/accreditation")
    public ResponseEntity<Accreditation> save(@RequestBody @Valid AccreditationDto accreditationDto){
        Accreditation accreditation = Accreditation.builder().build();
        BeanUtils.copyProperties(accreditationDto, accreditation);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accreditationService.save(accreditation));
    }

    @GetMapping(path = "/accreditations")
    public ResponseEntity<List<Accreditation>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accreditationService.findAll());
    }

}
