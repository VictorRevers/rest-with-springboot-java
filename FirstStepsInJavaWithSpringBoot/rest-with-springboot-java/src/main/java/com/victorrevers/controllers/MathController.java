package com.victorrevers.controllers;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorrevers.exceptions.UnsupportedMathOperationException;
import com.victorrevers.math.MathOps;
import com.victorrevers.validators.Validation;


//FAZER:
//Mover a controller para com.victorrevers.controllers
@RestController //= @Controller \n @ResponseBody
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
	
		if(!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return MathOps.Sum(Validation.convertToDouble(numberOne),Validation.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		if(!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return MathOps.Sub(Validation.convertToDouble(numberOne),Validation.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception{
		if(!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return MathOps.Mult(Validation.convertToDouble(numberOne),Validation.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception{
		if(!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return MathOps.Div(Validation.convertToDouble(numberOne),Validation.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double avg(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception{
		if(!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return MathOps.Avg(Validation.convertToDouble(numberOne),Validation.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
	public Double sqrt(
			@PathVariable("number") String number		
			) throws Exception{
		if(!Validation.isNumeric(number)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return MathOps.Sqrt(Validation.convertToDouble(number));
	}
}

