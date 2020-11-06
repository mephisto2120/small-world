package com.tryton.small_world.matcher.service;

import com.tryton.small_world.matcher.model.Person;
import com.tryton.small_world.matcher.model.PersonCriteria;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class PersonService {
    private final Map<Long, Person> personsByCustomerId;
    private final Map<String, Person> personsByLastName;

    public PersonService() {
        personsByCustomerId = new HashMap<>();
        personsByLastName = new HashMap<>();
        Person john = Person.builder()
            .customerId(987L)
            .personId(999L)
            .firstName("John")
            .lastName("Debtor")
            .birthDate(LocalDate.of(1970, 2, 4))
            .city("New York")
            .street("Washington")
            .houseNumber("24")
            .email("john.debtor@gmail.com")
            .createdDate(LocalDateTime.now())
            .lastModified(LocalDateTime.now())
            .build();

        Person cloe = Person.builder()
            .customerId(876L)
            .personId(888L)
            .firstName("Cloe")
            .lastName("Loan")
            .birthDate(LocalDate.of(1970, 2, 4))
            .city("New York")
            .street("Franklin")
            .houseNumber("24")
            .email("cloe.loan@gmail.com")
            .createdDate(LocalDateTime.now())
            .lastModified(LocalDateTime.now())
            .build();

        personsByCustomerId.put(987L, john);
        personsByCustomerId.put(876L, cloe);

        personsByLastName.put("Debtor", john);
        personsByLastName.put("Loan", cloe);
    }

    public Set<Person> getByCriteria(PersonCriteria personCriteria) {
        if (personCriteria.getCustomerId() != null) {
            if (personsByCustomerId.containsKey(personCriteria.getCustomerId())) {
                return Collections.singleton(personsByCustomerId.get(personCriteria.getCustomerId()));
            } else {
                return Collections.emptySet();
            }
        }

        if (personCriteria.getLastName() != null) {
            if (personsByLastName.containsKey(personCriteria.getLastName())) {
                return Collections.singleton(personsByLastName.get(personCriteria.getLastName()));
            } else {
                return Collections.emptySet();
            }
        }

        return Collections.emptySet();
    }
}
