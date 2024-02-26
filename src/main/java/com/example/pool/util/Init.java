package com.example.pool.util;

import com.example.pool.dao.IRepoClient;
import com.example.pool.model.Client;
import com.example.pool.model.PoolTable;
import com.example.pool.services.ClientService;
import com.example.pool.services.PoolTableService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Init {
    static ClientService daoClient ;
    public static void main(String[] args) throws ParseException {
        //initClient();
        daoClient = new ClientService(new IRepoClient() {
        });
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");


//        .save(Client.builder().name("Басков Альберт").birthday(dateFormat.parse("03.02.1973"))
//                .email("albert@mail.com").phone("+7 911 450 02 03")
//                .build());
//        daoClient.save(Client.builder().name("Рассказова Алена").birthday(dateFormat.parse("30.07.1971"))
//                .email("alena@mail.com").phone("+7 911 450 44 33")
//                .build());

        Client client = new Client("hh", "123", "email", dateFormat.parse("03.02.1973"));
        daoClient.save(client);
    }
//
//    private static void initClient() throws ParseException {
//        final ClientService daoClient;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        daoClient.save(Client.builder().name("Басков Альберт").birthday(dateFormat.parse("03.02.1973"))
//                .email("albert@mail.com").phone("+7 911 450 02 03")
//                .build());
//        daoClient.save(Client.builder().name("Рассказова Алена").birthday(dateFormat.parse("30.07.1971"))
//                .email("alena@mail.com").phone("+7 911 450 44 33")
//                .build());
//PoolTableService daoPoolTable;
//        daoPoolTable.repo.save(PoolTable.builder().name("Русский - 1").price(500).build());
//    }
}
