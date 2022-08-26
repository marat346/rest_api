package com.calisto.spring.rest_api.entity.company;

import com.calisto.spring.rest_api.entity.stampendsignature.Signature;
import com.calisto.spring.rest_api.entity.stampendsignature.Stamp;

import javax.persistence.*;
import java.util.List;

// список печатей
@Entity
@Table(name = "stamps_end_signatures_table")
public class StampsEndSignatures {
    // ид печати
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idStampendsignature;

    // список печатей
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stamp_signature_stamp",
            joinColumns = @JoinColumn(name = "stamp_signature_id"),
            inverseJoinColumns = @JoinColumn(name = "stamp_id"))
    private List<Stamp> stamp;

    // список подписей
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stamp_signature_signature",
            joinColumns = @JoinColumn(name = "stamp_signature_id"),
            inverseJoinColumns = @JoinColumn(name = "signature_id"))
    private List<Signature> signature;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_stamp_signature",
            joinColumns = @JoinColumn(name = "stamp_signature_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companyList;

    public StampsEndSignatures() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int getIdStampendsignature() {
        return idStampendsignature;
    }

    public void setIdStampendsignature(int idStampendsignature) {
        this.idStampendsignature = idStampendsignature;
    }

    public List<Stamp> getStamp() {
        return stamp;
    }

    public void setStamp(List<Stamp> stamp) {
        this.stamp = stamp;
    }

    public List<Signature> getSignature() {
        return signature;
    }

    public void setSignature(List<Signature> signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "StampsEndSignatures{" +
                "idStampendsignature=" + idStampendsignature +
                '}' + "\n";
    }
}
