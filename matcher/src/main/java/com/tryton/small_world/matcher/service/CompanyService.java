package com.tryton.small_world.matcher.service;

import com.tryton.small_world.matcher.model.Company;
import com.tryton.small_world.matcher.model.CompanyCriteria;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CompanyService {
    private final Map<Long, Company> companiesByCustomerId;
    private final Map<String, Company> companiesName;

    public CompanyService() {
        companiesByCustomerId = new HashMap<>();
        companiesName = new HashMap<>();

        Company scylla = Company.builder()
            .customerId(123L)
            .companyId(111L)
            .name("Scylla")
            .city("New York")
            .street("Washington")
            .localNumber("24")
            .email("scylla@gmail.com")
            .createdDate(LocalDateTime.now())
            .lastModified(LocalDateTime.now())
            .build();

        Company charibdis = Company.builder()
            .customerId(234L)
            .companyId(222L)
            .name("Charibdis")
            .city("New York")
            .street("Franklin")
            .localNumber("24")
            .email("charibdies@gmail.com")
            .createdDate(LocalDateTime.now())
            .lastModified(LocalDateTime.now())
            .build();

        companiesByCustomerId.put(123L, scylla);
        companiesByCustomerId.put(234L, charibdis);

        companiesName.put("Scylla", scylla);
        companiesName.put("Charibdis", charibdis);
    }

    public Set<Company> getByCriteria(CompanyCriteria companyCriteria) {
        if (companyCriteria.getCustomerId() != null) {
            if (companiesByCustomerId.containsKey(companyCriteria.getCustomerId())) {
                return Collections.singleton(companiesByCustomerId.get(companyCriteria.getCustomerId()));
            } else {
                return Collections.emptySet();
            }
        }

        if (companyCriteria.getName() != null) {
            if (companiesName.containsKey(companyCriteria.getName())) {
                return Collections.singleton(companiesName.get(companyCriteria.getName()));
            } else {
                return Collections.emptySet();
            }
        }

        return Collections.emptySet();
    }
}
