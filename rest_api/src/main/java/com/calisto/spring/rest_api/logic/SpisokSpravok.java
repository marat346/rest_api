package com.calisto.spring.rest_api.logic;

import java.util.HashMap;
import java.util.Map;

// список всех документов необходимых для подачи заявки по тендеру в Роснефть
// данный список документов очень часто запрашивается организатором
// пользователь на сайте должен отметить те документы которые ему не нужны
// по умолчанию создаются все документы кроме "Согласие идти в субподряд"
public class SpisokSpravok {
    Map<String, Boolean> mapList = new HashMap<String, Boolean>();

    public Map<String,Boolean> generatorMapList() {
        mapList.put("Наличие людских ресурсов", true);
        mapList.put("Не эксплуатируем объекты 1 и 2 кл опасности", true);
        mapList.put("Отсутствие судебных разбирательст", true);
        mapList.put("Согласие с договором", true);
        mapList.put("Согласие с выполнением работ", true);
        mapList.put("Согласие со сроком оплаты", true);
        mapList.put("Привлекаем собственный транспорт", true);
        mapList.put("Гарантийное письмо о наличии СИЗ и прочего", true);
        mapList.put("Согласие идти в субподряд", false);
        mapList.put("Согласие на проведение добровольного технического аудита", true);
        mapList.put("Согласие на выполнение работ в соответствии с техническим заданием", true);
        mapList.put("Согласие на изменение объёма", true);
        return mapList;
    }
}
