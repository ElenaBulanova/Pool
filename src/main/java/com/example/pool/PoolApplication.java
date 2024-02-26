package com.example.pool;

import com.example.pool.dao.IRepoClient;
import com.example.pool.model.Client;
import com.example.pool.services.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class PoolApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(PoolApplication.class, args);
    }
}
