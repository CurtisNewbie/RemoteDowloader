package com.curtisnewbie.io;

import com.curtisnewbie.io.exception.IllegalFilePathException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhuangyongj
 */
@Component
public class IOWriterImpl implements IOWriter {

    private static final Logger logger = LoggerFactory.getLogger(IOWriterImpl.class);

    @Value("${root}")
    private String root;

    @Override
    public File writeFile(String path, byte[] data) throws IllegalFilePathException, IOException {
        ValidateResult result = PathValidator.validate(path);
        if (!result.isSuccess()) {
            throw new IllegalFilePathException(result.getErrMsg());
        }

        File file = new File(root, path);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file))) {
            bout.write(data);
        }
        return file;
    }
}
