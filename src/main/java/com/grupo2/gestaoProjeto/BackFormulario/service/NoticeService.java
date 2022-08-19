package com.grupo2.gestaoProjeto.BackFormulario.service;

import com.grupo2.gestaoProjeto.BackFormulario.model.Notice;
import com.grupo2.gestaoProjeto.BackFormulario.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

}
