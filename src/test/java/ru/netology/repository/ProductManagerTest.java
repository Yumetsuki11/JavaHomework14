package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductManager;
import ru.netology.repository.ProductRepo;

public class ProductManagerTest {
    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);
    Book book = new Book(1, "Египетская книга мёртвых", 300, "Эрнест Бадж");
    Smartphone phone = new Smartphone(2, "Redmi 9", 15_000, "Xiaomi");
    Product unspecified = new Product(5, "хлеб чёрный", 42);

    @BeforeEach
    public void setup() {
        manager.add(book);
        manager.add(phone);
        manager.add(unspecified);
    }

    @Test
    public void shouldAdd() {
        Product[] expected = {book, phone, unspecified};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void shouldFindByName() {
        Product[] actual = manager.searchBy("н");
        Product[] expected = {book, unspecified};

        Assertions.assertArrayEquals(expected, actual);
    }
}
