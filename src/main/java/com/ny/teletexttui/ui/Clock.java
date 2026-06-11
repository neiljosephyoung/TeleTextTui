package com.ny.teletexttui.ui;

import dev.tamboui.toolkit.elements.TextElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static dev.tamboui.toolkit.Toolkit.text;

public class Clock {

    public static TextElement getDateTime() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

        String now = LocalDateTime.now().format(formatter);

        return text(now);
    }
}
