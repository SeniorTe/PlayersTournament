package ru.netology.ticketsearchservice.manager;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String msg) {
        super(msg);
    }
}
