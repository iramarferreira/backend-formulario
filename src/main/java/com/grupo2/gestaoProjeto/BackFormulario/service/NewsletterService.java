package com.grupo2.gestaoProjeto.BackFormulario.service;

import com.grupo2.gestaoProjeto.BackFormulario.model.Newsletter;
import com.grupo2.gestaoProjeto.BackFormulario.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsletterService {

    @Autowired
    NewsletterRepository newsletterRepository;

    public Newsletter save(Newsletter newsletter){
        newsletter.setCreated(LocalDateTime.now());
        return newsletterRepository.save(newsletter);
    }

    public List<Newsletter> findAll(){
        return newsletterRepository.findAll();
    }
}
