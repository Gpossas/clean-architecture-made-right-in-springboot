package com.architecture.clean.gateways.repositories;

import com.architecture.clean.core.domain.MenuItem;
import com.architecture.clean.infra.persistence.entities.MenuItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface MenuItemRepository
{
    MenuItemEntity saveMenuItem(MenuItem menuItem);
    Optional<MenuItemEntity> getMenuItemById(UUID id);
    List<MenuItemEntity> getAllMenuItems();
    void deleteMenuItemById(UUID id);
}
