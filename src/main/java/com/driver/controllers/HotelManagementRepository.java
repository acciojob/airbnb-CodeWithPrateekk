package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class HotelManagementRepository {

    public static HashMap<String,Hotel> hotelDb = new HashMap<>();
    public static HashMap<Integer,User> userDb = new HashMap<>();
    public static HashMap<String,Booking> bookingDb = new HashMap<>();

    HashMap<String, ArrayList<String>> userBookingDb = new HashMap<>();
    public static String addHotel(Hotel hotel) {
        if(hotelDb.containsKey(hotel.getHotelName()) || hotel==null)
        {
            return "Failure";
        }

        hotelDb.put(hotel.getHotelName(),hotel);

        return "Hotel added successfully";

    }

    public static Integer addUser(User user) {

        userDb.put(user.getaadharCardNo(),user);

        //System.out.println("User added successfully");

        return user.getaadharCardNo();


    }
// need to modify it
    public static String getHotelWithMostFacilities() {
       String nameBig="";
       int facilities = 0;
        for(String name : hotelDb.keySet()) {
            if (facilities < hotelDb.get(name).getFacilities().size()) {
                facilities = hotelDb.get(name).getFacilities().size();
                nameBig = name;
            } else if (facilities == (hotelDb.get(name)).getFacilities().size()) {
                if (nameBig.compareTo(name) > 0) {
                    continue;
                } else {
                    nameBig = name;
                }
            }
        }

            return nameBig;
        }

    public static int bookARoom(Booking booking) {
        booking.setBookingId(UUID.randomUUID().toString()) ;

        if(hotelDb.containsKey(booking.getHotelName()))
        {
            if(hotelDb.get(booking.getHotelName()).getAvailableRooms() < booking.getNoOfRooms())
                return -1;
        }


        int bookingAmount = booking.getNoOfRooms() * hotelDb.get(booking.getHotelName()).getPricePerNight();





        bookingDb.put(booking.getBookingId(),booking);
        return bookingAmount;






    }

    public static Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
        Hotel hotel = hotelDb.get(hotelName);
        List<Facility> oldFacilities = hotel.getFacilities();

        for(int i=0;i<newFacilities.size();i++)
        {
            if(oldFacilities.contains(newFacilities.get(i))==false)
            {
                oldFacilities.add(newFacilities.get(i));
            }
        }
        hotel.setFacilities(oldFacilities);
        hotelDb.put(hotelName,hotel);

        return hotel;
    }

    public static int getBookings(Integer aadharCard) {
        int cnt = 0;

        for(String key : bookingDb.keySet())
        {
            if(aadharCard.equals(bookingDb.get(key).getBookingAadharCard()))
                cnt++;
        }

        return cnt;
    }
}

