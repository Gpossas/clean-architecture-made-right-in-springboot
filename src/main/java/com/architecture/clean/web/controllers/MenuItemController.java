package com.architecture.clean.web.controllers;

import com.architecture.clean.gateways.mappers.MenuItemMap;
import com.architecture.clean.services.MenuItemService;
import com.architecture.clean.web.dtos.menu_item.CreateMenuItemDTO;
import com.architecture.clean.web.dtos.menu_item.ResponseMenuItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/menu_items")
@RequiredArgsConstructor
public class MenuItemController
{
    private final MenuItemService menuItemService;
    private final MenuItemMap menuItemMap;

    @PostMapping("/create")
    public ResponseEntity<ResponseMenuItemDTO> createMenuItem(@RequestBody CreateMenuItemDTO dto)
    {
        return new ResponseEntity<>(
                menuItemMap.fromDomainToDto(menuItemService.saveMenuItem(menuItemMap.fromDtoToDomain(dto))),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMenuItemDTO> getMenuItem(@PathVariable UUID id)
    {
        return new ResponseEntity<>(menuItemMap.fromDomainToDto(menuItemService.getMenuItemById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseMenuItemDTO>> getAllMenuItems()
    {
        return new ResponseEntity<>(
                menuItemService.getAllMenuItems().stream().map(menuItemMap::fromDomainToDto).toList(),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void getAllMenuItems(@PathVariable UUID id)
    {
        menuItemService.deleteMenuItemById(id);
    }
}
