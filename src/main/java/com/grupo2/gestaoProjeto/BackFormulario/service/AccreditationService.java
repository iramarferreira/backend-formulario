package com.grupo2.gestaoProjeto.BackFormulario.service;

import com.grupo2.gestaoProjeto.BackFormulario.model.Accreditation;
import com.grupo2.gestaoProjeto.BackFormulario.repository.AccreditationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccreditationService {

    @Autowired
    AccreditationRepository accreditationRepository;

    public Accreditation save(Accreditation accreditation){
        accreditation.setCreated(LocalDateTime.now());
        return accreditationRepository.save(accreditation);
    }

    public List<Accreditation> findAll(){
        return  accreditationRepository.findAll();
    }

}
