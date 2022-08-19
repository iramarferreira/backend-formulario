package com.grupo2.gestaoProjeto.BackFormulario.service;

import com.grupo2.gestaoProjeto.BackFormulario.model.Notice;
import com.grupo2.gestaoProjeto.BackFormulario.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    public Notice save(Notice notice){
        notice.setCreated(LocalDateTime.now());
        return noticeRepository.save(notice);
    }

    public List<Notice> findAll(){
        return noticeRepository.findAll();
    }

    public Page<Notice> findAllPage(Pageable pageable){
        return noticeRepository.findAll(pageable);
    }

    public Notice findById(UUID id){
        if(noticeRepository.findById(id).isPresent()) {
            return noticeRepository.findById(id).get();
        }else{
            return null;
        }
    }

}
