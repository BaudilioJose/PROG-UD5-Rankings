package net.salesianos.ripadbaisor.element;

import java.util.ArrayList;
import java.util.Scanner;

public class Elements {
    
    private ArrayList<Element> elements;
    private Scanner scanner = new Scanner(System.in);

    public Elements(ArrayList<Element> elements) {
        if (elements == null) {
            this.elements = new ArrayList<>();
        } else {
            this.elements = elements;
        }
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

        if (elements.isEmpty()) {
            System.out.println("No hay elementos en la lista");
            return;
        }
        
        for (Element e : elements) {
            System.out.println(e);
        }

    }



}
