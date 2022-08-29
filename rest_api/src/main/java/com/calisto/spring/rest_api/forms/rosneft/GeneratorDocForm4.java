package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Oborudovanie;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

// создаём сведения о материально-технических ресурсах
public class GeneratorDocForm4 {
    public void launch (Company company, String address, Tender tender) {
        try {
            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            // краткое название компании с ковычками
            String fullSizeNameCompany = company.getSmallNameCompany();

            // добавляем информацию о участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "СВЕДЕНИЯ О МАТЕРИАЛЬНО-ТЕХНИЧЕСКИХ РЕСУРСАХ\n";

            // добавляем таблицу с мтр
            // надо потом реализовать цыкл с выдачей всех ресурсов компании(оборудования
            // и прочего)
            SimpleDateFormat sf = new SimpleDateFormat("yyyy");

            Table table = new Table(8);
            Cell cell = new Cell()
                    .add("№\n" +
                            "п/п")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Наименование")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Производитель, страна\n" +
                            "производства, марка,\n" +
                            "модель, основные\n" +
                            "технические\n" +
                            "характеристики")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Год\n" +
                            "выпуска")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("%\n" +
                            "аморт\n" +
                            "изаци\n" +
                            "и")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Принадлежность\n" +
                            "(собственность,\n" +
                            "арендованный)")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Кол-во\n" +
                            "единиц")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Примеча\n" +
                            "ния")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            for (int b = 1; b < 9; b++){
                cell = new Cell()
                        .add(b + "\n")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
            }


            // реализуем механизм добавления техники в таблицу

            List<Oborudovanie> arrayListTransport = company.getOborudovanieList();
//            List<OborudovanieDoc> arrayListOborudovanie = company.getOborudovanieInfoDoc().get(0).getArrayListOborudovatieDoc();

            int i = 1;
            for (int a = 0; a < arrayListTransport.size(); a++) {
                Oborudovanie transportDoc = arrayListTransport.get(a);

                // порядковый номер
                cell = new Cell()
                        .add("" + i + "\n")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // Наименование
                cell = new Cell()
                        .add(transportDoc.getName())
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // Производитель, страна производства, марка, модель, основные тех
                // характеристики
                cell = new Cell()
                        .add(transportDoc.getModel())
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // Год выпуска
                cell = new Cell()
                        .add(sf.format(transportDoc.getDate()))
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // % амортизации
                // нужна ли амортизация неизвестно
                cell = new Cell()
                        .add(" ")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // Принадлежность (собственность, арендованный)
                String statusArend = "собственность";
                if (transportDoc.getStatus().equals("арендованный")){
                    statusArend = "арендованный";
                }

                cell = new Cell()
                        .add(statusArend)
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // Кол-во единиц
                cell = new Cell()
                        .add("1")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // Примечание
                // обычно взрывозащищённое или нет
                cell = new Cell()
                        .add(transportDoc.getPs())
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                i++;
            }



            // убираем пока отдельно добавление информации по оборудованию
//            for (int a = 0; a < arrayListTransport.size(); a++){
//                Oborudovanie oborudovanieDoc = arrayListTransport.get(a);
//                // порядковый номер
//                cell = new Cell()
//                        .add("" + i + "\n")
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // Наименование
//                cell = new Cell()
//                        .add(oborudovanieDoc.getNameVidOborudovania())
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // Производитель, старана производства, марка, модель, основные тех
//                // характеристики
//                cell = new Cell()
//                        .add(oborudovanieDoc.getMadeInContry() + ", " +
//                                oborudovanieDoc.getNameModel() + ", " +
//                                oborudovanieDoc.getNameOborudovanie())
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // Год выпуска
//                cell = new Cell()
//                        .add(sf.format(oborudovanieDoc.getData()))
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // % амортизации
//                cell = new Cell()
//                        .add(oborudovanieDoc.getProcentAmmortizacii())
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // Принадлежность (собственность, арендованный)
//                String statusArend = "собственность";
//                if (oborudovanieDoc.isStatusArenda()){
//                    statusArend = "арендованный";
//                }
//
//                cell = new Cell()
//                        .add(statusArend)
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // Кол-во единиц
//                cell = new Cell()
//                        .add("1")
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // Примечание
//                // обычно взрывозащищённое или нет
//                cell = new Cell()
//                        .add(oborudovanieDoc.getPs())
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//                i++;
//            }


            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table2 = tableStampEndSignature.createTableStampEndSignature(company,font);

            PdfWriter pdfWriter = new PdfWriter(address);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем информацию о закупки
            Paragraph paragraphTopInfo = new Paragraph(topInfoCompanyEndTender)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(10);
            document.add(paragraphTopInfo);
            document.add(inP);

            // добавляем информацию о названии документа
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphNameDoc);
            document.add(inP);

            // добавляем таблицу по МТР
            document.add(table);
            document.add(inP);

            // добавляем подписанта
            document.add(table2);
            document.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
