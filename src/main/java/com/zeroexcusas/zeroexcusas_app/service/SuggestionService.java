package com.zeroexcusas.zeroexcusas_app.service;
import com.zeroexcusas.zeroexcusas_app.model.Suggestion;
import com.zeroexcusas.zeroexcusas_app.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SuggestionService {

    @Autowired
    private SuggestionRepository suggestionRepository;

    public Suggestion save(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    public Suggestion getSuggestion(Integer id) {
        return suggestionRepository.findById(id).get();
    }

    public List<Suggestion> listAllSuggestion() {
        return (List<Suggestion>) suggestionRepository.findAll();
    }

    public void deleteSuggestion(Integer id) {
        suggestionRepository.deleteById(id);
    }








}
