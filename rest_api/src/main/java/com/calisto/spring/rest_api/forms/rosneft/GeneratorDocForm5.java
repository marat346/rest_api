package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Employee;
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


import java.io.FileNotFoundException;

// формируем сведения по кадровым ресурсам
public class GeneratorDocForm5 {
    public void launch(Company company, String address, Tender tender) {
        try {
            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            // краткое название компании с ковычками
            String fullSizeNameCompany =  company.getSmallNameCompany();

            // добавляем информацию о участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "СВЕДЕНИЯ О КАДРОВЫХ РЕСУРСАХ\n";

            // добавляем таблицу с списком сотрудников, общее количество
            // надо потом реализовать цыкл с выдачей всех работников компании

            // итоговое количество сотрудников
            int countSummEmpl = 0;

            // итоговое количество сотрудников для привлечения к работе
            int countSummEmplWork = 0;

            Table table = new Table(5);
            Cell cell = new Cell()
                    .add("№\n" +
                            "п/п")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Наименование показателей")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Кол-во человек, подразделения")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Место нахождения")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            cell = new Cell()
                    .add("Количество человек, " +
                            "которые Участник закупки собирается " +
                            "использовать при выполнении Договора")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);

            for (int i = 1; i < 6; i++) {
                cell = new Cell()
                        .add("" + i + "\n")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
            }

            // необходимо реализовать цыкл и сборку данных по должностям. конкретно. можно попробывать всех работников
            // здесь надо реализовать выдачу всех данных по кадрам
//            int i = 1;
//            for (int num = 0; num<company.getDepartmentsCompany().get(0).getArrayListDepartments().size();num++){
//                Department department = company.getDepartmentsCompany().get(0).getArrayListDepartments().get(num);
//
//                // добавляем порядковый номер в таблице
//                cell = new Cell()
//                        .add(i +"")
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
//                // добавляем название депортамента/отдела
//                cell = new Cell()
//                        .add(department.getName())
//                        .setFont(font)
//                        .setFontSize(8)
//                        .setTextAlignment(TextAlignment.CENTER)
//                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
//                table.addCell(cell);
//
                // добавляем кол-во людей
                int countEmpl = company.getEmployeeList().size();
//

                countSummEmpl = countSummEmpl+countEmpl;

                cell = new Cell()
                        .add(countEmpl + "")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // добавляем место нахождение отдела
                cell = new Cell()
                        .add(company.getAddressCompany())
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                // добавляем количество человек которое участник собирается использовать
                countSummEmplWork = countSummEmplWork + countEmpl;
                cell = new Cell()
                        .add(countEmpl + "")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);


                cell = new Cell()
                        .add("/")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                cell = new Cell()
                        .add("ВСЕГО")
                        .setFont(font)
                        .setBold()
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                cell = new Cell()
                        .add(countSummEmpl + "")
                        .setFont(font)
                        .setBold()
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                cell = new Cell()
                        .add("\n")
                        .setFont(font)
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                cell = new Cell()
                        .add(countSummEmplWork + "")
                        .setFont(font)
                        .setBold()
                        .setFontSize(8)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);


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

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }
