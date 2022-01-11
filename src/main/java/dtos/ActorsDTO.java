package dtos;

import entities.Actor;

import java.util.List;

public class ActorsDTO {
    private List<ActorDTO> actors;

    public ActorsDTO(List<Actor> actors) {
        this.actors = ActorDTO.getFromList(actors);
    }

    public List<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }
}
