package io;

import com.curtisnewbie.App;
import com.curtisnewbie.io.IOWriter;
import com.curtisnewbie.io.exception.IllegalFilePathException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

/**
 * @author zhuangyongj
 */
@SpringBootTest(classes = App.class)
public class IOWriterTest {

    @Autowired
    private IOWriter ioWriter;

    @Test
    public void shouldThrowException() {
        Assertions.assertThatExceptionOfType(IllegalFilePathException.class).isThrownBy(() -> {
            ioWriter.writeFile("/home/zhuangyongj", "yoyoyo".getBytes());
        });

        Assertions.assertThatExceptionOfType(IllegalFilePathException.class).isThrownBy(() -> {
            ioWriter.writeFile(".." + File.separator + "abc", "yoyoyo".getBytes());
        });
    }


    @Test
    public void shouldWriterFile() throws IllegalFilePathException, IOException {
        File f = ioWriter.writeFile("target/test.txt", "yoyo".getBytes());
        Assertions.assertThat(f).isNotNull();
        Assertions.assertThat(f).exists();
    }
}
