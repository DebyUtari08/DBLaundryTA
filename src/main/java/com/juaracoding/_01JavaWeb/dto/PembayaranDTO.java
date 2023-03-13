package com.juaracoding._01JavaWeb.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PembayaranDTO {
    private Long idPembayaran;

    private String namaPembayaran;

    public Long getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(Long idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public String getNamaPembayaran() {
        return namaPembayaran;
    }

    public void setNamaPembayaran(String namaPembayaran) {
        this.namaPembayaran = namaPembayaran;
    }
}
