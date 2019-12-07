package com.kin.test.springboot.service;


import com.kin.test.springboot.global.Result;
import com.kin.test.springboot.model.DangerousSourcePlace;

import javax.servlet.http.HttpServletResponse;

public interface DangerousSourcePlaceService {
    Result getAllDangerousSourcePlaceByCompany(DangerousSourcePlace dangerousSourcePlace);
    void exportExcel(HttpServletResponse res) throws Exception;
}
