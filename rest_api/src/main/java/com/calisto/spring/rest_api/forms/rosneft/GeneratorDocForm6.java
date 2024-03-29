package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;
import java.text.SimpleDateFormat;

// создаём документ подтверждения согласия физического лица на обработку персональных
// данных
public class GeneratorDocForm6 {
    public void launch(Company company, String address, Tender tender, String date) {


        try {
            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy");

            // добавляем название файла
            String nameDoc =
                    "ПОДТВЕРЖДЕНИЕ СОГЛАСИЯ ФИЗИЧЕСКОГО ЛИЦА НА ОБРАБОТКУ ПЕРСОНАЛЬНЫХ ДАННЫХ";

            // добавляем данные на физ лицо (руководителя)
            String reqEmplCompany =
                    "Настоящим " +
                            company.getEmployeeList().get(0).giveFullName() +",\n" +
                            "основной документ, удостоверяющий личность: паспорт " +
                            company.getEmployeeList().get(0).getPassportSerial() + " " +
                            company.getEmployeeList().get(0).getPassportNumber() + " выдан " +
                            company.getEmployeeList().get(0).getPassportGovName() + " дата выдачи " +
                            sf.format(company.getEmployeeList().get(0).getPassportGovDate()) + " года,\n" +
                            "адрес регистрации: " +
                            company.getEmployeeList().get(0).getAddressReg() +",\n" +
                            "дата рождения: " +
                            sf.format(company.getEmployeeList().get(0).getHeppyDate()) + " года,\n" +
                            "ИНН " +
                            company.getEmployeeList().get(0).getInn() + ".\n";

            String bodyTextDoc1 =
                    "в соответствии с Федеральным законом от 27.07.2006 г. № 152-ФЗ «О персональных данных» " +
                            "(далее – Закон 152-ФЗ), подтверждает свое согласие на передачу и обработку " +
                            "персональных данных в целях прохождения процедур, необходимых для участия в " +
                            "квалификации /процедурах закупок/включения в отчет о проведении процедур закупок " +
                            "в соответствии с Положением Компании «О закупке товаров, работ, услуг».\n" +
                            "Оператор, получающий настоящее согласие: " +
                            // название организатора закупки
                            // необходимо реализовать получение названия организации
//                            tender.getCompany().get(0).getSmallNameFormCompany() + " \"" +
//                            tender.getCompany().get(0).getSmallNameCompany() + "\"" +
                            ", зарегистрирован по адресу: " +
                            // юр адрес
//                            tender.getCompany().get(0).getAddressCompany() + "\n" +
                            "Настоящее согласие дано в отношении всех сведений, указанных в передаваемых " +
                            "мною в адрес " +
                            // название организатора закупки
//                            tender.getCompany().get(0).getSmallNameFormCompany() + " \"" +
//                            tender.getCompany().get(0).getSmallNameCompany() + "\" " +
                            "документах, в том числе (если применимо): фамилия, имя, отчество, дата и место " +
                            "рождения; паспортные данные; сведения об образовании (с указанием учебных заведений); " +
                            "сведения о трудовой деятельности с указанием наименования организации и занимаемой " +
                            "должности (в том числе по совместительству); сведения об участии (членстве) в " +
                            "органах управления иных юридических лиц; биографические данные, фотография, " +
                            "контактная информация, собственноручная подпись, иные персональные данные, " +
                            "упомянутые в любом заполняемом в вышеуказанных целях документе.\n" +
                            "Перечень действий с персональными данными, в отношении которых дано согласие, " +
                            "включает: обработку (включая сбор, систематизацию, накопление, хранение, " +
                            "уточнение (обновление, изменение), использование, обезличивание, блокирование, " +
                            "уничтожение персональных данных), при этом общее описание вышеуказанных способов " +
                            "обработки данных приведено в Законе 152-ФЗ, а также на передачу такой информации " +
                            "третьим лицам, в случаях, установленных действующим законодательством, и в случаях, " +
                            "когда " +
                            // название организатора закупки
//                            tender.getCompany().get(0).getSmallNameFormCompany() + " \"" +
//                            tender.getCompany().get(0).getSmallNameCompany() + "\" " +
                            " выступает " +
                            "для третьих лиц, которым передаются персональные данные, Организатором закупки.\n" +
                            "Условием прекращения обработки персональных данных является получение " +
                            // название организатора закупки
//                            tender.getCompany().get(0).getSmallNameFormCompany() + " \"" +
//                            tender.getCompany().get(0).getSmallNameCompany() + "\" " +
                            " письменного " +
                            "уведомления об отзыве согласия на обработку персональных данных.\n" +
                            "Настоящее согласие действует в течение 10 лет со дня его подписания. \n" +
                            "Подтверждаю, что ознакомлен (а) с положениями Федерального закона от 27.07.2006 " +
                            "№152-ФЗ «О персональных данных», права и обязанности в области защиты персональных " +
                            "данных мне понятны.\n";

            // добавляем подписантов это физ лицо!
            // должно быть (дата, подпись, фио)
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table = tableStampEndSignature.createTableSignature(company,font,date);


            PdfWriter pdfWriter = new PdfWriter(address);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем название документа
            Paragraph paragraphNameDoc = new Paragraph(nameDoc)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(paragraphNameDoc);

            // добавляем реквизиты физ лица
            Paragraph paragraphReqCom = new Paragraph(reqEmplCompany)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphReqCom);

            // добавляем текст после реквизитов
            Paragraph paragraphBodyTextDoc1 = new Paragraph(bodyTextDoc1)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphBodyTextDoc1);

            // добавляем подписанта
            document.add(table);
            document.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
