package com.example.demotastdb;

import com.example.demotastdb.controller.ProductController;
import com.example.demotastdb.entity.Product;
import com.example.demotastdb.service.ProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DemoTastDbApplicationTests {

    private static Product p1;
    private static Product p2;
    private static Product p3;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUpMock(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void setUp(){
        p1 = new Product("P1", "Created Dummy Product", 100);
        p2 = new Product("P2", "Created For Update Dummy Product", 200);
        p3 = new Product("P3", "Updated Dummy Product",300);
    }

    @Test
    void findAll_6() {
        Mockito.when(productService.findAll()).thenReturn(Arrays.asList());
        assertEquals(6,productController.getAll().size());
        Mockito.verify(productService, Mockito.times(1)).findAll();
    }

}
