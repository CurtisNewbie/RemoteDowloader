package com.curtisnewbie.io;

import com.curtisnewbie.io.exception.IllegalFilePathException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author zhuangyongj
 */
@Component
public class IOReaderImpl implements IOReader {

    @Value("${root}")
    private String root;

    @Override
    public InputStream readFile(String path) throws IllegalFilePathException, FileNotFoundException {
        var result = PathValidator.validate(path);
        if (!result.isSuccess())
            throw new IllegalFilePathException(result.getErrMsg());
        File file = new File(root, path);
        return new BufferedInputStream(new FileInputStream(file));
    }
}
