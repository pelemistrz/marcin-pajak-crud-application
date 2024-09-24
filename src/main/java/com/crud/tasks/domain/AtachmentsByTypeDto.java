package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AtachmentsByTypeDto {
    @JsonProperty("trello")
    private TrelloDto trelloDto;
}
