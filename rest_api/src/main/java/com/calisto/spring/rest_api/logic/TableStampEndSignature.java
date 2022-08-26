package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.entity.company.Company;
import com.calisto.spring.rest_api.entity.stampendsignature.ImageDoc;
import com.itextpdf.kernel.color.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.GrooveBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

// формируем участок кода для добавления в itext таблицы
// получаем компанию и вид шрифта
// далее берём случайную печать и подпись со списка документов
// далее добавляем печать и подпись в документ
// в данном случае создаём таблицу без видимых бортов
public class TableStampEndSignature {
    public Table createTableStampEndSignature(Company company, PdfFont font){
        //результат
        Table result = null;

        //достаём случайное число
        int i = (int)(Math.random() * company.getStampsEndSignatures().get(0).getStamp().get(0).getArrayListStampDoc().size());
        int b = (int)(Math.random() * company.getStampsEndSignatures().get(0).getSignature().get(0).getArrayListSignatureDoc().size());

        // печать
        ImageDoc stamp = company.getStampsEndSignatures().get(0).getStamp().get(0).getArrayListStampDoc().get(i);

        // подпись
        ImageDoc signature = company.getStampsEndSignatures().get(0).getSignature().get(0).getArrayListSignatureDoc().get(b);

        // добавляем подписанта документа
        Border border = new GrooveBorder(new DeviceGray(10),0);

        // добавляем подписанта
        String visaDocCompany =
                company.
                        getSupervisorCompany()
                        .get(0)
                        .getPositionCom() +
                        " \n" +
                        company.
                                getSmallNameFormCompany() +" " +
                        "\""+
                        company.getSmallNameCompany() + "\"" + "         ";
        String nameVisaDocCompany =

                "                                  " +
                        company.getSupervisorCompany()
                                .get(0)
                                .giveFullName() + ".";


        Table table = new Table(4);
        Cell cell = new Cell()
                .setBorder(border)
                .add(visaDocCompany)
                .setFont(font)
                .setTextAlignment(TextAlignment.CENTER);

        table.addCell(cell);
        cell = new Cell()
                .setBorder(border)
                .add(stamp.giveImage(100,100));
        table.addCell(cell);

        cell = new Cell()
                .setBorder(border)
                .add(signature.giveImage(50,45))
                .setRelativePosition(110,0,0,0);
        table.addCell(cell);

        cell = new Cell()
                .setBorder(border)
                .add(nameVisaDocCompany)
                .setFont(font)
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.TOP);
        table.addCell(cell);

        result = table;

        return result;
    }

    public Table createTableSignature(Company company, PdfFont font, String date){
        //результат
        Table result = null;

        //достаём случайное число
        int b = (int)(Math.random() * company.getStampsEndSignatures().get(0).getSignature().get(0).getArrayListSignatureDoc().size());

        // подпись
        ImageDoc signature = company.getStampsEndSignatures().get(0).getSignature().get(0).getArrayListSignatureDoc().get(b);

        // добавляем подписанта документа
        Border border = new GrooveBorder(new DeviceGray(10),0);

        // добавляем подписанта
        String visaDocCompany =
                company.
                        getSupervisorCompany()
                        .get(0)
                        .getPositionCom() +
                        " \n" +
                        company.
                                getSmallNameFormCompany() +" " +
                        "\""+
                        company.getSmallNameCompany() + "\"" + "         ";
        String nameVisaDocCompany =

                "                                  " +
                        company.getSupervisorCompany()
                                .get(0)
                                .giveFullName() + ".";


        Table table = new Table(3);
        Cell cell = new Cell()
                .setBorder(border)
                .add(date)
                .setFont(font)
                .setTextAlignment(TextAlignment.LEFT)
                .setVerticalAlignment(VerticalAlignment.BOTTOM);
        table.addCell(cell);

        cell = new Cell()
                .setBorder(border)
                .add(signature.giveImage(50,45));
        table.addCell(cell);

        cell = new Cell()
                .setBorder(border)
                .add(company.getSupervisorCompany().get(0).giveFullName() + ".")
                .setFont(font)
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.BOTTOM);
        table.addCell(cell);

        result = table;

        return result;
    }
}
