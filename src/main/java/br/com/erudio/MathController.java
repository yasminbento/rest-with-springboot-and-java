package br.com.erudio;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

       @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media (
            @PathVariable(value = "numberOne")   String numberOne,
            @PathVariable(value = "numberTwo")   String numberTwo
    ) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
    public Double square (
            @PathVariable(value = "number")   String number

    ) throws Exception{

        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        return Math.sqrt(convertToDouble(number));
    }







    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
