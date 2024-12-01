package com.architecture.clean.infra.persistence.repositories.jpa;

import com.architecture.clean.core.domain.MenuItem;
import com.architecture.clean.gateways.mappers.MenuItemMap;
import com.architecture.clean.gateways.repositories.MenuItemRepository;
import com.architecture.clean.infra.persistence.entities.MenuItemEntity;
import com.architecture.clean.infra.persistence.repositories.interfaces.MenuItemEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@ConditionalOnProperty(value = "repository.strategy", havingValue = "jpa")
@RequiredArgsConstructor
public class MenuItemRepositoryJPA implements MenuItemRepository
{
    private final MenuItemEntityRepository menuItemEntityRepository;
    private final MenuItemMap menuItemMap;

    @Override
    public MenuItemEntity saveMenuItem(MenuItem menuItem)
    {
        return menuItemEntityRepository.save(menuItemMap.fromDomainToEntity(menuItem));
    }

    @Override
    public Optional<MenuItemEntity> getMenuItemById(UUID id)
    {
        return menuItemEntityRepository.findById(id);
    }

    @Override
    public List<MenuItemEntity> getAllMenuItems()
    {
        return menuItemEntityRepository.findAll();
    }

    @Override
    public void deleteMenuItemById(UUID id)
    {
        menuItemEntityRepository.deleteById(id);
    }
}
