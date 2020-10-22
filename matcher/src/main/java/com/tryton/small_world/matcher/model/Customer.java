package com.tryton.small_world.matcher.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class Customer {
    private final long customerId;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModified;
}
