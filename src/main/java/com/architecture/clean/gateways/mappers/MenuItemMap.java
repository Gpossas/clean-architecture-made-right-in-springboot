package com.architecture.clean.gateways.mappers;

import com.architecture.clean.core.domain.MenuItem;
import com.architecture.clean.infra.persistence.entities.MenuItemEntity;
import com.architecture.clean.web.dtos.menu_item.CreateMenuItemDTO;
import com.architecture.clean.web.dtos.menu_item.ResponseMenuItemDTO;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMap
{
    // service -> web
    public ResponseMenuItemDTO fromDomainToDto(MenuItem domain)
    {
        return new ResponseMenuItemDTO(domain.getId(), domain.getName(), domain.getPrice(), domain.getDescription());
    }

    // web -> service
    public MenuItem fromDtoToDomain(CreateMenuItemDTO dto)
    {
        return new MenuItem(null, dto.name(), dto.price(), dto.description());
    }

    // service -> repository
    public MenuItemEntity fromDomainToEntity(MenuItem domain)
    {
        return new MenuItemEntity(domain.getId(), domain.getName(), domain.getPrice(), domain.getDescription());
    }

    // repository -> service
    public MenuItem fromEntityToDomain(MenuItemEntity entity)
    {
        return new MenuItem(entity.getId(), entity.getName(), entity.getPrice(), entity.getDescription());
    }
}
