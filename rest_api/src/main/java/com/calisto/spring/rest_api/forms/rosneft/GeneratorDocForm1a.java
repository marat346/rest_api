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

public class GeneratorDocForm1a {
    public void launch(Company company, String address, Tender tender){


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
            String nameDocCompany = "СВЕДЕНИЯ ОБ УЧАСТНИКЕ ЗАКУПКИ\n";

            // добавляем 1 блок тела документа!до таблицы!
            String bodyTextDoc1 = "Изучив Извещение и Документацию о закупке, " +
                    "размещённое на сайте ПАО \" НК \" Роснефть\" (при проведении закупки в " +
                    "интересах Заказчиков, не подпадающих под действие Закона 223-ФЗ, " +
                    "и принимая установленные в них требования и условия закупки, настоящим " +
                    "подаём заявку на участие в указанной процедуре закупки и сообщаем о " +
                    "себе следующие сведения: \n" +
                    "1. Наименование организации: " +
                    fullSizeNameCompany + ".\n" +
                    "2. Прежнее название организации, если менялось: нет";

            // добавляем таблицу прежних названий организации !!!(пока не реализуем)!!!
            float[] tableWidths = {30f, 130f, 230f, 120f};
            Table table = new Table(tableWidths);

            Cell cell = new Cell()
                    .add(" ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell()
                    .add("Дата регистрации")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell()
                    .add("Наименование")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell()
                    .add("Примечание")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell()
                    .add("1")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            int i;
            for(i = 2; i<5; i++)
            {
                cell = new Cell()
                        .add(" ")
                        .setFont(font);
                table.addCell(cell);
            }

            // продолжаем писать 2 блок тела документа после таблицы
            // до следующей таблицы по годовым оборотам организации
            String bodyTextDoc2 =
                    "3. Руководитель организации: " +
                            company.getEmployeeList().get(0).getPositionCom() + ".\n" +
                    "4. Главный бухгалтер: " +
                            company.getEmployeeList().get(0).getPositionCom()  + ".\n" +
                    "5. Дата, место и орган регистрации, № свидетельства: " +
                            company.getDateRegistrationNumberGovDoc() + " №" +
                            company.getRegistrationNumberCompany() + ".\n" +
                    "6. ИНН: " +
                            company.getInnCompany() + "\n" +
                    "   КПП: " +
                            company.getKppCompany() + "\n" +
                    "   ОГРН: " +
                            company.getRegistrationNumberCompany() + "\n" +
                    "7. Адрес: \n " +
                    "         Юридический (место нахождения): " +
                            company.getAddressCompany() + "\n" +
                    "         Фактический (почтовый): " +
                            company.getMailAddressCompany() + "\n" +
                    "         Телефон: " +
                            company.getTelephoneCompany() + "\n" +
                    "         Факс: " +
                            "нету факса \n" +
                    "         Электронная почта: " +
                            company.getEmailCompany() + "\n" +
                    "         Официальный веб-сайт организации: " +
                            websiteStatus(company)
                             + "\n" +
                    "8. Уставный фонд (капитал): " +
                            company.getSumm() + "\n" +
                    "9. Информация о собственниках компании (в соответствии с Формой 2). \n" +
                    "10. Банковские реквизиты:\n" +
                    "         р/с " +
                    company.getCheckingAccountBank() + "\n" +
                    "         банк " +
                    company.getNameFormBank() + " " +
                    company.getNameBank() + "\n" +
                    "         город " +
                    company.getAddressBank() + "\n" +
                    "11. Годовые обороты организации за последние 3 года с учётом НДС ( в тыс." +
                            " рублей) и без учёта НДС (тыс. руб).\n";


            // дальше идёт таблица с оборотами за последние 3 года.
            Table table1 = new Table(5);

            Cell cell1 = new Cell()
                    .add(" ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add("2021г.,\n тыс.руб")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add("2020г.,\n тыс.руб.")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add("2019г.,\n тыс.руб")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add("Среднеговодой объём, \n тыс.руб.")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add("Годовые обороты\n всего, с учетом\n НДС тыс.руб.")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            // тут надо сделать в идеале цикл с добавлением информации из бухгалтерских данных
            cell1 = new Cell()
                    .add((String.format("%.2f",
                            (company.getBuhdocumentList().get(0).getOborotiDate() * 1.2))) + "\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add((String.format("%.2f",
                                    (company.getBuhdocumentList().get(1).getOborotiDate() * 1.2))) + "\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add((String.format("%.2f",
                                    (company.getBuhdocumentList().get(2).getOborotiDate() * 1.2))) + "\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add(
                            (String.format("%.2f",((company.getBuhdocumentList().get(0).getOborotiDate() * 1.2) +
                                    (company.getBuhdocumentList().get(1).getOborotiDate() * 1.2)+
                                    (company.getBuhdocumentList().get(2).getOborotiDate() * 1.2))/3)) + "\n"
                    )
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add("Годовые обороты\nвсего, без учета\nНДС тыс. руб.")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            // тут тоже делаем цикл полученные из бухгалтерии данных
            cell1 = new Cell()
                    .add((String.format("%.2f",(company.getBuhdocumentList().get(0).getOborotiDate()))) + "\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add((String.format("%.2f",(company.getBuhdocumentList().get(1).getOborotiDate()))) + "\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add((String.format("%.2f",(company.getBuhdocumentList().get(2).getOborotiDate()))) + "\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            cell1 = new Cell()
                    .add((String.format("%.2f",(
                            (company.getBuhdocumentList().get(0).getOborotiDate() +
                                    company.getBuhdocumentList().get(1).getOborotiDate() +
                                    company.getBuhdocumentList().get(2).getOborotiDate()))/3)) + "\n"
                    )
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell1);

            // начинаем 3 блок текста тела документа до таблицы сведений
            // о привлекаемых субподрядчиках
            // здесь необходимо доставать информацию из бухгалтерии

            String bodyTextDoc3 =
                    "12. Среднесписочная численность персонала " +
                            fullSizeNameCompany + " " +
                    "в текущем году " +
                            // добавляем количество сотрудников
                    company.getEmployeeList().size() + " " +
                    "человек. \n" +
                    "13. Сообщаем, что " +
                    fullSizeNameCompany + " " +
                    "на дату подачи заявки " +

                            // тут надо сделать выборку где указываем статус по СМП.
                            // реализовали в методе
                    smpStatusCompany(company) +
                            "\n" +

                            // тут надо делать выбор из нескольких вариантов один
                    "14. Сообщаем, что: " +
                    fullSizeNameCompany + " " +

                            // реализуем метод где выбираем правильный статус по аккредитации
                            companyDoDocumentStatus(company,tender) + "\n" +

                            // большой блок, надо брать информацию и выбирать необходимые варианты
                    "15. Сообщаем, что на дату подачи заявки: " +
                            "− балансовая стоимость активов " +
                            fullSizeNameCompany + " " +
                            " в соответствии с " +
                            "данными бухгалтерской отчетности за последний отчетный периода составляет " +
                            // надо реализовать получение данных из бухгалтерии
                            company.getAktivSumm() +
                            " тыс.рублей. " +
                            fullSizeNameCompany + " " +
                            " в соответствии" +
                            " с данными в информационной базе «Сведения о юридических лицах, имеющих задолженность " +
                            "по уплате налогов (более 1000 рублей) и/или не представивших налоговую отчетность " +
                            "более года»" +
                            // надо выбрать есть или нет недоимок по налогам
                            // по умолчанию нет
                            " не имеет" +
                            " недоимки по налогам, " +
                            "сборам, задолженности по иным обязательным платежам в бюджеты бюджетной системы РФ " +
                            "(за исключением сумм, на которые предоставлены отсрочка, рассрочка, инвестиционный " +
                            "налоговый кредит в соответствии с законодательством РФ о налогах и сборах, которые " +
                            "реструктурированы в соответствии с законодательством РФ, по которым имеется вступившее " +
                            "в законную силу решение суда о признании обязанности заявителя по уплате этих сумм " +
                            "исполненной или которые признаны безнадежными к взысканию в соответствии с " +
                            "законодательством РФ о налогах и сборах) за прошедший календарный год. " +
                            // если есть недоимки то указывается их размер
                            // по умолчанию недоимок нет.

                            "− " +
                            fullSizeNameCompany + " " +
                            // выбираем соответствует или нет
                            // по умолчанию соответствует
                            " соответствует " +
                            "требованиям, установленным согласно законодательству РФ к лицам, осуществляющим " +
                            "поставку товара, выполнение работы, оказание услуги, являющихся предметом закупки;\n" +
                            "− у " +
                            fullSizeNameCompany + " " +
                            // выбираем имеются ли ограничения или нет
                            // по умолчанию не имеются
                            "отсутствуют" +
                            " ограничения " +
                            "для участия в закупках, установленных законодательством РФ;\n" +
                            "− у " +
                            fullSizeNameCompany + " " +
                            // выбрать отсутствует ли конфликт интересов
                            // по умолчанию отсутствует
                            "отсутствует" +
                            " конфликт " +
                            "интересов с работниками Заказчика/Организатора закупки, членами коллегиальных " +
                            "органов управления, закупочных органов, уполномоченными лицами " +
                            "Заказчика/Организатора закупки;\n" +
                            "− у " +
                            fullSizeNameCompany + " " +
                            // выбираем имеются ли факты неправомерного уклонения от заключения договора
                            // по умолчанию не имеются
                            "отсутствуют " +
                            "факты неправомерного уклонения " +
                            fullSizeNameCompany + " " +
                            "от заключения договора по результатам процедур " +
                            "закупок для Обществ Группы, относящихся к Заказчикам второго типа, в " +
                            "течение последних 24 месяцев, предшествующих дате подачи заявки;\n" +
                            "− в течение последних 12 месяцев, предшествующих дате подачи заявки, " +
                            // выбрать есть ли отклонения по разным причинам
                            // по умолчанию отсутствуют
                            "отсутствуют" +
                            " факты отклонения " +
                            fullSizeNameCompany + " " +
                            "от участия в закупочных процедурах " +
                            "ПАО «НК «Роснефть» и/или Обществ Группы по следующим причинам:\n" +
                            "o обнаружение недостоверных сведений в заявке и/или уточнениях " +
                            "заявок, существенных для допуска " +
                            fullSizeNameCompany + " " +
                            "к процедуре закупки и/или установления его места в итогах ранжирования заявок;\n" +
                            "o наличие подкрепленного документами факта оказания давления " +
                            fullSizeNameCompany + " " +
                            " на представителей " +
                            "Заказчика/Организатора закупки с целью повлиять на результаты процедуры закупки.\n" +
                            "− в течение последних 24 месяцев, предшествующих дате подачи заявки, " +
                            // выбираем есть или нет факты расторжения договора
                            // по умолчанию нет
                            "отсутствуют факты расторжения Обществом Группы, " +
                            "относящимся к Заказчикам второго типа, договора с " +
                            fullSizeNameCompany + " " +
                            "по решению суда, вступившему в законную силу, либо в случае одностороннего отказа " +
                            "Заказчика любого типа от исполнения договора в связи с существенным нарушением " +
                            fullSizeNameCompany + " " +
                            "договора.\n" +
                            "16. Сообщаем, что на дату подачи заявки уровень устойчивости финансового состояния за " +
                            "актуальный отчетный период " +
                            fullSizeNameCompany + " " +
                            // далее выбираем соответствуем ли уровню
                            // по умолчанию соответствует
                            "соответствует" +
                            " уровню, установленному в извещении/документации о " +
                            "настоящей закупке;\n" +
                            "17. Сообщаем, что " +
                            fullSizeNameCompany + " " +
                            " на дату подачи заявки соответствует " +
                            "типовым квалификационным требованиям, предъявляемым по следующим видам продукции: " +
                            // далее надо указать по каким видам продукции прошли аккредитацию
                            // или какие виды работ предоставляете
                            // по умолчанию основной вид деятельности (но этот вопрос надо как то решить)
                            // добавили гетер который возвращает значение и из класса тендер
                            tender.getName() +
                            "\n" +
                            "18. Сообщаем, что " +
                            // выбираем в составе какой квалификационной части
                            // по умолчанию "настоящей заявки"
                            "в составе квалификационной части настоящей заявки" +
                            ", размещены документы, указанные " +
                            "в разделе 2 Блока 9 настоящего документа на последнюю отчетную дату " +
                            // далее надо взять данные с бухгалтерии
                            // по заполнено по умолчанию

                            "(1 квартал 2022год, 2021год, " +
                            "2020 год, 2019год )" +
                            ", необходимые для оценки уровня финансового состояния" +
                            " (раздел 2 Блока 9 настоящего документа).\n" +
                            "19. Сообщаем, что для оперативного уведомления по вопросам организационного" +
                            " характера и взаимодействия с ПАО «НК «Роснефть» нами уполномочен: " +
                            company.getEmployeeList().get(0).giveFullName() + " " +
                            company.getTelephoneCompany() + ".\n" +
                            "20. Филиалы " +
                            fullSizeNameCompany +
                            // необходимо при наличии указать фактические адреса филиалов
                            // по умолчанию нет
                            ": отсутствуют.\n" +
                            "21. Сведения о необходимости одобрения заключения сделки уполномоченными " +
                            "органами управления Участника закупки /Заказчика: отсутствуют.\n" +
                            "22. Сведения о привлекаемых субподрядчиках (соисполнителях): " +
                            // если есть субподрядчики то заполняем таблицу по ним
                            // иначе пишем что их нет
                            // по умолчанию нету
                            "Привлекаемые субподрядчики (соисполнители) отсутствуют.\n";

            // таблица сведений о субподрядчиках (соисполнителя)

            Table table2 = new Table(5);

            Cell cell2 = new Cell()
                    .add("№\n п/п")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add("Наименование привлекаемого субподрядчика (соисполнителя), ИНН")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add("Наименование выполняемых работ (иное)")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add("Объем выполнения работ\n" +
                            "(в % от общего объема выполняемых работ)\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add("Примечания\n" +
                            "(в т.ч. является ли субподрядчик (соисполнитель) субъектом МСП)\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            // доработать эту таблицу (эта фраза должна выводится в таблице на все столбцы в одной
            // строке
            cell2 = new Cell(1,5)
                    .add("Номер лота и наименование предмета Договора (лота): " +
                            // если есть субподрядчик, то указать по какому лоту
                            // по умолчанию пусто
                            " ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    ;
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add("1. ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add(" ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add(" ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add(" ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);

            cell2 = new Cell()
                    .add(" ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table2.addCell(cell2);


            // текст тела блока № 4 до таблицы наименование видов работ

            String bodytextDoc4 =
                    "Сообщаем, что на дату подачи заявки в отношении привлекаемых субподрядчиков (соисполнителей) " +
                            "отсутствует следующая информация:\n" +
                            "− о фактах их неправомерного уклонения от заключения договора по результатам процедур " +
                            "закупок для ПАО «НК «Роснефть» и/или Обществ Группы ПАО «НК «Роснефть» " +
                            "за последние 24 месяца;\n" +
                            "− о фактах их отклонения от участия в закупочных процедурах ПАО «НК «Роснефть» и/или " +
                            "Обществ Группы ПАО «НК «Роснефть» в соответствии с пп. «г», «д» п.10.6.1.16 Положения " +
                            "о закупке за последние 12 месяцев»;\n" +
                            "− о несоответствии их требованиям в рамках должной осмотрительности, установленным в " +
                            "Блоке 10 документации о закупке " +
                            // добавляем название тендера (без номера)
                            tender.getName() +
                            ";\n" +
                            "− о не приостановлении их деятельности; \n" +
                            "− об их ликвидации;\n" +
                            "− о вступившим в законную силу судебного решения о признании их несостоятельным " +
                            "(банкротом) и об открытии конкурсного производства.\n" +
                            "\n" +
                            "23. Наименование видов работ, на исполнение которых претендует Участник закупки:\n";


            // таблица (данные вносятся на основании данных о видах работ которые выполняем
            Table table3 = new Table(3);

            Cell cell3 = new Cell()
                    .add("Наименование видов работ по направлению деятельности")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table3.addCell(cell3);

            cell3 = new Cell()
                    .add("Код ОКПД2\n" +
                            "(при наличии)\n")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table3.addCell(cell3);

            cell3 = new Cell()
                    .add("Категория Участника закупки")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table3.addCell(cell3);

            cell3 = new Cell()
                    .add(tender.getName())
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table3.addCell(cell3);

            cell3 = new Cell()
                    .add(" ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table3.addCell(cell3);

            cell3 = new Cell()
                    // при привлечении субподрядчика должно автоматом заполняться что с субподрядом
                    .add("Исполнитель услуг (собственными силами)")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table3.addCell(cell3);

            // пошёл текст тела документа № 5
            // до раздела подписания

            String bodyTextDoc5 =
                    "24. Сообщаем, что готовы соблюдать все принципы, изложенные в Декларации " +
                            "ПАО «НК «Роснефть» в области соблюдения прав человека при взаимодействии " +
                            "с поставщиками товаров, работ, услуг, размещенной на сайте ПАО «НК " +
                            "«Роснефть» https://www.rosneft.ru/Development/Podhodi_k_sobljudeniju_prav_cheloveka/  " +
                            "в рамках исполнения заключаемых с ПАО «НК «Роснефть» и/или Обществами Группы договоров " +
                            "на поставку товаров, выполнение работ, оказание услуг, и распространить их на " +
                            "всех своих контрагентов и субподрядчиков по всей цепочке поставок.\n" +
                            "\n" +
                            "Подтверждаю, что ознакомлен (а) с Декларацией ПАО «НК «Роснефть» в области " +
                            "соблюдения прав человека при взаимодействии с поставщиками товаров, работ, услуг.\n" +
                            "\n" +
                            "25. Сообщаем, что готовы соблюдать требования стандартов " +
                            // не знаю зачем это, всегда по умолчанию писал Роснефть
                            "ПАО «НК «РОСНЕФТЬ», размещенных на сайте " +
                            "ПАО «НК «Роснефть» по адресу: http://zakupki.rosneft.ru и/или " +
                            "приложенных к проекту договора.\n" +
                            "\n" +
                            "26. Сообщаем о своем согласии, что в случае выбора победителем, " +
                            "обязуемся открыть счет в Банке «ВБРР» (АО) /ПАО «Дальневосточный " +
                            "банк» (в случае его отсутствия) и использовать его для осуществления взаиморасчетов.\n" +
                            "\n" +
                            "Подтверждаю, что ознакомлен (а) с действующим Положением Компании " +
                            "«О закупке товаров, работ, услуг», нормы мне понятны.\n" +
                            "\n" +
                            "1. Сообщаем о своем согласии, что в случае изменения представленных " +
                            "в данном документе сведений, обязуемся в течение 3-х рабочих дней " +
                            "письменно уведомить " +
                            // не знаю зачем, но всегда по умолчанию Роснефть
                            "«НК «РОСНЕФТЬ» о данных изменениях. \n" +
                            "\n" +
                            "Приложения:\n" +
                            // сюда надо добавить список всех созданных документов для этой закупки.
                            "(указать при наличии)\n";

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table4 = tableStampEndSignature.createTableStampEndSignature(company,font);

            PdfWriter pdfWriter = new PdfWriter(address);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            // создаём параграф и добавляем туда начало шапки документа
            // название формы организации + название самой организации
            Paragraph paragraphTopDoc = new Paragraph(topFullNameFileDocCompany);
            paragraphTopDoc.setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFont(font)
                    .setFontSize(12);
            document.add(paragraphTopDoc);

            // добавляем в шапку основные реквизиты
            Paragraph paragraphTopRek = new Paragraph(requisitesCompany);
            paragraphTopRek.setTextAlignment(TextAlignment.CENTER);
            paragraphTopRek.setFont(font)
                    .setFontSize(10);
            document.add(paragraphTopRek);

            // добавляем разграничивающую линию для отделения шапки от основной части документа
            Paragraph paragraphLine = new Paragraph(line);
            paragraphLine.setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine)
                    .setFont(font);

            // добавляем информацию об участнике, инн и номер торгов
            Paragraph paragraphInfoTenderInn = new Paragraph(topInfoCompanyEndTender);
            paragraphInfoTenderInn.setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphInfoTenderInn)
                    .setFont(font);

            // название бланка
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany);
            paragraphNameDoc.setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphNameDoc)
                    .setFont(font);

            // первая часть тела текста № 1 до первой таблицы
            Paragraph paragraphBodyText1 = new Paragraph(bodyTextDoc1);
            document.add(paragraphBodyText1)
                    .setFont(font);

            // добавляем первую таблицу
            document.add(table);

            // вторая часть тела текста № 2 до второй таблицы
            Paragraph paragraphBodyText2 = new Paragraph(bodyTextDoc2);
            document.add(paragraphBodyText2)
                    .setFont(font);

            // добавляем вторую таблицу
            document.add(table1);

            // третья часть тела текста № 3 до третьей таблицы
            Paragraph paragraphBodyText3 = new Paragraph(bodyTextDoc3);
            document.add(paragraphBodyText3
                    .setFont(font));

            // добавляем третью таблицу сведения о субподрядчиков
            document.add(table2);

            // четвёртая часть тела текста № 4 до четвёртой таблицы
            Paragraph paragraphBodyText4 = new Paragraph(bodytextDoc4);
            document.add(paragraphBodyText4
                    .setFont(font));

            // добавляем четвёртую таблицу о видах работ
            document.add(table3);

            // Пятая часть тела текста № 5 до подписантов
            Paragraph paragraphBodyText5 = new Paragraph(bodyTextDoc5);
            document.add(paragraphBodyText5
                    .setFont(font));

            // добавляем подписантов
            document.add(table4);
            document.close();

        }
            catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String websiteStatus(Company company) {
        String result = null;
        if (company.getWebSiteCompany()==null) {
            result = "отсутствует";
        }
        else {
            result = company.getWebSiteCompany();
        }
        return result;
    }

    // реализуем новую форму даты (сделать отдельно класс)
    SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy");

    // реализация метода для определения статуса по должной осмотрительности
    private String companyDoDocumentStatus(Company company,Tender tender) {
        String result = null;

        String numberAkkr = null;
        String date = null;
        String numeCompanyAkkr = "ЗАКАЗЧИК";
        // необходимо реализовать вызов данных по инн.
//        tender.getCompany().get(0).getSmallNameFormCompany() + " \"" +
//                tender.getCompany().get(0).getSmallNameCompany() +"\"";
//        for (int i = 0; i < company.getAkkredDocsCompany().get(0).getDocumentPdfDateInfoList().size(); i++){
//            DocumentPdfDateInfo doc = company.getAkkredDocsCompany().get(0).getDocumentPdfDateInfoList().get(i);
//            if (doc.getNameInfoCom().equals(numeCompanyAkkr)){
//                numberAkkr = doc.getNumberDoc();
//                date = sf.format(doc.getEndDate());
//            }
//        }

        // необходимо прописать проверку списка аккредитаций на соответствие инн и названию компании, так же
        // на проверку вхождения в группу компаний
//
//        switch (company.getAkkreditList()){
//            case 0:
//                result = "на дату подачи заявки не имеет действующей аккредитации " +
//                    "или подтверждения о соответствии требования в рамках должной " +
//                    "осмотрительности в " +
//                        tender.getCompany().get(0).getSmallNameFormCompany() + " " +
//                        "\"" + tender.getCompany().get(0).getSmallNameCompany() + "\" " +
//                    "и подаёт документы для проверки на соответствие данным требованиям в " +
//                    "составе настоящей заявки на закупку.";
//                break;
//            case 1:
//                result = "подавало документы в " +
//                        tender.getCompany().get(0).getSmallNameFormCompany() + " " +
//                        "\"" + tender.getCompany().get(0).getSmallNameCompany() + "\" " +
//                        "для проверки на соответствие требования в рамках" +
//                        " должной осмотрительности " +
//                        // необходимо создать генерацию пакета документов для прохождения аккредитации (ДО)
//                        "!!!РЕКВИЗИТЫ письма с документами для проверки!!!.";
//                break;
//            case 2:
//                result = "на дату подачи заявки соответствует требования в рамках" +
//                        " должной осмотрительности, что подтверждается №" +
//                        numberAkkr +
//                        " от " +
//                        date +
//                        " года" +
//                        " в том числе: \n" +
//                        "- с даты подтверждения соответствия требования в рамках должной" +
//                        " осмотрительности в сведения, ранее поданные для проверки на " +
//                        "соответствие данным требованиям " +
//
//                        // далее проверяем были ли внесены изменения (по умолчанию не были)
//                        "не были внесены изменения. \n" +
//                        "- деятельность " +
//                        company.getSmallNameFormCompany() + " " +
//                        "\"" +
//                        company.getSmallNameCompany() +"\"" + " " +
//
//                        // далее проверяем были ли приостановлена деятельность
//                        // смысл этого я не понимаю но всётки же
//                        // по умолчанию не приостановлена
//                        "не приостановлена " +
//                        "в порядке установленном Кодексом РФ об административных правонарушениях;\n" +
//                        "- в отношении " +
//                        company.getSmallNameFormCompany() + " " +
//                        "\"" +
//                        company.getSmallNameCompany() +"\"" + " " +
//                        // далее проверяем идут ли процедуры банкротства
//                        // смысл этого я опять не понимаю
//                        // по умолчанию никаких проблем у нас нету
//                        "не проводится ликвидация, не было получено решение арбитражного суда " +
//                        "о признании " +
//                        company.getSmallNameFormCompany() + " " +
//                        "\"" +
//                        company.getSmallNameCompany() +"\"" + " " +
//                        "несостоятельным (банкротом) и об открытии конкурсного производства; \n" +
//                        "- у руководителя, членов коллегиального исполнительного органа или " +
//                        "главного бухгалтера " +
//                        company.getSmallNameFormCompany() + " " +
//                        "\"" +
//                        company.getSmallNameCompany() +"\"" + " " +
//                        // далее идёт выборка если или нету судимости у директор, или других
//                        // руководителей и главного бухгалтера судимости
//                        // по умолчанию поставим нету !НО! надо обязательно сделать эту выборку
//                        "отсутствует судимость за преступления в сфере экономики, " +
//                        "а так же в отношении указанных лиц " +
//                        "не применяется " +
//                        "наказание в виде лишения права занимать определённые должности " +
//                        "или заниматься определенной деятельностью, " +
//                        "которые связаны с поставкой товара, выполнением работы, оказанием услуги, " +
//                        "являющихся предметом закупки, и " +
//                        "отсутствует " +
//                        "административное наказание в виде дисквалификации; \n" +
//
//                        "− у руководителя, членов коллегиального исполнительного органа, лица, " +
//                        "исполняющего функции единоличного исполнительного органа, или главного " +
//                        "бухгалтера " +
//                        company.getSmallNameFormCompany() + " " +
//                        "\"" +
//                        company.getSmallNameCompany() +"\"" + " " +
//                        // далее так же выбираем если или нет судимости
//                        // по умолчанию нету
//                        "отсутствует судимость" +
//                        " за преступления в " +
//                        "сфере экономики и (или) преступления, предусмотренные статьями " +
//                        "289, 290, 291, 291.1 Уголовного кодекса РФ, а также в отношении " +
//                        "указанных физических лиц " +
//                        "не применяются " +
//                        "наказания в виде лишения права занимать определенные должности или " +
//                        "заниматься определенной деятельностью, которые связаны с поставкой " +
//                        "товара, выполнением работы, оказанием услуги, являющихся предметом " +
//                        "закупки, и " +
//                        "отсутствуют" +
//                        " административные наказания в виде дисквалификации." +
//                        "- " +
//                        // тут отмечаем есть ли или нету судебных тяжб с заказчиком
//                        // по умолчанию нету
//                        "отсутствуют " +
//                        "факты привлечения " +
//                        company.getSmallNameFormCompany() + " " +
//                        "\"" +
//                        company.getSmallNameCompany() +"\"" + " " +
//                        "в течение последних 24 месяцев, предшествующих дате подачи заявки, " +
//                        "к административной ответственности за совершение административного " +
//                        "правонарушения, предусмотренного статьей 19.28 Кодекса РФ об " +
//                        "административных правонарушениях.\n" +
//                        "- в реестрах недобросовестных поставщиков, предусмотренных Федеральным" +
//                        " законом от 05.04.2013 № 44-ФЗ «О контрактной системе в сфере закупок " +
//                        "товаров, работ, услуг для обеспечения государственных и муниципальных нужд» " +
//                        "и Федеральным законом от 18.07.2011 № 223-ФЗ «О закупках товаров, работ, " +
//                        "услуг отдельными видами юридических лиц», " +
//
//                        // выбираем есть ли о нас информация как о недобросовесном поставщике
//                        // по умолначию нет
//                        "отсутствуют " +
//                        "сведения о " +
//                        company.getSmallNameFormCompany() + " " +
//                        "\"" +
//                        company.getSmallNameCompany() +"\"" + " " +
//                        ", либо о любом из лиц, входящем в " +
//                        "состав коллективного Участника закупки (если применимо).";
//                        break;
//        }

        return result;
    }


    // реализация метода для определения статуса по СМП
    private String smpStatusCompany(Company company) {
        String result = null;
        switch (company.getSmpstatus()){
            case 0:
                result = "является субъектом малого предпринимательства.";
                break;
            case 1:
                result = "является субъектом среднего предпринимательства.";
                break;
            default:
                result = "не является субъектом малого или среднего предпринимательства.";
                break;
        }
        return result;
    }
}
