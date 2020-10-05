package com.curtisnewbie.io;

import com.curtisnewbie.io.exception.IllegalFilePathException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * Reader for File I/O
 * </p>
 *
 * @author zhuangyongj
 */
public interface IOReader {

    /**
     * <p>
     * Read a file by its name/path. {@code path} should neither be absolute path nor should it contain ".." for parent
     * directories, these are considered illegal requests.
     * </p>
     * <p>
     * Since an InputStream is returned, it should be properly closed as follows:
     * </p>
     * <pre>
     * try(InputStream in = ioReader.readFile("file/in/some/where.txt");){
     *     ...
     * }
     * </pre>
     *
     * @param path
     * @return file's inputStream
     * @throws IllegalFilePathException when file path is illegal
     * @throws IOException              I/O error occurs
     */
    InputStream readFile(String path) throws IllegalFilePathException, FileNotFoundException;
}
