package com.calisto.spring.rest_api.entity.stampendsignature;

import com.calisto.spring.rest_api.entity.company.StampsEndSignatures;

import javax.persistence.*;
import java.util.List;

// содержит информацию о печатях
@Entity
@Table(name = "stamp_table")
public class Stamp {
    //ид штампа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idStamp;

    //список изображений печати
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stamp_image",
            joinColumns = @JoinColumn(name = "stamp_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_image_id"))
    private List<ImageDoc> arrayListStampDoc;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stamp_signature_stamp",
            joinColumns = @JoinColumn(name = "stamp_id"),
            inverseJoinColumns = @JoinColumn(name = "stamp_signature_id"))
    private List<StampsEndSignatures> stampsEndSignaturesList;

    public Stamp() {
    }

    public List<StampsEndSignatures> getStampsEndSignaturesList() {
        return stampsEndSignaturesList;
    }

    public void setStampsEndSignaturesList(List<StampsEndSignatures> stampsEndSignaturesList) {
        this.stampsEndSignaturesList = stampsEndSignaturesList;
    }

    public int getIdStamp() {
        return idStamp;
    }

    public void setIdStamp(int idStamp) {
        this.idStamp = idStamp;
    }

    public List<ImageDoc> getArrayListStampDoc() {
        return arrayListStampDoc;
    }

    public void setArrayListStampDoc(List<ImageDoc> arrayListStampDoc) {
        this.arrayListStampDoc = arrayListStampDoc;
    }

    @Override
    public String toString() {
        return "Stamp{" +
                "idStamp=" + idStamp +
                '}' + "\n";
    }
}
