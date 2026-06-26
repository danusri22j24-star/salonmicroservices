package com.danu.service.impl;

import com.danu.modal.salon;
import com.danu.payload.dto.SalonDTO;
import com.danu.payload.dto.UserDTO;
import com.danu.repository.SalonRepository;
import com.danu.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;
    @Override
    public salon createSalon(SalonDTO req, UserDTO user) {
        salon saloon=new salon();
        saloon.setName(req.getName());
        saloon.setAddress(req.getAddress());
        saloon.setEmail(req.getEmail());
        saloon.setCity(req.getCity());
        saloon.setImages(req.getImages());
        saloon.setOwnerId(user.getId());
        saloon.setOpenTime(req.getOpenTime());
        saloon.setCloseTime(req.getCloseTime());
        saloon.setPhoneNumber(req.getPhoneNumber());

        return salonRepository.save(saloon);
    }

    @Override
    public salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception {

        salon existingSalon = salonRepository.findById(salonId).orElse(null);
        if(!salon.getOwnerId().equals(user.getId())){
            throw new Exception("you don't have permission to update this salon");
        }
        if(existingSalon != null){
            existingSalon.setCity(salon.getCity());
            existingSalon.setName(salon.getName());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setImages(salon.getImages());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());
            existingSalon.setOwnerId(user.getId());
            existingSalon.setPhoneNumber(salon.getPhoneNumber());

            return salonRepository.save(existingSalon);
        }
        throw new Exception("salon not exist");
    }

    @Override
    public List<salon> getAllsalons() {
        return salonRepository.findAll();
    }

    @Override
    public salon getSalonById(Long salonId) throws Exception {
        salon saloon=salonRepository.findById(salonId).orElse(null);
        if(saloon==null){
            throw new Exception("salon not exist");
        }
        return saloon;
    }

    @Override
    public salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
