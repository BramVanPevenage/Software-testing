package com.example.demotastdb;

import com.example.demotastdb.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTestIT {

    private static Product p1;
    private static Product p2;
    private static Product p3;
    private static Product p4;
    private static Product p5;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        p1 = new Product("P1", "Created Dummy Product", 100);
        p2 = new Product("P2", "Created For Update Dummy Product", 200);
        p3 = new Product("P3", "Updated Dummy Product",300);
        p4 = new Product("P4", "Created To be Found Dummy Product",400);
        p5 = new Product("P5", "Created For deleting Dummy Product",500);
    }

    @Test
    public void findAllTestIT() {

        ResponseEntity<Product[]> result= this.restTemplate
                .getForEntity("http://127.0.0.1:"+port+"/products/", Product[].class);

        assertEquals(result.getStatusCode(), HttpStatus.OK);

        assertEquals(result.getBody(), notNullValue());
    }

    @Test
    public void createTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p1);
        ResponseEntity<Product> response = restTemplate.postForEntity("http://127.0.0.1:"+port+"/products/", request, Product.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getName(), "P1");
        restTemplate.delete("http://127.0.0.1:"+port+"/products/"+response.getBody().getId());
    }

    @Test
    public void updateTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p2);
        ResponseEntity<Product> response = restTemplate.postForEntity("http://127.0.0.1:"+port+"/products/", request, Product.class);

        long id = response.getBody().getId();

        request = new HttpEntity<Product>(p3);
        response = restTemplate.exchange("http://127.0.0.1:"+port+"/products/"+id, HttpMethod.PUT, request, Product.class);

        assertEquals(response.getBody().getName(), "P3");
        assertEquals(response.getBody().getId(), id);
        restTemplate.delete("http://127.0.0.1:"+port+"/products/"+id);
    }

    @Test
    public void findByIDTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p4);
        ResponseEntity<Product> response = restTemplate.postForEntity("http://127.0.0.1:"+port+"/products/", request, Product.class);

        long id = response.getBody().getId();

        response = restTemplate.getForEntity("http://127.0.0.1:"+port+"/products/"+id, Product.class);

        assertEquals(response.getBody().getId(), id);
        assertEquals(response.getBody().getDescription(), p4.getDescription());
        restTemplate.delete("http://127.0.0.1:"+port+"/products/"+id);
    }

    @Test
    public void deleteByIDTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p5);
        ResponseEntity<Product> response = restTemplate.postForEntity("http://127.0.0.1:"+port+"/products/", request, Product.class);

        long id = response.getBody().getId();

        restTemplate.delete("http://127.0.0.1:"+port+"/products/"+id);
        response = restTemplate.getForEntity("http://127.0.0.1:"+port+"/products/"+id, Product.class);

        assertEquals(response.getBody(), nullValue());

    }
}
