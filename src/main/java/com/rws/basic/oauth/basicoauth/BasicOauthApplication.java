package com.rws.basic.oauth.basicoauth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@SpringBootApplication
@EnableOAuth2Sso
public class BasicOauthApplication implements CommandLineRunner {

    private final
    BasicGetRequest basicGetRequest;

    @Autowired
    public BasicOauthApplication(BasicGetRequest basicGetRequest) {
        this.basicGetRequest = basicGetRequest;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicOauthApplication.class, args);
    }

    /*
    * Command line runner is an easy way to trigger a single get request and then exit the program.
    *
    * */
    @Override
    public void run(String... args) {
        basicGetRequest.makeGetRequest();
   //     exit(0);
    }
}
