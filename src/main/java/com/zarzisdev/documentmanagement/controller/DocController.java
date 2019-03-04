package com.zarzisdev.documentmanagement.controller;

import com.zarzisdev.documentmanagement.model.Doc;
import com.zarzisdev.documentmanagement.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/apitest")
public class DocController {
    @Autowired
    DocRepository docRepository;

    @GetMapping("/documents")
    public List<Doc> getDoc(){
        return docRepository.findAll();
    }
}
