package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.List;

public class HotelManagementService {
    public static String addHotel(Hotel hotel) {

        return HotelManagementRepository.addHotel(hotel);
    }

    public static Integer addUser(User user) {

        return HotelManagementRepository.addUser(user);
    }

    public static String getHotelWithMostFacilities() {
        return HotelManagementRepository.getHotelWithMostFacilities();
    }

    public static int bookARoom(Booking booking) {
        return HotelManagementRepository.bookARoom(booking);
    }

    public static Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
        return HotelManagementRepository.updateFacilities(newFacilities,hotelName);
    }

    public static int getBookings(Integer aadharCard) {
        return HotelManagementRepository.getBookings(aadharCard);
    }
}
