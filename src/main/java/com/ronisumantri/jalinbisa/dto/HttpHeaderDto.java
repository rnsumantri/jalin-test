package com.ronisumantri.jalinbisa.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class HttpHeaderDto {
        private Long userId;
        private String signature;
}
