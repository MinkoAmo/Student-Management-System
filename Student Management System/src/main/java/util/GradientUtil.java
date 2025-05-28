package util;

import javax.swing.*;
import java.awt.*;

public class GradientUtil {

    /**
     * Tạo JButton có nền gradient giữa 2 màu
     */
    public static JButton createGradientButton(String text, Color color1, Color color2) {
        return new JButton(text) {
            {
                setContentAreaFilled(false);
                setFocusPainted(false);
                setBorderPainted(false);
                setForeground(Color.WHITE);
                setFont(new Font("Arial", Font.BOLD, 14));
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                GradientPaint gp = new GradientPaint(
                        0, 0, color1,
                        getWidth(), getHeight(), color2
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();

                super.paintComponent(g);
            }
        };
    }

    /**
     * Tạo JPanel có nền gradient giữa 2 màu
     */
    public static JPanel createGradientPanel(Color color1, Color color2) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0, color1,
                        getWidth(), getHeight(), color2
                );

                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
    }
}

