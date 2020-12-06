package com.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {
    private BigInteger id;
    private String serial;
}
