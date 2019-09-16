package com.mitrais.ayr;

import com.mitrais.ayr.view.util.InputEvent;
import com.mitrais.ayr.view.util.ScreenGenerator;
import com.mitrais.ayr.screen.Login;
import com.mitrais.ayr.screen.MainMenu;
import com.mitrais.ayr.util.ResponseHandler;
import com.mitrais.ayr.util.csv.CSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Scanner;

/**
 * ATM Simulation
 */

@SpringBootApplication
@EnableAutoConfiguration
public class App {
    public static Scanner sc = new Scanner(System.in);
    private static int invalidCount = 0;
    private InputEvent ie;

    public static void main(String[] args) {
//        AccountData.init();
//        CSVReader.read("src/main/resources/account.csv");
//        run();
        SpringApplication.run(App.class);

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS").allowedHeaders("*").maxAge(1800L);
            }
        };
    }
//
//    private static void run(){
//        String respCode = Login.showLoginScreen(sc);
//        handleAuth(respCode);
//    }
//
//    private static void handleAuth(String respCode) {
//        if (!respCode.equals("00")) {
//            if (respCode.equals("55")) {
//                invalidCount++;
//            }
//            if (invalidCount > 3) {
//                respCode = "75";
//            }
//            System.out.println(ResponseHandler.getMessage(respCode));
//            run();
//        } else {
//            invalidCount = 0;
//            MainMenu main = new MainMenu();
//            new ScreenGenerator(main).generate();
//        }
//    }
}
