package ua.smartheets.browser;

import javax.swing.*;

/**
 * Main class.
 */
public class SmartsheetsBrowserApp {

    /**
     * Main entry point.
     *
     * @param args - console arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SmartsheetsBrowserFrame("Smartsheets browser"));
    }
}
