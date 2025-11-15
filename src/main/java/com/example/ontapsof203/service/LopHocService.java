package com.example.ontapsof203.service;

import com.example.ontapsof203.model.LopHoc;
import com.example.ontapsof203.repository.LopHocRepo;

import java.util.List;

public class LopHocService {

    LopHocRepo lopHocRepo = new LopHocRepo();

    public List<LopHoc> getAllLopHoc() {
        return lopHocRepo.findAll();
    }

    public void xoa(Integer id) {
        lopHocRepo.xoa(id);
    }
}
