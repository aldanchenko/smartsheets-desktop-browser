package ua.smartheets.browser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Main Smartsheets browser frame.
 */
class SmartsheetsBrowserFrame extends JFrame {

    /**
     * URL to smartsheets.com.
     */
    private static final String SMARTSHEET_URL = "http://smartsheet.com";

    private JPanel topPanel;
    private JEditorPane editorPane;
    private JScrollPane scrollPane;
    private URL smartSheetsUrl;

    /**
     * Default constructor.
     *
     * @param title - frame title
     */
    SmartsheetsBrowserFrame(String title) {
        initializeComponents();

        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        add(BorderLayout.NORTH, topPanel);

        add(BorderLayout.CENTER, scrollPane);
        setVisible(true);
    }

    /**
     * Initialize components.
     */
    private void initializeComponents() {
        topPanel = new JPanel();

        try {
            smartSheetsUrl = new URL(SMARTSHEET_URL);
        } catch (MalformedURLException malformedURLException) {
            JOptionPane.showMessageDialog(null, malformedURLException);
        }

        try {
            editorPane = new JEditorPane(smartSheetsUrl);

            editorPane.setEditable(false);

            editorPane.addHyperlinkListener(event -> {
                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        editorPane.setPage(event.getURL());
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, ioException);
                    }
                }
            });
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, ioException);
        }

        scrollPane = new JScrollPane(editorPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
}
