package net.salesianos.ripadbaisor.element;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.*;

public class Elements {
    
    private ArrayList<Element> elements;
    private Scanner scanner = new Scanner(System.in);

    public Elements(ArrayList<Element> elements) {
        this.elements =  new ArrayList<>();
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void editElement(String searchedName, String newName, String newUrl, float newAssessment) {
        for (Element e : elements) {
            if (e.getName().equalsIgnoreCase(searchedName)) {

                System.out.println("Se ha encontrado el elemento: " + e.getName() + "¿Desea eliminarlo?");

                String optUser = scanner.nextLine();

                if (optUser.equalsIgnoreCase("si") || optUser.equalsIgnoreCase("sí")) {
                    e.setName(newName);
                    e.setUrl(newUrl);
                    e.setAssessment(newAssessment);
                    return;
                }
                
                System.out.println("No se ha guardado el elemento");
            }
        }
    }

    public boolean checkElement(String nameElement) {

        for (Element e : elements) {
            if (e.getName().equalsIgnoreCase(nameElement)) {
                return true;
            }
        }    
        return false;    
    }

    public void deleteElement(String searchedName) {
        Element toRemove = null;

        for (Element e : elements) {
            if (e.getName().contains(searchedName)) {
                toRemove = e;
            }
        }
        
        if (toRemove != null) {
            elements.remove(toRemove);
        }
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void showElements() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Lista de IAs");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (elements.isEmpty()) {
            JLabel emptyLabel = new JLabel("No hay elementos en la lista");
            mainPanel.add(emptyLabel);
        } else {
            for (Element e : elements) {
                JPanel elementPanel = new JPanel();
                elementPanel.setLayout(new GridLayout(3, 1));
                elementPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                elementPanel.add(new JLabel("Nombre: " + e.getName()));
                elementPanel.add(new JLabel("URL: " + e.getUrl()));
                elementPanel.add(new JLabel("Valoración: " + e.getAssessment()));

                mainPanel.add(elementPanel);
                mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }

            JLabel totalLabel = new JLabel("Total de IAs: " + elements.size());
            mainPanel.add(totalLabel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        dialog.add(scrollPane);
        
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }



}
