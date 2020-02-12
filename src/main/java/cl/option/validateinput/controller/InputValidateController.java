package cl.option.validateinput.controller;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.option.validateinput.model.ValidationResult;
import cl.option.validateinput.service.InputValidation;

@RestController
@RequestMapping("/api/v1/input")
@Validated
public class InputValidateController {
    @Autowired
    private InputValidation service;

    @GetMapping("/validate")
    public ResponseEntity<ValidationResult> getValidation(
        @RequestParam(value = "input") @NotEmpty String input
    ) {
        return new ResponseEntity<ValidationResult>(service.validate(input), HttpStatus.OK);
    }
}