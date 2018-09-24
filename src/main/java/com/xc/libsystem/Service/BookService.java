package com.xc.libsystem.Service;

import com.xc.libsystem.Entity.User;
import com.xc.libsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Integer getUserCollectBooksNum(Integer id) {
        Integer userCollectBooksNum = bookRepository.getUserCollectBooksNum(id);

        return userCollectBooksNum;
    }
}
