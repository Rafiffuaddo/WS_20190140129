/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.c.pws.c9;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "datamaahasiswa")
@NamedQueries({
    @NamedQuery(name = "Datamaahasiswa.findAll", query = "SELECT d FROM Datamaahasiswa d"),
    @NamedQuery(name = "Datamaahasiswa.findByNim", query = "SELECT d FROM Datamaahasiswa d WHERE d.nim = :nim"),
    @NamedQuery(name = "Datamaahasiswa.findByNama", query = "SELECT d FROM Datamaahasiswa d WHERE d.nama = :nama"),
    @NamedQuery(name = "Datamaahasiswa.findByAlamat", query = "SELECT d FROM Datamaahasiswa d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Datamaahasiswa.findByProdi", query = "SELECT d FROM Datamaahasiswa d WHERE d.prodi = :prodi"),
    @NamedQuery(name = "Datamaahasiswa.findByFaAKULTAS", query = "SELECT d FROM Datamaahasiswa d WHERE d.faAKULTAS = :faAKULTAS")})
public class Datamaahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIM")
    private Long nim;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "ALAMAT")
    private String alamat;
    @Column(name = "PRODI")
    private String prodi;
    @Column(name = "FaAKULTAS")
    private String faAKULTAS;

    public Datamaahasiswa() {
    }

    public Datamaahasiswa(Long nim) {
        this.nim = nim;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFaAKULTAS() {
        return faAKULTAS;
    }

    public void setFaAKULTAS(String faAKULTAS) {
        this.faAKULTAS = faAKULTAS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datamaahasiswa)) {
            return false;
        }
        Datamaahasiswa other = (Datamaahasiswa) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pws.c.pws.c9.Datamaahasiswa[ nim=" + nim + " ]";
    }
    
}
