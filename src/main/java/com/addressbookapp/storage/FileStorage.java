package com.addressbookapp.storage;

import com.addressbookapp.model.Contact;
import com.addressbookapp.util.FileUtil;

import java.util.List;

public class FileStorage implements ContactStorage {

    @Override
    public void save(String filePath, List<Contact> contacts) {
        FileUtil.writeContactsToFile(filePath, contacts);
    }

    @Override
    public List<Contact> load(String filePath) {
        return FileUtil.readContactsFromFile(filePath);
    }
}