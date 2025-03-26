package com.example.campaign.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/keywords")
@CrossOrigin(origins = "http://localhost:3000")
public class KeywordController {

    private static final List<String> PREDEFINED_KEYWORDS = List.of(
            "Elektronika", "Moda", "Książki", "Sport", "Dom", "Kultura","Biżuteria", "Książki", "Smartfony", "Technologia",
            "Motoryzacja", "Zdrowie", "Uroda", "Dzieci", "Gry", "Turystyka", "Ogrodnictwo", "Obuwie", "Artykuły AGD", "Akcesoria"
    );

    @GetMapping
    public ResponseEntity<List<String>> searchKeywords(
            @RequestParam(required = false) String search) {

        if (search == null || search.isEmpty()) {
            return ResponseEntity.ok(PREDEFINED_KEYWORDS);
        }

        String searchLower = search.toLowerCase();
        List<String> filtered = PREDEFINED_KEYWORDS.stream()
                .filter(kw -> kw.toLowerCase().contains(searchLower))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filtered);
    }
}