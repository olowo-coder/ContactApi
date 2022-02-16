package com.example.contactpageapi.contact;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/contact")
@CrossOrigin("*")

public class ContactController {

    private final ContactRepository contactRepository;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Contact>> getAllContact(){
        return ResponseEntity.ok(contactRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        System.out.println(contact);
        return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.CREATED);
    }

    @PutMapping("/add")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact){
        return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable String id){
        contactRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "deleted"));
    }



}
