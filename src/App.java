import javax.swing.*;
import java.awt.*;
import net.salesianos.ripadbaisor.element.Elements;
import net.salesianos.ripadbaisor.element.Element;
import java.util.ArrayList;

public class App {
    private static String nombreIA = "";
    private static String urlIA = "";
    private static float assessmentIA = 0.0f;

    public static void main(String[] args) {

        // Crear la lista de IA
        Elements listaIA = new Elements(null);

        

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
            panelURL.add(new JLabel("URL de la IA (debe comenzar con https:// o http://):"));
            panelURL.add(textFieldURL);
            textFieldURL.setToolTipText("Ejemplo: https://www.misia.com");

            boolean isUrlValid = false;
            

            while (!isUrlValid) {
                int url = JOptionPane.showConfirmDialog(
                    dialog,
                    panelURL,
                    "Introducir URL de la IA",
                    JOptionPane.OK_CANCEL_OPTION
                );

                if (url == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(
                        dialog,
                        "Has cancelado la añadición de la IA",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE
                    );
            
                    isUrlValid = true;
                    return;
                } else if (url == JOptionPane.OK_OPTION) {
                    if (!textFieldURL.getText().trim().isEmpty()) {
                        if (textFieldURL.getText().startsWith("https://") || textFieldURL.getText().startsWith("http://")) {
                            urlIA = textFieldURL.getText();
                            isUrlValid = true;
                        } else {
                            JOptionPane.showMessageDialog(
                                dialog,
                                "Por favor, introduce una URL válida con http:// o https://",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
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
                    assessmentIA = Float.parseFloat(textFieldassessment.getText());
                    
                    if (assessmentIA >= 0) {
                        JOptionPane.showMessageDialog(
                            dialog,
                            "Has introducido la nota: " + assessmentIA,
                            "Información",
                            JOptionPane.INFORMATION_MESSAGE
                        );  
                    } else {
                        JOptionPane.showMessageDialog(
                            dialog, "La valoriación es inválida", "Error", JOptionPane.ERROR_MESSAGE);
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
            listaIA.addElement(new Element(nombreIA, urlIA, assessmentIA));

            

        });

        
       
        

        // Agregar el ActionListener al botón de editar
        btnEdit.addActionListener(e -> {
            // Obtener el nombre a editar
            String nombreIA = JOptionPane.showInputDialog(
                dialog,
                "Introduce el nombre de la IA a editar:",
                "Editar IA",
                JOptionPane.PLAIN_MESSAGE
            );

            

            editarIA(nombreIA, listaIA);
        });

        // Mostrar todo en el diálogo
        dialog.getContentPane().add(mainPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        
    }

    public static boolean buscarIA(String nombreIA, Elements listaIA) {
        
        for (Element e : listaIA.getElements()) {
            if (e.getName().equalsIgnoreCase(nombreIA)) {
                return true;
            }
        }
        return false;
    }

    public static void editarIA(String nombreIA, Elements listaIA) {
        
        // Crear el diálogo
        JDialog dialog = new JDialog();
        dialog.setTitle("Editar IA"); // Título del diálogo
        dialog.setModal(true); // Hace que el diálogo sea modal         
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cierra el diálogo al pulsar el botón de cerrar

        // Crear el panel para el nombre de la IA
        JPanel panelEditName = new JPanel();
        // Crear el campo de texto para el nombre de la IA
        JTextField textFieldEditName = new JTextField(20);
        // Añadir el label y el campo de texto al panel
        panelEditName.add(new JLabel("Nombre de la IA:"));
        // Añadir el campo de texto al panel
        panelEditName.add(textFieldEditName);

        

        for (Element e : listaIA.getElements()) {
            if (e.getName().equalsIgnoreCase(nombreIA)) {
                JOptionPane.showMessageDialog(
                    dialog,
                    "La IA existe",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
                );

                int editName = JOptionPane.showConfirmDialog(
                    dialog,
                    panelEditName,
                    "Editar nombre de la IA",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
                );

                if (editName == JOptionPane.OK_OPTION) {
                    nombreIA = textFieldEditName.getText();
                    if (!nombreIA.trim().isEmpty()) {
                        e.setName(nombreIA);
                    } else {
                        JOptionPane.showMessageDialog(
                            dialog,
                            "Por favor, introduce un nombre válido");
                    }
                }

                e.setName(nombreIA);
            } else if (e.getUrl().equalsIgnoreCase(urlIA)) {
                e.setUrl(urlIA);
            } else if (e.getAssessment() == assessmentIA) {
                e.setAssessment(assessmentIA);
            }
        }
    }

    public static void eliminarIA(String nombreIA, Elements listaIA) {
    }


    
}
