package com.hou27.chap06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import org.junit.jupiter.api.Test;

public class ExternalTest {
  private void givenNoFile(String path) {
    File file = new File(path);
    if(file.exists()) {
      file.delete();
    }
  }
  @Test
  void noDataFile_Then_Exception() {
    givenNoFile("badpath.txt");

    File dataFile = new File("badpath.txt");
    assertThrows(IllegalArgumentException.class, () -> {
      new DataScanner(dataFile);
    });
  }

  @Test
  void registerSuccessfully() {
    // given
    RegistReq req = new RegistReq("testID", "passw0rd", "김정호");

    // when
    registerService.register(req);

    // then
    User user = userRepository.findById(req.getId());
    assertEquals("김정호", user.getName());
  }

}
