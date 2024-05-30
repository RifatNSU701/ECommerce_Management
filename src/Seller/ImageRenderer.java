/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seller;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Nafis
 */
public class ImageRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);

        if (isSelected) {
            label.setBackground(table.getSelectionBackground());
        } else {
            label.setBackground(table.getBackground());
        }

        try {
            if (value != null) {
                String imagePath = value.toString();
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File(imagePath)));
                Image image = imageIcon.getImage().getScaledInstance(50, 100, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return label;
    }
    
}
