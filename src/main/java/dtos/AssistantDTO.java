package dtos;

import entities.Assistant;

public class AssistantDTO {
    //Variables
    private Integer id;
    private String name;
    private String language;
    private int yearExperience;
    private int priceHour;

    //Constructor
    public AssistantDTO(Assistant assistant) {
        this.id = assistant.getId();
        this.name = assistant.getName();
        this.language = assistant.getLanguage();
        this.yearExperience = assistant.getYearExperience();
        this.priceHour = assistant.getPriceHour();
    }

    //Getter/Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }

    @Override
    public String toString() {
        return "AssistantDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", yearExperience=" + yearExperience +
                ", priceHour=" + priceHour +
                '}';
    }
}
