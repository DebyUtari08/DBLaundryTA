package com.juaracoding._01JavaWeb.repo;

import com.juaracoding._01JavaWeb.model.Divisi;
import com.juaracoding._01JavaWeb.model.Pesanan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PesananRepo extends JpaRepository<Pesanan,Long> {
    Page<Pesanan> findByIsDelete(Pageable page , byte byteIsDelete);

    List<Pesanan> findByIsDelete(byte byteIsDelete);
    Page<Pesanan> findByIsDeleteAndIdPesanan(Pageable page , byte byteIsDelete, Long values);
}
