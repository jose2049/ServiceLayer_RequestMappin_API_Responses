package ie.atu.sem3lab3.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public double euros(double a)
    {
        return Math.round((a * 0.84) * 100.0) / 100.0;
    }

    public double dollar (double a)
    {
        return Math.round((a/0.84) * 100.0) / 100.0;
    }
}
