package com.zeroexcusas.zeroexcusas_app.web;

import com.google.gson.Gson;
import com.zeroexcusas.zeroexcusas_app.model.Suggestion;
import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.service.SuggestionService;
import com.zeroexcusas.zeroexcusas_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.rmi.NoSuchObjectException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {
    @Autowired
    SuggestionService suggestionService;

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<Suggestion> list() {
        return suggestionService.listAllSuggestion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suggestion> get(@PathVariable Integer id) {
        try {
            Suggestion suggestinon = suggestionService.getSuggestion(id);
            return new ResponseEntity<Suggestion>(suggestinon, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Suggestion>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register/{userId}")
    public ResponseEntity<?> add(@RequestBody Suggestion suggestion, @PathVariable Integer userId)  {
        User currentUser = userService.findById(userId);
        if (currentUser!=null) {
            suggestion.set_user(currentUser);
            return ResponseEntity.ok(suggestionService.save(suggestion));
        }
        else {
            return new ResponseEntity<Suggestion>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Suggestion> update(@RequestBody Suggestion suggestion, @PathVariable Integer id) {
        try {
            Suggestion existSuggestion = suggestionService.getSuggestion(id);
            if (existSuggestion != null) {
                existSuggestion.setDescription(suggestion.getDescription());
                existSuggestion.setDate(suggestion.getDate());
                existSuggestion.set_user(suggestion.get_user());
                suggestionService.save(existSuggestion);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<Suggestion>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Suggestion>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Suggestion suggestion = suggestionService.getSuggestion( id );
            if ( suggestion != null ) {
                suggestionService.deleteSuggestion(id);
                return new ResponseEntity<>( HttpStatus.OK );
            }
            else {
                return new ResponseEntity<Suggestion>( HttpStatus.NOT_FOUND );
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This is a fast and temporal method to get json for payload
     * Just for testing
     * @return
     */
    @GetMapping("/template")
    public String getTemplate() {
        Suggestion s = new Suggestion();
        User u = new User();
        s.set_user(u);
        s.setDescription("Pollo Salteado");
        s.setDate(LocalDateTime.now());
        Gson gson = new Gson();
        return gson.toJson(s);
    }
}
