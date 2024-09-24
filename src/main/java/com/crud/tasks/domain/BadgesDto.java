package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BadgesDto {
    @JsonProperty("votes")
    private int votes;
    @JsonProperty("attachmentsByType")
    private AtachmentsByTypeDto atachmentsByTypeDto;
}
