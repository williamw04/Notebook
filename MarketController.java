package edu.spring.boot.marketwebapp.controller;

 import edu.spring.boot.marketwebapp.entities.Market;
 import edu.spring.boot.marketwebapp.service.MarketService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

 @RestController
 @RequestMapping("/api/markets")
 public class MarketController {
    @Autowired
     private final MarketService marketService;

     @Autowired
     public MarketController(MarketService marketService) {
         this.marketService = marketService;
     }

     @GetMapping
     public List<Market> getAllMarkets() {
         return marketService.getAllMarkets();
     }

     @GetMapping("/{id}")
     public Market getMarketById(@PathVariable int id) {
         return marketService.getMarketById(id);
     }

     @PostMapping
     public Market createMarket(@RequestBody Market market) {
         return marketService.saveMarket(market);
     }

     @GetMapping("/city/{city}")
     public List<Market> getMarketsByCity(@PathVariable String city) {
         return marketService.getMarketsByCity(city);
     }
 }