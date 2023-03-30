package com.kreitek.files;

import java.util.List;

/* [Error 04 y 05] los métodos deberían dividirse en dos interfaces diferenciadas
*   una para ficheros y otra para directorios */
public interface FileSystemItem {
    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(FileSystemItem directory);
    String getFullPath();
    String getExtension();
    List<FileSystemItem> listFiles();
    void addFile(FileSystemItem file);
    void removeFile(FileSystemItem file);
    int getSize();
    void open();
    void close();
    void setPosition(int numberOfBytesFromBeginning);
    byte[] read(int numberOfBytesToRead);
    void write(byte[] buffer);


}
