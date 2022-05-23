package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.Gender;
import com.zeroexcusas.zeroexcusas_app.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenderService implements ZEService
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

    @Override
    public List<?> getAllData() {
        return genderRepository.findAll();
    }

    //@Override
    public Optional<?> getOneRecord(Integer id) {
        // Method threw 'javax.persistence.EntityNotFoundException' exception. Cannot evaluate java.util.Optional.toString()
        Optional<?> gender = genderRepository.findById(id);

        return gender;
    }

    @Override
    public Optional<?> deleteOneRecord(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<?> register(Object data) {
        return Optional.empty();
    }

}
