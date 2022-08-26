package com.calisto.spring.rest_api.entity.stampendsignature;

import com.calisto.spring.rest_api.entity.company.StampsEndSignatures;

import javax.persistence.*;
import java.util.List;

// класс содержит информацию о подписях
@Entity
@Table(name = "signature_table")
public class Signature {
    // ид подписей
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idSignature;

    // список подписей
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "signature_image",
            joinColumns = @JoinColumn(name = "signature_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_image_id"))
    private List<ImageDoc> arrayListSignatureDoc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stamp_signature_signature",
            joinColumns = @JoinColumn(name = "signature_id"),
            inverseJoinColumns = @JoinColumn(name = "stamp_signature_id"))
    private List<StampsEndSignatures> stampsEndSignaturesList;

    public Signature() {
    }

    public List<StampsEndSignatures> getStampsEndSignaturesList() {
        return stampsEndSignaturesList;
    }

    public void setStampsEndSignaturesList(List<StampsEndSignatures> stampsEndSignaturesList) {
        this.stampsEndSignaturesList = stampsEndSignaturesList;
    }

    public int getIdSignature() {
        return idSignature;
    }

    public void setIdSignature(int idSignature) {
        this.idSignature = idSignature;
    }

    public List<ImageDoc> getArrayListSignatureDoc() {
        return arrayListSignatureDoc;
    }

    public void setArrayListSignatureDoc(List<ImageDoc> arrayListSignatureDoc) {
        this.arrayListSignatureDoc = arrayListSignatureDoc;
    }

    @Override
    public String toString() {
        return "Signature{" +
                "idSignature=" + idSignature +
                '}' + "\n";
    }
}
