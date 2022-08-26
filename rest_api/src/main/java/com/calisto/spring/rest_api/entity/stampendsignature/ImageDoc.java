package com.calisto.spring.rest_api.entity.stampendsignature;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.util.List;

// добавляем данные по печати
@Entity
@Table(name = "image_doc_table")
public class ImageDoc {

    // ид документа
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idImageDoc;

    // адрес печати
    @Column(name = "address")
    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "signature_image",
            joinColumns = @JoinColumn(name = "doc_image_id"),
            inverseJoinColumns = @JoinColumn(name = "signature_id"))
    private List<Signature> signatureList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stamp_image",
            joinColumns = @JoinColumn(name = "doc_image_id"),
            inverseJoinColumns = @JoinColumn(name = "stamp_id"))
    private List<Stamp> stampList;

    public ImageDoc() {
    }

    public List<Signature> getSignatureList() {
        return signatureList;
    }

    public void setSignatureList(List<Signature> signatureList) {
        this.signatureList = signatureList;
    }

    public List<Stamp> getStampList() {
        return stampList;
    }

    public void setStampList(List<Stamp> stampList) {
        this.stampList = stampList;
    }

    public int getIdImageDoc() {
        return idImageDoc;
    }

    public void setIdImageDoc(int idImageDoc) {
        this.idImageDoc = idImageDoc;
    }

    public ImageDoc(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // метод позволяет преобразоваить файл в объект для работы в itext без размера
    public Image giveImage(){
        Image result = null;
        ImageData imageData = null;
        try {
            imageData = ImageDataFactory.create(address);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        result = new Image(imageData);
        return result;
    }

    // метод позволяет преобразовать файл для работы в itext
    // плюс реализуем изменение размеров в программе
    public Image giveImage (float fitWidth, float fitHeight){
        Image result = null;
        ImageData imageData = null;
        try {
            imageData = ImageDataFactory.create(address);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        result = new Image(imageData);
        result.scaleAbsolute(fitWidth,fitHeight);
        return result;
    }

    @Override
    public String toString() {
        return "ImageDoc{" +
                "idImageDoc=" + idImageDoc +
                ", address='" + address + '\'' +
                '}' + "\n";
    }
}
