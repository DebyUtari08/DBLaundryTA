package com.juaracoding._01JavaWeb.repo;

import com.juaracoding._01JavaWeb.model.Divisi;
import com.juaracoding._01JavaWeb.model.Pembayaran;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PembayaranRepo extends JpaRepository<Pembayaran,Long> {

    Page<Pembayaran> findByIsDelete(Pageable page , byte byteIsDelete);

    List<Pembayaran> findByIsDelete(byte byteIsDelete);
    Page<Pembayaran> findByIsDeleteAndNamaPembayaranContainsIgnoreCase(Pageable page , byte byteIsDelete, String values);
    Page<Pembayaran> findByIsDeleteAndIdPembayaran(Pageable page , byte byteIsDelete, Long values);
}
