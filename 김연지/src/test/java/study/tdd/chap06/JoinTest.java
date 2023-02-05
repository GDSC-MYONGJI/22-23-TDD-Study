package study.tdd.chap06;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.*;

public class JoinTest {

    /*
    @Test
    void dupIdTest() {
        RegistReq req = new RegistReq("yeonjiDup", "김연지중복");
        assertThrows(DuplicateIdException.class, () -> registerService.register(req));
    }

    @Test
    void registerSuccessfully() {
        RegistReq req = new RegistReq("yeonji", "김연지");
        registerService.register(req);
        Member mem = memberRepo.findById("yeonji");
        assertEquals("김연지", mem.getName());
    }
    */
}
