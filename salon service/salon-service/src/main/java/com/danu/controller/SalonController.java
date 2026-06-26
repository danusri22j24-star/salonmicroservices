package com.danu.controller;

import com.danu.mapper.SalonMapper;
import com.danu.modal.salon;
import com.danu.payload.dto.SalonDTO;
import com.danu.payload.dto.UserDTO;
import com.danu.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    // http://localhost:5002/api/salons
    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO){
        UserDTO userDTO=new UserDTO();
        userDTO.setId(1L);
        salon saloon=salonService.createSalon(salonDTO,userDTO);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(salonDTO1);
    }

    // http://localhost:5002/api/salons/2
    @PutMapping("/{salonId}")
    public ResponseEntity<SalonDTO> updateSalon(
            @PathVariable Long salonId,
            @RequestBody SalonDTO salonDTO) throws Exception {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(1L);

        salon saloon=salonService.updateSalon(salonDTO,userDTO,salonId);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(salonDTO1);
    }

    // http://localhost:5002/api/salons
    @GetMapping()
    public ResponseEntity<List<SalonDTO>>getSalons() throws Exception {

        List<salon> saloons=salonService.getAllsalons();

        List<SalonDTO> salonDTOS = saloons.stream().map((saloon)->
        {
            SalonDTO salonDTO = SalonMapper.mapToDTO(saloon);
            return salonDTO;
        }
        ).toList();

        return ResponseEntity.ok(salonDTOS);
    }

    // http://localhost:5002/api/salons/5
    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO>getSalonById(
            @PathVariable Long salonId
    ) throws Exception {

        salon salon=salonService.getSalonById(salonId);

        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO);

    }

    // http://localhost:5002/api/salons/search?city=mumbai
    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>>searchSalons(
            @RequestParam("city") String city
    ) throws Exception {

        List<salon> saloons=salonService.searchSalonByCity(city);

        List<SalonDTO> salonDTOS = saloons.stream().map((saloon)->
                {
                    SalonDTO salonDTO = SalonMapper.mapToDTO(saloon);
                    return salonDTO;
                }
        ).toList();

        return ResponseEntity.ok(salonDTOS);
    }

    // http://localhost:5002/api/salons/5
    @GetMapping("/owner")
    public ResponseEntity<SalonDTO>getSalonByOwnerId(
            @PathVariable Long salonId
    ) throws Exception {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(1L);

        salon salon=salonService.getSalonByOwnerId(userDTO.getId());

        SalonDTO salonDTO = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO);

    }
}
