package com.miempresa.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/ver-primos")
    public String verPrimos(@RequestParam("inicio") int inicio, @RequestParam("fin") int fin, Model model) {
        List<Integer> primos = generarNumerosPrimos(inicio, fin);
        model.addAttribute("primos", primos);
        return "resultados";
    }

    @GetMapping("/ver-tabla")
    public String verTabla(@RequestParam("numero") int numero, Model model) {
        List<Integer> tabla = generarTablaMultiplicar(numero);
        model.addAttribute("tabla", tabla);
        return "resultados2";
    }

    private List<Integer> generarNumerosPrimos(int inicio, int fin) {
        List<Integer> primos = new ArrayList<>();
        for (int num = inicio; num <= fin; num++) {
            if (esPrimo(num)) {
                primos.add(num);
            }
        }
        return primos;
    }

    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> generarTablaMultiplicar(int numero) {
        List<Integer> tabla = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tabla.add(numero * i);
        }
        return tabla;
    }
}
