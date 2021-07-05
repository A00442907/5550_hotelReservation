package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.HotelDetailsModel;
import com.example.demo.entities.ReservationDetails;

@RestController
public class HotelController {

	@RequestMapping("/hello")
	public String sayhi() {
		return "hello";
	}
	
	
	public HotelDetailsModel getHotelList() {
		HotelDetailsModel hotelDetailsModel = new HotelDetailsModel();
		hotelDetailsModel.setHotel_name("Holiday Inn");
		hotelDetailsModel.setPrice(80);
		hotelDetailsModel.setAvailability(true);
		
		return hotelDetailsModel;
	}
	
	@RequestMapping("/hotelList")
	public List<HotelDetailsModel> getHotelsList() {
		return getListOfHotels();
	}
	
	@RequestMapping(value= "/reservation",method=RequestMethod.POST,consumes="application/json")
	public String reserveHotel(@RequestBody ReservationDetails reservationDetails) {
		return "Your booking is confirmed with " + reservationDetails.getHotel_name() + " and Reservation Id is 12344.";
	}
	
	
	public List<HotelDetailsModel> getListOfHotels() {
		
		List<HotelDetailsModel> hotelsList = new ArrayList<HotelDetailsModel>();
		List<String> hotelNames = Arrays.asList("Holiday Inn", "Hampton Inn", "Taj Palace", "The Grand Hotel");
		Random random = new Random();
		
		for (int i=0 ; i < hotelNames.size() ; i++) {
			HotelDetailsModel hotelDetailsModel = new HotelDetailsModel();
			hotelDetailsModel.setHotel_name(hotelNames.get(i));
			hotelDetailsModel.setAvailability(true);
			
			int ranomPrice = random.nextInt(400 -50 +1) + 50;
			hotelDetailsModel.setPrice(ranomPrice);
			
			hotelsList.add(hotelDetailsModel);
			hotelDetailsModel = null;
	}
		return hotelsList;
	}
}

