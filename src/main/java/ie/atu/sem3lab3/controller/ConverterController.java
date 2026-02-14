package ie.atu.sem3lab3.controller;

import ie.atu.sem3lab3.service.ConverterService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conversion")
public class ConverterController {
    private final ConverterService converterService;

    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/euros")
    public ResponseEntity<?> euros(@RequestParam double a)
    {
        if (a == 0.0)
        {
            return ResponseEntity.badRequest().body("Please enter a higher value");
        }
        double result = converterService.euros(a);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/dollar")
    public ResponseEntity<?> get(@RequestParam int a)
    {
        if (a == 0.0)
        {
            return ResponseEntity.badRequest().body("Please enter a higher value");
        }
        double result = converterService.dollar(a);
        return ResponseEntity.ok(result);
    }
}
