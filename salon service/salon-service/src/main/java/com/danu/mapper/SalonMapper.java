package com.danu.mapper;

import com.danu.modal.salon;
import com.danu.payload.dto.SalonDTO;

public class SalonMapper {

    public static SalonDTO mapToDTO(salon saloon){
        SalonDTO salonDTO = new SalonDTO();

        salonDTO.setId(saloon.getId());
        salonDTO.setName(saloon.getName());
        salonDTO.setAddress(saloon.getAddress());
        salonDTO.setCity(saloon.getCity());
        salonDTO.setImages(saloon.getImages());
        salonDTO.setCloseTime(saloon.getCloseTime());
        salonDTO.setOpenTime(saloon.getOpenTime());
        salonDTO.setPhoneNumber(saloon.getPhoneNumber());
        salonDTO.setOwnerId(saloon.getOwnerId());
        salonDTO.setEmail(saloon.getEmail());
        return salonDTO;
    }
}
