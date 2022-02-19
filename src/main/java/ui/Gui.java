package ui;

import demo.ClientEntity;
import demo.SQLManager;
import util.CustomTableModel;
import util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Gui extends JFrame {

    private JPanel panel;
    private JTable table;
    private JScrollPane mainPanel;

    private CustomTableModel model;

    public Gui() {
        setContentPane(panel);
        setMinimumSize(new Dimension(1000,600));
        setVisible(true);
        setLocation(10,10);
        setTitle("...");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initTable();
    }

    private void initTable() {
        model = new CustomTableModel(
                ClientEntity.class,
                String[] {"...", "...", "...", "..." },
        SQLManager.selectAll());

        table.setModel(model);

        try {
        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError("D" + e.getMessage());
        }
    }
}
