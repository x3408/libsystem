package com.xc.libsystem.Repository;

import com.xc.libsystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT count(*) FROM user_book WHERE uid = ?1", nativeQuery = true)
    Integer getUserCollectBooksNum(Integer id);
}
