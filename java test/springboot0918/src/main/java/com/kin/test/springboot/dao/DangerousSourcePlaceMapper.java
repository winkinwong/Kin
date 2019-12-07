package com.kin.test.springboot.dao;

import com.kin.test.springboot.model.DangerousSourcePlace;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dangerousSourcePlaceMapper")
public interface DangerousSourcePlaceMapper {
    List<DangerousSourcePlace> getAllDangerousSourcePlaceByCompany(DangerousSourcePlace dangerousSourcePlace);
}
