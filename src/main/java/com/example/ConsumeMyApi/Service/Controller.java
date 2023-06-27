package com.example.ConsumeMyApi.Service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class Controller {


String url = "http://localhost:8080/getUsers";
public ResponseEntity<String>callApi(HttpServletResponse response1, String url)//Object objectName
 {
    response1.setContentType("application/json");
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> Request = new HttpEntity<>(httpHeaders);//HttpEntity takes in the headers and the body of a request

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response;
    response = restTemplate.exchange(url, HttpMethod.GET,Request, String.class);
    return response;
}
    @GetMapping("get1User/{id}")
    public ResponseEntity<String>Get1User( HttpServletResponse response,@PathVariable("id") long id){
        return this.callApi(response,url+"/"+id);
    }
    @GetMapping("getUsers")
    public ResponseEntity<String>GetUsers( HttpServletResponse response){
        return this.callApi(response,url);
    }
}
