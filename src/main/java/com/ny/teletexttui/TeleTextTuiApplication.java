package com.ny.teletexttui;

import com.ny.teletexttui.ui.SplashScreen;
import com.ny.teletexttui.ui.ThemeManager;
import dev.tamboui.style.Color;
import dev.tamboui.toolkit.app.ToolkitApp;
import dev.tamboui.toolkit.element.Element;
import dev.tamboui.toolkit.event.EventResult;
import dev.tamboui.tui.event.KeyCode;
import dev.tamboui.tui.event.KeyEvent;
import dev.tamboui.widgets.wavetext.WaveText;
import dev.tamboui.widgets.wavetext.WaveTextState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static dev.tamboui.toolkit.Toolkit.*;

public class TeleTextTuiApplication extends ToolkitApp {

    private static final Logger log = LoggerFactory.getLogger(TeleTextTuiApplication.class);

    @Override
    protected void onStart() {
        log.info("TeleText Started...");
        var theme = ThemeManager.current();
    }

    @Override
    protected void onStop() {
        log.info("App stopped");
    }

    @Override
    protected Element render() {
        return panel(
                SplashScreen.render(),
                spacer(),
                spacer(),
                text("Press 'q' to quit").dim()
                //,
                //  logPanel
        ).rounded().onKeyEvent(this::handleKeyEvent);
    }

    private EventResult handleKeyEvent(KeyEvent event) {
        if (event.isQuit()) {
            quit();
            return EventResult.HANDLED;
        }

        if (event.isCharIgnoreCase('h')) {
            //todo goto help/info page
            log.info("handling H keypress...");
            return EventResult.HANDLED;
        }

        if (event.isKey(KeyCode.ENTER)) {
            log.info("starting main screen");
            return EventResult.HANDLED;
        }

//        return switch (currentScreen) {
//            case SPLASH -> EventResult.UNHANDLED;
//            case MAIN -> handleMainScreenKey(event);
//            case EXPLORE -> handleExploreScreenKey(event);
//            case GENERATE -> handleGenerateScreenKey(event);
//            case HELP -> handleHelpScreenKey(event);
//        };

        return EventResult.UNHANDLED;
    }


    public static void main(String[] args) throws Exception {
        log.info(Arrays.toString(args));
        new TeleTextTuiApplication().run();
    }
}
