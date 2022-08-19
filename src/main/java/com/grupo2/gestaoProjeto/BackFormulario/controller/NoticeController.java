package com.grupo2.gestaoProjeto.BackFormulario.controller;

import com.grupo2.gestaoProjeto.BackFormulario.dto.NoticeDto;
import com.grupo2.gestaoProjeto.BackFormulario.model.Newsletter;
import com.grupo2.gestaoProjeto.BackFormulario.model.Notice;
import com.grupo2.gestaoProjeto.BackFormulario.service.NoticeService;
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

@RestController
@RequestMapping(path = "/api")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @Operation(summary = "Rota para receber o webhook de salvar o formulário de Aviso de Pauta")
    @PostMapping(path = "/webhook/notice")
    public ResponseEntity<Notice> save(@RequestBody @Valid NoticeDto noticeDto){

        Notice notice = Notice.builder().build();
        BeanUtils.copyProperties(noticeDto, notice);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(noticeService.save(notice));
    }


    @Operation(summary = "Retorna todos os cadadastros de Aviso de Pauta")
    @GetMapping(path = "/notices")
    public ResponseEntity<List<Notice>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(noticeService.findAll());
    }

    @Operation(summary = "Retorna todos os cadadastros de Aviso de Pauta com paginação")
    @GetMapping(path = "/notices/pageable")
    public ResponseEntity<Page<Notice>> findAllPage(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(noticeService.findAllPage(pageable));
    }

    @Operation(summary = "Retorna um cadadastro de Aviso de Pauta pelo seu ID")
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
