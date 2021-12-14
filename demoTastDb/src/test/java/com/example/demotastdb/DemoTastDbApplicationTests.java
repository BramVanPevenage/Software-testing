package com.example.demotastdb;

import com.example.demotastdb.controller.ProductController;
import com.example.demotastdb.entity.Product;
import com.example.demotastdb.service.ProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

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

    //Controller Unit Testing
    @Nested
    @DisplayName("Testing ProductController")
    @Tag("ProductControllerUnitTests")
    class ControllerTests{
        @Test
        @DisplayName("No record")
        void findAll_WhenNoRecord() {
            Mockito.when(productService.findAll()).thenReturn(Arrays.asList());
            assertEquals(0,productController.getAll().size());
            Mockito.verify(productService, Mockito.times(1)).findAll();
        }

        @Test
        @DisplayName("Two records")
        void findAll_WhenRecord() {
            Mockito.when(productService.findAll()).thenReturn(Arrays.asList(p1,p2));
            assertEquals(2,productController.getAll().size());
            Mockito.verify(productService, Mockito.times(1)).findAll();//Testen of we wel de service aanroepen
        }

        @Test
        @DisplayName("Create record")
        void create() {
            ResponseEntity<Product> p = productController.create(p1);
            Mockito.verify(productService, Mockito.times(1)).createOrUpdate(p1);
        }

        @Test
        @DisplayName("Find id record succeed")
        void findById_WhenMatch() {

            Mockito.when(productService.findById(1L)).thenReturn(Optional.of(p1));
            ResponseEntity<Product> p = productController.findById(1L);
            assertEquals(p.getBody(), p1 );
        }

        @Test()
        @DisplayName("Find id record failed")
        void findById_WhenNoMatch() {

            Mockito.when(productService.findById(1L)).thenReturn(Optional.empty());
            ResponseEntity<Product> p = productController.findById(1L);
            assertEquals(p.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
