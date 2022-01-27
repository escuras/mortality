package com.mortality.service;

import com.mortality.domain.MortalityTax;
import com.mortality.model.Mortality;

import java.util.List;

public interface MortalityService {

    List<MortalityTax> getMortalityTaxes(int year);

    Mortality save(Mortality mortality);
}
