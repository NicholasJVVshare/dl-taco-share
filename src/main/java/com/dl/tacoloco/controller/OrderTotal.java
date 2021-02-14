package com.dl.tacoloco.controller;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class OrderTotal {

    BigDecimal total;
}
