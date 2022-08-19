package com.grupo2.gestaoProjeto.BackFormulario.controller;

import com.grupo2.gestaoProjeto.BackFormulario.dto.NoticeDto;
import com.grupo2.gestaoProjeto.BackFormulario.model.Notice;
import com.grupo2.gestaoProjeto.BackFormulario.service.NoticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @PostMapping(path = "/webhook/notice")
    public ResponseEntity<Notice> save(@RequestBody @Valid NoticeDto noticeDto){

        Notice notice = Notice.builder().build();
        BeanUtils.copyProperties(noticeDto, notice);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(noticeService.save(notice));
    }

    @GetMapping(path = "/notices")
    public ResponseEntity<List<Notice>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(noticeService.findAll());
    }


    @GetMapping(path = "/notice/{id}")
    public ResponseEntity<Notice> findById(@PathVariable UUID id){
        Notice notice = noticeService.findById(id);
        if(notice != null){
            return ResponseEntity.status(HttpStatus.OK).body(notice);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
