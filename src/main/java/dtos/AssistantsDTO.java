package dtos;

import entities.Assistant;

import java.util.ArrayList;
import java.util.List;

public class AssistantsDTO {
    List<AssistantDTO> assistants = new ArrayList<>();

    public AssistantsDTO(List<Assistant> entity) {
        entity.forEach((assistant -> {
            assistants.add(new AssistantDTO(assistant));
        }));
    }

    public List<AssistantDTO> getAssistants() {
        return assistants;
    }

    @Override
    public String toString() {
        return "AssistantsDTO{" +
                "assistants=" + assistants +
                '}';
    }
}
