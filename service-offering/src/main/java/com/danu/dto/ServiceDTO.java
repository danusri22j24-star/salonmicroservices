package com.danu.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ServiceDTO {

    private Long id;

    private String name;

    private String description;

    private int price;

    private int duration;

    private Long salonId;

    private Long category;

    private String image;
}
