package com.mortality.repository;

import com.mortality.domain.SexEnum;
import com.mortality.model.Mortality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MortalityRepository extends JpaRepository<Mortality, Long> {
    Optional<Mortality> findByYearAndCountryIdAndSex(int year, Long countryId, SexEnum sexEnum);
}
