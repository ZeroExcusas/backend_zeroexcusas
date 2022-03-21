package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.Gender;
import com.zeroexcusas.zeroexcusas_app.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GenderService
{
    @Autowired
    private GenderRepository genderRepository;
    public List<Gender> listAllGender() {
        return genderRepository.findAll();
    }

    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }

    public Gender getGender(Integer id) {
        return genderRepository.findById(id).get();
    }

    public void deleteGender(Integer id) {
        genderRepository.deleteById(id);
    }

}
