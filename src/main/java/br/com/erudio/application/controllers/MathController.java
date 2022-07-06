package br.com.erudio.application.controllers;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.domain.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

       @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return math.divide(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
    public Double square (
            @PathVariable(value = "number")   String number

    ) throws Exception{

        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return math.square(NumberConverter.convertToDouble(number));
    }

}




