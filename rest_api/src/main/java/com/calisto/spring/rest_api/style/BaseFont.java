package com.calisto.spring.rest_api.style;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import java.io.IOException;

public class BaseFont {

    PdfFont font;

    {
        try {
            font = PdfFontFactory
                    .createFont(
                            "c:/Windows/Fonts/times.ttf",
                            "CP1251",
                            true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PdfFont getFont() {
        return font;
    }

    public void setFont(PdfFont font) {
        this.font = font;
    }
}
