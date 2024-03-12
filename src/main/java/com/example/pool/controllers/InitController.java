package com.example.pool.controllers;

import com.example.pool.model.Client;
import com.example.pool.model.Fine;
import com.example.pool.model.PoolTable;
import com.example.pool.services.ClientService;
import com.example.pool.services.FineService;
import com.example.pool.services.PoolTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/service")
@RequiredArgsConstructor
public class InitController {
    private final ClientService daoClient;
    private final PoolTableService daoPoolTable;
    private final FineService daoFine;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

  @GetMapping("/")
  public String ff(){
      return "redirect:/index.html";
  }

    @GetMapping("/generate")
    public String generate() throws ParseException {
        clientInit();
        poolTableInit();
        fineInit();
        return "redirect:/index.html";
    }

    private void clientInit() throws ParseException {
        daoClient.save(Client.builder().name("Басков Альберт").birthday(dateFormat.parse("03.02.1973"))
                .email("albert@mail.com").phone("+7 911 450 02 03")
                .build());
        daoClient.save(Client.builder().name("Рассказова Алена").birthday(dateFormat.parse("30.07.1971"))
                .email("alena@mail.com").phone("+7 911 450 44 33")
                .build());
        daoClient.save(Client.builder().name("Сверчков Владимир").birthday(dateFormat.parse("12.12.1972"))
                .email("vladimir@gmail.com").phone("+7 911 450 45 11")
                .build());
    }

    private void poolTableInit() {
        daoPoolTable.save(PoolTable.builder().name("Русский - 1").price(500).build());
        daoPoolTable.save(PoolTable.builder().name("Американка - 1").price(400).build());
        daoPoolTable.save(PoolTable.builder().name("Русский - 2").price(500).build());
        daoPoolTable.save(PoolTable.builder().name("Американка - 2").price(400).build());
        daoPoolTable.save(PoolTable.builder().name("Русский - 3").price(550).build());
        daoPoolTable.save(PoolTable.builder().name("Американка - 3").price(450).build());
    }
    private void fineInit(){
        daoFine.save(Fine.builder().name("Порча сукна").cost(25000).build());
        daoFine.save(Fine.builder().name("Поломка кия").cost(10000).build());
        daoFine.save(Fine.builder().name("Порча светильника").cost(4000).build());
        daoFine.save(Fine.builder().name("Бой бокала").cost(250).build());
    }
}