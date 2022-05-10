package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.Country;
import com.zeroexcusas.zeroexcusas_app.repository.CountryRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService
{
    @Autowired
    private CountryRepsitory countryRepository;

    public List<Country> listAllCountries() {
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountry(Integer id) {
        return countryRepository.findById( id).get();
    }

    public void deleteCountry(Integer id) {
        countryRepository.deleteById( id);
    }

}
