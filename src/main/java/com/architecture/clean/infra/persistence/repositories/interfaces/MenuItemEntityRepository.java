package com.architecture.clean.infra.persistence.repositories.interfaces;

import com.architecture.clean.infra.persistence.entities.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MenuItemEntityRepository extends JpaRepository<MenuItemEntity, UUID>
{
    @Override
    @Query("SELECT m FROM MenuItemEntity m ORDER BY m.name")
    List<MenuItemEntity> findAll();
}
