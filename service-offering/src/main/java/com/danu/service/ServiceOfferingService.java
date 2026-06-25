package com.danu.service;

import com.danu.dto.CategoryDTO;
import com.danu.dto.SalonDTO;
import com.danu.dto.ServiceDTO;
import com.danu.model.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDTO salonDTO,
                                  ServiceDTO serviceDTO,
                                  CategoryDTO categoryDTO);
    ServiceOffering updateService(Long serviceId,ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceBySalonId(Long salonId,Long categoryId);

    Set<ServiceOffering> getServicesByIds(Set<Long> ids);

    ServiceOffering getServiceById(Long id) throws Exception;
}
