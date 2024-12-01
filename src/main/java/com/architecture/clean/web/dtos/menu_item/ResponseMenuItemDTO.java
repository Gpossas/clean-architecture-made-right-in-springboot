package com.architecture.clean.web.dtos.menu_item;

import java.util.UUID;

public record ResponseMenuItemDTO(UUID id, String name, float price, String description){}