package com.glaucus.IncrementNumber.controller;

import com.glaucus.IncrementNumber.model.Number;
import com.glaucus.IncrementNumber.service.NumberService;
import com.glaucus.IncrementNumber.utils.ResponseMessages;
import com.glaucus.IncrementNumber.utils.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;

/**
 * @author Vipul Kumar Singh
 * @version 1.0
 * @since 2020-11-09
 */
@Controller
@RequestMapping("test")
public class NumberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private NumberService numberService;

    /**
     * Dependency Injection of NumberService using setter.
     *
     * @param numberService Instance of NumberService.
     */
    @Autowired
    public void setNumberService(NumberService numberService) {
        this.numberService = numberService;
    }

    /**
     * This API is used to increment the value of number field of Number entity by 1.
     *
     * @return Returns updated Number on success, else returns appropriate message.
     */
    @PutMapping("incrementNumber")
    public ResponseEntity<ResponseObject> incrementNumber() {
        LOGGER.info("NumberController :: incrementNumber");
        try {
            Number number = numberService.incrementNumber();
            return ResponseEntity.ok(new ResponseObject(ResponseMessages.INCREMENT_SUCCESS, number));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new ResponseObject(ResponseMessages.INCREMENT_FAILURE));
        }
    }

    /**
     * This API is used to create/update the initial value of number.
     *
     * @param value Initial value to be set.
     * @return Returns updated Number on success, else returns appropriate message.
     */
    @PostMapping("setInitialData")
    public ResponseEntity<ResponseObject> setInitialData(
            @RequestParam(name = "value", defaultValue = "0", required = false) Integer value) {
        LOGGER.info("NumberController :: setInitialData, value -> {}", value);
        try {
            Number number = numberService.setInitialData(value);
            return ResponseEntity.ok(new ResponseObject(ResponseMessages.INITIALIZATION_SUCCESS, number));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(new ResponseObject(ResponseMessages.INITIALIZATION_FAILURE));
        }
    }

}
