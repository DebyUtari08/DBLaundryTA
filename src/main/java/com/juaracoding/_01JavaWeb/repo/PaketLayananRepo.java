package com.juaracoding._01JavaWeb.repo;

import com.juaracoding._01JavaWeb.model.Divisi;
import com.juaracoding._01JavaWeb.model.PaketLayanan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaketLayananRepo extends JpaRepository<PaketLayanan,Long> {

    Page<PaketLayanan> findByIsDelete(Pageable page , byte byteIsDelete);

    List<PaketLayanan> findByIsDelete(byte byteIsDelete);
    Page<PaketLayanan> findByIsDeleteAndNamaPaketContainsIgnoreCase(Pageable page , byte byteIsDelete, String values);
    Page<PaketLayanan> findByIsDeleteAndHarga(Pageable page , byte byteIsDelete, Double values);
    Page<PaketLayanan> findByIsDeleteAndTipeLayananContainsIgnoreCase(Pageable page , byte byteIsDelete, String values);
    Page<PaketLayanan> findByIsDeleteAndIdListHarga(Pageable page , byte byteIsDelete, Long values);
}
