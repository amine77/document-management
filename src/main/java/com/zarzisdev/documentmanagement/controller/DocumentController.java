package com.zarzisdev.documentmanagement.controller;

import com.zarzisdev.documentmanagement.model.Document;
import com.zarzisdev.documentmanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/web")
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/documents")
    public List<Document> getAllDocuments(){
        return documentRepository.findAll();
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable("id") Long id){
        //la méthode findById retorne un Optional
        Optional<Document> documentData = documentRepository.findById(id);
        if (documentData.isPresent()){
           Document _document = documentData.get();
           return new ResponseEntity<>(_document, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/documents/create")
    public ResponseEntity<Document> createDocument(@RequestBody Document document){
        return new ResponseEntity<>(documentRepository.save(document), HttpStatus.OK);
    }

    @DeleteMapping("/documents/delete")
    public ResponseEntity<String> deleteAllDocuments(){
        documentRepository.deleteAll();
        return new ResponseEntity<>("All documents have been deleted", HttpStatus.OK);
    }

    @DeleteMapping("/documents/delete/{id}")
    public ResponseEntity<String> deleteOneDocument(@PathVariable("id") Long id){
        documentRepository.deleteById(id);
        return new ResponseEntity<>("Document has been successefully deleted", HttpStatus.OK);
    }
}