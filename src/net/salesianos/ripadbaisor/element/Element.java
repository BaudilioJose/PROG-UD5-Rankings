package net.salesianos.ripadbaisor.element;

public class Element {
    private String name;
    private String url;
    private float assessment;

    public Element(String name, String url, float assessment) {
        this.name = name;
        this.url = url;
        this.assessment = assessment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getAssessment() {
        return assessment;
    }

    public void setAssessment(float assessment) {
        this.assessment = assessment;
    }


    @Override
    public String toString() {
        return name + " | " + url + " | " + assessment;
    }
    

    
}
