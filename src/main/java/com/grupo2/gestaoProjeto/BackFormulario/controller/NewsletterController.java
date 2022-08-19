package com.grupo2.gestaoProjeto.BackFormulario.controller;

import com.grupo2.gestaoProjeto.BackFormulario.dto.NewsletterDto;
import com.grupo2.gestaoProjeto.BackFormulario.model.Newsletter;
import com.grupo2.gestaoProjeto.BackFormulario.service.NewsletterService;
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
public class NewsletterController {

    @Autowired
    NewsletterService newsletterService;

    @Operation(summary = "Rota para receber o webhook de salvar o formulário de Newsletter")
    @PostMapping(path = "/webhook/newsletter")
    public ResponseEntity<Newsletter> save(@RequestBody @Valid NewsletterDto newsletterDto){
        Newsletter newsletter = Newsletter.builder().build();
        BeanUtils.copyProperties(newsletterDto, newsletter);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newsletterService.save(newsletter));
    }

    @Operation(summary = "Retorna todos os cadadastros de Newsletter")
    @GetMapping(path = "/newsletters")
    public ResponseEntity<List<Newsletter>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(newsletterService.findAll());
    }

    @Operation(summary = "Retorna todos os cadadastros de Newsletters com paginação")
    @GetMapping(path = "/newsletters/pageable")
    public ResponseEntity<Page<Newsletter>> findAllPage(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(newsletterService.findAllPage(pageable));
    }

    @Operation(summary = "Retorna um cadadastro de Newsletter pelo seu ID")
    @GetMapping(path = "/newsletter/{id}")
    public ResponseEntity<Newsletter> findById(@PathVariable UUID id){
        Newsletter newsletter = newsletterService.findById(id);
        if(newsletter != null){
            return ResponseEntity.status(HttpStatus.OK).body(newsletter);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
