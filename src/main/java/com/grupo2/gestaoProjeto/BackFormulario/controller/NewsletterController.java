package com.grupo2.gestaoProjeto.BackFormulario.controller;

import com.grupo2.gestaoProjeto.BackFormulario.dto.NewsletterDto;
import com.grupo2.gestaoProjeto.BackFormulario.model.Newsletter;
import com.grupo2.gestaoProjeto.BackFormulario.service.NewsletterService;
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
public class NewsletterController {

    @Autowired
    NewsletterService newsletterService;

    @PostMapping(path = "/webhook/newsletter")
    public ResponseEntity<Newsletter> save(@RequestBody @Valid NewsletterDto newsletterDto){
        Newsletter newsletter = Newsletter.builder().build();
        BeanUtils.copyProperties(newsletterDto, newsletter);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newsletterService.save(newsletter));
    }

    @GetMapping(path = "/newsletters")
    public ResponseEntity<List<Newsletter>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(newsletterService.findAll());
    }

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
