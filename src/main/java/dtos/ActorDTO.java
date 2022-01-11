package dtos;

import entities.Actor;

import java.util.List;
import java.util.stream.Collectors;

public class ActorDTO {
    private Integer id;
    private String name;

    public static List<ActorDTO> getFromList(List<Actor> actors) {
        return actors.stream()
                .map(actor -> new ActorDTO(actor))
                .collect(Collectors.toList());
    }

    public ActorDTO(Actor actor) {
        this.id = actor.getId();
        this.name = actor.getName();
    }

    public ActorDTO(String name) {
        this.id = -1;
        this.name = name;
    }

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
}
