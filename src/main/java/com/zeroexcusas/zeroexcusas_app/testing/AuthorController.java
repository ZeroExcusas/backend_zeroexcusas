package com.zeroexcusas.zeroexcusas_app.testing;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/author")
@Tag(name = "Author", description = "Autor, libros y editoriales")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    EditorialRepository editorialRepository;

    @PostMapping
    public ResponseEntity<Author> add(@RequestBody Author author) {
        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Author>> get() {
        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Editorial> getAuthorById(@PathVariable Integer authorId) {
        return new ResponseEntity<>(editorialRepository.getOne(authorId), HttpStatus.OK);
    }


    @PostMapping("/editorial/add/{authorId}")
    public ResponseEntity<?> addEditorial(@RequestBody Editorial editorial, @PathVariable Integer authorId) {
        Author author = authorRepository.getOne(authorId);
        editorial.setAuthor(author);
        return new ResponseEntity<>(editorialRepository.save(editorial), HttpStatus.OK);
    }

    @GetMapping("/editorial")
    public ResponseEntity<List<Editorial>> getEditorial() {
        return new ResponseEntity<>(editorialRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorialId}")
    public ResponseEntity<Editorial> getEditorialById(@PathVariable Integer editorialId) {
        return new ResponseEntity<>(editorialRepository.getOne(editorialId), HttpStatus.OK);
    }



}
