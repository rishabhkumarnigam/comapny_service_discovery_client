package com.example.service_discovery_client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
@RestController
public class CompanyController {
    @Autowired
    RestTemplate restTemplate;
 
    @RequestMapping(value = "/getCompanyDetails/{companyName}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String companyName)
    {
        System.out.println("Getting company details for " + companyName);
 
        String response = restTemplate.exchange("http://employee-service/getEmployeeDetailsForCompany/{companyName}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, companyName).getBody();
 
        System.out.println("Response Received as " + response);
 
        return "Company Name -  " + companyName + " \n Employee Details " + response;
    }
 
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
