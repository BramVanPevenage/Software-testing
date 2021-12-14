package com.example.demotastdb;

import com.example.demotastdb.entity.Product;
import com.example.demotastdb.repository.ProductRepository;
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

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Testing ProductService")
@Tag("ProductServiceUnitTests")
class ProductServiceTests {

    private static Product p1;
    private static Product p2;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        p1 = new Product("P1", "Created Dummy Product", 100);
        p2 = new Product("P2", "Created For Update Dummy Product", 200);
    }

    @Test
    public void findAllTest_WhenNoRecord() {

        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(productService.findAll().size(), 0);
        Mockito.verify(productRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void findAllTest_WhenRecord() {

        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(p1, p2));
        assertEquals(productService.findAll().size(), 2);
        assertEquals(productService.findAll().get(0), p1);
        assertEquals(productService.findAll().get(1),p2);
        Mockito.verify(productRepository, Mockito.times(3)).findAll();

    }

    @Test
    public void findById() {

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(p1));
        assertEquals(productService.findById(1L), Optional.of(p1));
        Mockito.verify(productRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void createOrUpdate() {

        Mockito.when(productRepository.save(p1)).thenReturn(p1);
        assertEquals(productService.createOrUpdate(p1), p1);
        Mockito.verify(productRepository, Mockito.times(1)).save(p1);

        Mockito.when(productRepository.save(p2)).thenReturn(p2);
        assertEquals(productService.createOrUpdate(p2).getName(), "P2");
        Mockito.verify(productRepository, Mockito.times(1)).save(p2);
    }

    @Test
    void deleteById() {
        productService.deleteById(1L);
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1L);
    }
}
