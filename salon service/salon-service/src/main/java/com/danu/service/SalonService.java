package com.danu.service;

import com.danu.modal.salon;
import com.danu.payload.dto.SalonDTO;
import com.danu.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {

    salon createSalon(SalonDTO salon, UserDTO user);

    salon updateSalon(SalonDTO salon,UserDTO user, Long salonId) throws Exception;

    List<salon> getAllsalons();

    salon getSalonById(Long salonId) throws Exception;

    salon getSalonByOwnerId(Long ownerId);

    List<salon> searchSalonByCity(String city);

}
