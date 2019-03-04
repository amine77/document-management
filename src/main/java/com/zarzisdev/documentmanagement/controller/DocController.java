package com.zarzisdev.documentmanagement.controller;

import com.zarzisdev.documentmanagement.model.Doc;
import com.zarzisdev.documentmanagement.repository.DocRepository;
import com.zarzisdev.documentmanagement.uils.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/apitest")
public class DocController {
    @Autowired
    DocRepository docRepository;

    @GetMapping("/documents")
    public List<Doc> getDoc() {
        return docRepository.findAll();
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Doc> getDocDetails(@PathVariable("id") Long id) {
        Optional<Doc> docData = docRepository.findById(id);
        if (docData.isPresent()) {
            return new ResponseEntity<>(docData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource>docsReport() throws IOException {

        List<Doc> docs = (List<Doc>) docRepository.findAll();

        ByteArrayInputStream bis = GeneratePdfReport.docsReport(docs);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=docsreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
