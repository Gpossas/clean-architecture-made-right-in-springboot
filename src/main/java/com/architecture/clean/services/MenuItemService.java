package com.architecture.clean.services;

import com.architecture.clean.core.domain.MenuItem;
import com.architecture.clean.core.exceptions.MenuItemDoesNotExist;
import com.architecture.clean.gateways.mappers.MenuItemMap;
import com.architecture.clean.gateways.repositories.MenuItemRepository;
import com.architecture.clean.web.dtos.menu_item.ResponseMenuItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuItemService
{
    private final MenuItemRepository menuItemRepository;
    private final MenuItemMap menuItemMap;

    public MenuItem saveMenuItem(MenuItem menuItem)
    {
        return menuItemMap.fromEntityToDomain(menuItemRepository.saveMenuItem(menuItem));
    }

    public MenuItem getMenuItemById(UUID id)
    {
        return menuItemMap.fromEntityToDomain(menuItemRepository.getMenuItemById(id).orElseThrow(MenuItemDoesNotExist::new));
    }

    public List<MenuItem> getAllMenuItems()
    {
        return menuItemRepository.getAllMenuItems().stream().map(menuItemMap::fromEntityToDomain).toList();
    }

    public void deleteMenuItemById(UUID id)
    {
        menuItemRepository.getMenuItemById(id).orElseThrow(MenuItemDoesNotExist::new);
        menuItemRepository.deleteMenuItemById(id);
    }
}
