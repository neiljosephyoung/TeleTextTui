package com.ny.teletexttui.util;

import com.ny.teletexttui.ui.Theme;
import dev.tamboui.toolkit.element.Element;

import java.util.Arrays;

import static dev.tamboui.toolkit.Toolkit.text;

public class FormattingUtil {

    public static Element[] formatMutliLineToBanner(String multiLineString) {
        return  Arrays.stream(multiLineString.split("\n"))
                .map(line -> text(line)
                        .bold())
                .toArray(Element[]::new);
    }

    public static Element[] formatMutliLineToBanner(String multiLineString, Theme theme) {
        return  Arrays.stream(multiLineString.split("\n"))
                .map(line -> text(line)
                        .fg(theme.primary())
                        .bold())
                .toArray(Element[]::new);
    }
}
