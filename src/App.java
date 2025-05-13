import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Menú de Opciones");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Crear botones
        JButton btnAdd = new JButton("➕ Añadir elemento");
        JButton btnEdit = new JButton("✏️ Editar elemento");
        JButton btnDelete = new JButton("🗑️ Eliminar elemento");
        JButton btnShow = new JButton("📋 Mostrar elementos");
        JButton btnExit = new JButton("🚪 Salir");

        // Panel para los 4 botones principales (2x2)
        JPanel gridPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        gridPanel.add(btnAdd);
        gridPanel.add(btnEdit);
        gridPanel.add(btnDelete);
        gridPanel.add(btnShow);

        // Panel principal que contiene la cuadrícula y el botón salir
        JPanel mainPanel = new JPanel(new BorderLayout(10, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(btnExit, BorderLayout.SOUTH);

        // Mostrar todo en el diálogo
        dialog.getContentPane().add(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
