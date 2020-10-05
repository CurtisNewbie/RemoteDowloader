package com.curtisnewbie.io;

import com.curtisnewbie.io.exception.IllegalFilePathException;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * Writer for file I/O
 * </p>
 *
 * @author zhuangyongj
 */
public interface IOWriter {

    /**
     * Write a data to a file (which might not exists beforehand). {@code path} should neither be absolute path nor
     * should it contain ".." for parent directories, these are considered illegal requests.
     *
     * @param path filename or path
     * @param data actual data of the file
     * @return file
     * @throws IllegalFilePathException when file path is illegal
     * @throws IOException              I/O error occurs
     */
    File writeFile(String path, byte[] data) throws IllegalFilePathException, IOException;
}
