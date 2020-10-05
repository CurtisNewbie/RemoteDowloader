package io;

import com.curtisnewbie.App;
import com.curtisnewbie.io.IOReader;
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
public class IOReaderTest {

    @Autowired
    private IOWriter ioWriter;

    @Autowired
    private IOReader ioReader;

    @Test
    public void shouldThrowException() {
        Assertions.assertThatExceptionOfType(IllegalFilePathException.class).isThrownBy(() -> {
            ioReader.readFile("/home/zhuangyongj");
        });

        Assertions.assertThatExceptionOfType(IllegalFilePathException.class).isThrownBy(() -> {
            ioReader.readFile(".." + File.separator + "abc");
        });
    }

    @Test
    public void shouldReadFile() throws IllegalFilePathException, IOException {
        File f = ioWriter.writeFile("target/testForReader.txt", "readme".getBytes());
        try (var in = ioReader.readFile(f.getPath())) {
            Assertions.assertThat(in).isNotNull();
        }
    }
}
