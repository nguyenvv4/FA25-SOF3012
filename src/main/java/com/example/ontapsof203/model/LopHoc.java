package com.example.ontapsof203.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "lop_hoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LopHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_lop")
    private String tenLop;

    @Column(name = "gvcn")
    private String gvcn;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Override
    public String toString() {
        return "LopHoc{" +
                "id=" + id +
                ", tenLop='" + tenLop + '\'' +
                ", gvcn='" + gvcn + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
