package com.example.ontapsof203.service;

import com.example.ontapsof203.model.LopHoc;
import com.example.ontapsof203.repository.LopHocRepo;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;

import java.util.List;

public class LopHocService {

    LopHocRepo lopHocRepo = new LopHocRepo();

    public List<LopHoc> getAllLopHoc() {
        return lopHocRepo.findAll();
    }

    public void xoa(Integer id) {
        lopHocRepo.xoa(id);
    }

    public void them(LopHoc lopHoc) {
        lopHocRepo.them(lopHoc);
    }

    public LopHoc chiTiet(Integer id) {
        return lopHocRepo.chiTiet(id);
    }
}
