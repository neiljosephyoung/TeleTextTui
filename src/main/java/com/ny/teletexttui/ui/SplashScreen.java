package com.ny.teletexttui.ui;

import com.ny.teletexttui.util.FormattingUtil;
import dev.tamboui.toolkit.element.Element;

import static dev.tamboui.toolkit.Toolkit.*;

public class SplashScreen {

    private static final String BANNER =
                    """
                    ████████╗███████╗██╗     ███████╗████████╗███████╗██╗  ██╗████████╗
                    ╚══██╔══╝██╔════╝██║     ██╔════╝╚══██╔══╝██╔════╝╚██╗██╔╝╚══██╔══╝
                       ██║   █████╗  ██║     █████╗     ██║   █████╗   ╚███╔╝    ██║
                       ██║   ██╔══╝  ██║     ██╔══╝     ██║   ██╔══╝   ██╔██╗    ██║
                       ██║   ███████╗███████╗███████╗   ██║   ███████╗██╔╝ ██╗   ██║
                       ╚═╝   ╚══════╝╚══════╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚═╝
                    """;

    public static Element render() {
        var theme = ThemeManager.current();

        Element banner = row(
                spacer(), // left flex
                column(
                        FormattingUtil.formatMutliLineToBanner(BANNER, theme)
                ),
                spacer() // right flex
        );

        return column(
                banner,
                spacer(1),
                text("WELCOME TO TELETEXT SYSTEM")
                        .fg(theme.secondary())
                        .centered(),
                spacer(1),
                text("PRESS ENTER TO CONTINUE")
                        .fg(theme.textDim())
                        .centered(),
                spacer(2),
                Clock.getDateTime()
                        .fg(theme.accent())
                        .centered()

        );
    }
}
