package com.architecture.clean.core.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem
{
    private UUID id;
    private String name;
    private float price;
    private String description;
}
