package com.glaucus.IncrementNumber.service;

import com.glaucus.IncrementNumber.model.Number;
import com.glaucus.IncrementNumber.repository.NumberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.lang.invoke.MethodHandles;
import java.util.Objects;

/**
 * This is a service which contains methods to add/modify the Number data in db.
 *
 * @author Vipul Kumar Singh
 * @version 1.0
 * @since 2020-11-09
 */
@Service
public class NumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final int numberId = 1;

    @PersistenceContext
    EntityManager entityManager;

    private NumberRepository numberRepository;

    /**
     * Dependency Injection of NumberRepository using setter.
     *
     * @param numberRepository Instance of NumberRepository.
     */
    @Autowired
    public void setNumberRepository(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    /**
     * This method is used to increment the value of number field of Number entity by 1.
     * It uses PessimisticLock to acquire read and write lock on number table.
     *
     * @return Returns the updated value of number.
     */
    @Transactional
    public Number incrementNumber() {
        LOGGER.info("NumberService :: incrementNumber");
        Number number = entityManager.find(Number.class, 1, LockModeType.PESSIMISTIC_WRITE);
        if (Objects.isNull(number)) {
            number.setId(numberId);
            number.setNumber(1);
        } else {
            number.setNumber(number.getNumber() + 1);
        }
        return number;
    }

    /**
     * This method is used to create/update the initial value of number.
     *
     * @param value Initial value to be set.
     * @return Returns the updated value of number.
     */
    public Number setInitialData(int value) {
        LOGGER.info("NumberService :: setInitialData");
        Number number = numberRepository.findById(numberId).orElse(new Number());
        number.setId(numberId);
        number.setNumber(value);
        return numberRepository.save(number);
    }
}
