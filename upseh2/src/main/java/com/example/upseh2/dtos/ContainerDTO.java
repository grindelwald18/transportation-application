package com.example.upseh2.dtos;


import lombok.Data;

import java.util.List;

    @Data
    public class ContainerDTO {

        private long id;
        private List<DeliveryItemIdDTO> deliveryItems;
    }
