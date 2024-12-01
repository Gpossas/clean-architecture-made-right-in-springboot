package com.architecture.clean.core.exceptions;

public class MenuItemDoesNotExist extends RuntimeException
{
    public MenuItemDoesNotExist(){ super("Menu item doesn't exist"); }
}
