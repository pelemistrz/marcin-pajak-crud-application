package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Mail {
    private final String mailTo;
    private String mailToCc;
    private final String subject;
    private final String message;
}
