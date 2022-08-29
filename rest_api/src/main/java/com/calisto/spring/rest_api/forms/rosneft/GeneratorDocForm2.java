package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.Company;
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

import java.io.IOException;
import java.text.SimpleDateFormat;

// информация о собственниках (акционерах компании)
public class GeneratorDocForm2 {
    public void launch(Company company, String address, Tender tender, String textDate) {

        try {
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            String fullSizeNameCompany = company.getSmallNameCompany();

            // добавляем полное название компании в шапку файла
            String topFullNameFileDocCompany = company.getFullNameFormCompany() + "\n" + "\"" +
                    company.getFullNameCompany() + "\"";

            // добавляем реквизиты компании в шапку файла
            String requisitesCompany = "Юридический адрес: " + company.getAddressCompany() + ";\n" +
                    "Почтовый адрес: " + company.getMailAddressCompany() + ";\n" +
                    "ИНН/КПП: " + company.getInnCompany() + "/" +
                    company.getKppCompany() + "; " +
                    "ОГРН: " + company.getRegistrationNumberCompany() + ";\n" +
                    "Банковские реквизиты: " + company.getNameFormBank() + " " +
                    company.getNameBank() + ";\n" +
                    "Бик: " + company.getBankNumber() + ";" + " " +
                    "р/с: " + company.getCheckingAccountBank() + ";" + " " +
                    "к/с: " + company.getCorrespondentAccountBank() + ";\n" +
                    "E-mail: " + company.getEmailCompany() + ";" + " " +
                    "Телефон: " + company.getTelephoneCompany() + ".";

            // добавляем разделительную линию
            String line = "________________________________________________________________________" +
                    "\n";

            // добавляем информацию о участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "ИНФОРМАЦИЯ О СОБСТВЕННИКАХ (АКЦИОНЕРАХ)" +
                    fullSizeNameCompany +
                    "УЧАСТНИКА ЗАКУПКИ НА ВЫПОЛНЕНИЕ РАБОТ ДЛЯ ПАО \"НК \" РОСНЕФТЬ\" И " +
                    "ОБЩЕСТВ ГРУППЫ С УКАЗАНИЕМ ВСЕЙ ЦЕПОЧКИ СОБСТВЕННИКОВ, ВКЛЮЧАЯ " +
                    "БЕНЕФЕЦИАРОВ (В ТОМ ЧИСЛЕ КОНЕЧНЫХ)).\n";

            // добавляем текст после названия текста до таблицы (с указанием даты)
            String bodyDocText1 =
                    "по состоянию на " +
                            // тут надо добавить актуальную дату
                            // пока поставим по умолчанию
                            textDate +
                            ".\n";

            // таблица с информацией о собственниках
            // нужны данные физ лица или компаний собственников
            // нужны данные с бухгалтерии с информацией по долям
            Table table = new Table(3);
            Cell cell = new Cell()
                    .add("Наименование организации\n" +
                            "(наименование, место\n" +
                            "нахождения, ИНН")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table.addCell(cell);

            cell = new Cell()
                    .add("Собственники (акционеры)\n" +
                            "организации, с указанием доли в %\n" +
                            "(наименование, место нахождения\n" +
                            "(страна), ИНН")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table.addCell(cell);

            cell = new Cell()
                    .add("Подтверждающие\n" +
                            "документы, наименование,\n" +
                            "реквизиты, паспортные данные\n" +
                            "(в т.ч. гражданство)")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table.addCell(cell);

            cell = new Cell(1, 3)
                    .add("I. Организация-Участник закупки")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(8)
                    .setBold();
            table.addCell(cell);

            // далее добавляем информацию о собственниках главной
            // в идеале надо сделать цикл для списка собственников
            // по умолчанию стоит 1 собственник, он же директор
            // пока не реализуем. надо подумать на логикой реализации
            int numberMenCompanySobstveniki = 1;
            for (int i = numberMenCompanySobstveniki; i < 2; i++) {
                cell = new Cell()
                        .add(fullSizeNameCompany +
                                company.getAddressCompany() + ", " +
                                company.getInnCompany())
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8);
                table.addCell(cell);

                cell = new Cell()
                        .add(company.getEmployeeList().get(0).giveFullName() + ", " +
                                company.getEmployeeList().get(0)
                                        .getAddressReg() + ", " +
                                company.getEmployeeList().get(0).getInn())
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8);
                table.addCell(cell);

                // реализуем новую форму даты (сделать отдельно класс)
                SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy");

                cell = new Cell()
                        .add("паспорт " + company.getEmployeeList().get(0)
                                .getPassportSerial() + " " +
                                company.getEmployeeList().get(0)
                                        .getPassportNumber() + ", выдан " +
                                company.getEmployeeList().get(0).getPassportGovName() + ", дата выдачи " +
                                sf.format(company.getEmployeeList().get(0).getPassportGovDate())
                                + ", дата рождения " +
                                sf.format(company.getEmployeeList().get(0).getHeppyDate()) + ", гражданство " +
                                company.getEmployeeList().get(0).getGovermentStatus() + ".")
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8);
                table.addCell(cell);
            }

            cell = new Cell(1, 3)
                    .add("II. Юридические лица, являющиеся собственниками организации" +
                            " - Участника закупки.")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(8)
                    .setBold();
            table.addCell(cell);

            for (int i = 0; i < 3; i++) {
                cell = new Cell()
                        .add("\n")
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8)
                        .setBold();
                table.addCell(cell);
            }

            cell = new Cell(1, 3)
                    .add("III. Юридические лица, являющиеся собственниками собственников" +
                            " организации - Участника закупки.")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(8)
                    .setBold();
            table.addCell(cell);

            for (int i = 0; i < 3; i++) {
                cell = new Cell()
                        .add("\n")
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8);
                table.addCell(cell);
            }

            cell = new Cell(1, 3)
                    .add("IV. Юридические лица, являющиеся собственниками " +
                            "следующих уровней (до конечных) ...")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(8)
                    .setBold();
            table.addCell(cell);

            for (int i = 0; i < 3; i++) {
                cell = new Cell()
                        .add("\n")
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8);
                table.addCell(cell);
            }

            // далее идёт название следующей таблицы

            String nameDocTextTable2 =
                    "СВЕДЕНИЯ ОБ АФФИЛИРОВАННЫХ/ВХОДЯЩИХ В " +
                            "ГРУППУ ЛИЦАХ";

            // далее идёт таблица с информацией
            // по умолчанию заполняем Аффилированные и/или входящие
            // в группу лица отсутствуют

            Table table1 = new Table(7);
            cell = new Cell()
                    .add("№\n п/п")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table1.addCell(cell);

            cell = new Cell()
                    .add("Полное фирменное\n" +
                            "наименование\n" +
                            "(наименование для\n" +
                            "некоммерческой\n" +
                            "организации) или\n" +
                            "фамилия, имя,\n" +
                            "отчество\n" +
                            "аффилированного\n" +
                            "/входящего в группу\n" +
                            "лица")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table1.addCell(cell);

            cell = new Cell()
                    .add("Место нахождения\n" +
                            "юридического\n" +
                            "лица или место\n" +
                            "жительства\n" +
                            "физического лица\n" +
                            "(указывается только\n" +
                            "с согласия\n" +
                            "физического лица)")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table1.addCell(cell);

            cell = new Cell()
                    .add("Основание\n" +
                            " (основания), в\n" +
                            "силу которого\n" +
                            "лицо признается\n" +
                            "аффилированным\n" +
                            "/входящим в \n" +
                            "группу")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table1.addCell(cell);

            cell = new Cell()
                    .add("Дата\n" +
                            "наступления\n" +
                            "основания\n" +
                            "(оснований)")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table1.addCell(cell);

            cell = new Cell()
                    .add("Способ и\n" +
                            "доля участия\n" +
                            "аффилированного\n" +
                            "/входящего\n" +
                            "в группу\n" +
                            "лица")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table1.addCell(cell);

            // если есть аффилированность то заполняем эту часть таблицы
            // по умолчанию "Аффилированные и/или входящие в группу лица отсутствуют"
            for (int i = 0; i < 8; i++) {
                cell = new Cell()
                        .add("Аффилированные и/или входящие в группу лица отсутствуют")
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8);
                table1.addCell(cell);
            }

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table2 = tableStampEndSignature.createTableStampEndSignature(company, font);

            PdfWriter pdfWriter = new PdfWriter(address);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем название компании в шапке
            Paragraph paragraphTopNameCompany = new Paragraph(topFullNameFileDocCompany);
            paragraphTopNameCompany.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(12);
            document.add(paragraphTopNameCompany);

            // добавляем реквизиты компании в шапке
            Paragraph paragraphReqCom = new Paragraph(requisitesCompany);
            paragraphReqCom.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10);
            document.add(paragraphReqCom);

            // добавляем разделительную линию
            Paragraph paragraphLine = new Paragraph(line)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine);

            // добавляем инфу об участнике и название закупки
            Paragraph paragraphtopInfoCompany = new Paragraph(topInfoCompanyEndTender);
            paragraphtopInfoCompany.setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(10);
            document.add(paragraphtopInfoCompany);
            document.add(inP);

            // добавляем название документа
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany);
            paragraphNameDoc.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphNameDoc);
            document.add(inP);

            // добавляем текстовое тело документа до таблицы
            Paragraph paragraphBodyDocText1 = new Paragraph(bodyDocText1);
            paragraphBodyDocText1.setFont(font)
                    .setFontSize(10);

            // добавляем таблицу с информацией о собственниках
            document.add(table);
            document.add(inP);

            // добавляем текстовое тело документа после таблицы 1 до таблицы 2
            // простой заголовок
            Paragraph paragraphNameDocText2 = new Paragraph(nameDocTextTable2);
            paragraphNameDocText2.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphNameDocText2);
            document.add(inP);

            // добавляем таблицу с аффилированностью
            document.add(table1);
            document.add(inP);

            // добавляем подписантов
            document.add(table2);

            // закрываем документ
            document.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
