import javax.swing.*;
import java.awt.*;
import net.salesianos.ripadbaisor.element.Elements;
import net.salesianos.ripadbaisor.element.Element;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        // Crear la lista de IA
        Elements listaIA = new Elements(null);

        // Variables para almacenar los datos de la IA
        


        JDialog dialog = new JDialog();
        dialog.setTitle("Menú de Opciones");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Crear botones
        JButton btnAdd = new JButton("➕ Añadir IA");
        JButton btnEdit = new JButton("✏️ Editar IA");
        JButton btnDelete = new JButton("🗑️ Eliminar IA");
        JButton btnShow = new JButton("📋 Mostrar Top IAs");
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

        // Agregar el ActionListener antes de mostrar el diálogo
        btnAdd.addActionListener(e ->  {

            String nombreIA = "";
            String urlAI = "";
            float assessmentConverted = 0.0f;
            
            JPanel panel = new JPanel();
            JTextField textField = new JTextField(20);
            panel.add(new JLabel("Nombre de la IA:"));
            panel.add(textField);
            
            int name = JOptionPane.showConfirmDialog(
                dialog,
                panel,
                "Añadir nueva IA",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (name == JOptionPane.OK_OPTION) {
                nombreIA = textField.getText();
                if (!nombreIA.trim().isEmpty()) {
                    // Aquí puedes procesar el nombre de la IA
                    System.out.println("Nueva IA: " + nombreIA);
                } else {
                    JOptionPane.showMessageDialog(
                        dialog,
                        "Por favor, introduce un nombre válido",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            // URL DE LA IA
            
            JPanel panelURL = new JPanel();
            JTextField textFieldURL = new JTextField(20);
            panelURL.add(new JLabel("URL de la IA:"));
            panelURL.add(textFieldURL);
            
            int url = JOptionPane.showConfirmDialog(
                dialog,
                panelURL,
                "Título del diálogo",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (url == JOptionPane.OK_OPTION) {
                urlAI = textFieldURL.getText();
                if (!urlAI.trim().isEmpty()) {
                    if (!urlAI.startsWith("https://") || !urlAI.startsWith("http://")) {
                        JOptionPane.showMessageDialog(
                            dialog,
                            "Por favor, introduce una URL válida con http:// o https://",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    } else {
                        System.out.println("Has introducido la WEB: " + urlAI);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        dialog,
                        "Por favor, introduce un nombre válido",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            // Obtener puntuación
            JPanel panelAssessment = new JPanel();
            JTextField textFieldassessment = new JTextField(20);
            panelAssessment.add(new JLabel("Valoración de la IA:"));
            panelAssessment.add(textFieldassessment);

            int assessment = JOptionPane.showConfirmDialog(
                dialog,
                panelAssessment,
                "Introducir la valoración de la IA",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (assessment == JOptionPane.OK_OPTION) {
                try {
                    assessmentConverted = Float.parseFloat(textFieldassessment.getText());
                    
                    if (assessmentConverted >= 0) {
                        System.out.println("Has introducido la nota");
                    } else {
                        System.out.println("La valoriación es inválida");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        dialog,
                        "Por favor, introduce un número válido",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            // Añadir la IA a la lista
            listaIA.addElement(new Element(nombreIA, urlAI, assessmentConverted));

            

        });

        // Agregar el ActionListener al botón de editar
        btnEdit.addActionListener(e -> {
            // TODO: Implementar la funcionalidad de editar una IA
        });

        // Mostrar todo en el diálogo
        dialog.getContentPane().add(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
