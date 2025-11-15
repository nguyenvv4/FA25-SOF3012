package com.example.ontapsof203.repository;

import com.example.ontapsof203.model.LopHoc;
import com.example.ontapsof203.utils.HibernateUtils;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LopHocRepo {

    public List<LopHoc> findAll() {
        Session session = HibernateUtils.getFACTORY().openSession();
        Query query = session.createQuery("from LopHoc");
        List<LopHoc> lopHocs = query.getResultList();
        return lopHocs;
    }

    public void xoa(Integer id) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction tran = session.beginTransaction();
        try {
           Query query = session.createQuery("delete from LopHoc where id = :id");
           query.setParameter("id", id);
           query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tran.commit();
    }

    public static void main(String[] args) {
        LopHocRepo lopHocRepo = new LopHocRepo();
        List<LopHoc> lopHocs = lopHocRepo.findAll();
        for (LopHoc lopHoc : lopHocs) {
            System.out.println(lopHoc.toString());
        }
    }
}
