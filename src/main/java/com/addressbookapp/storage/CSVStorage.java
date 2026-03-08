package com.addressbookapp.storage;

import com.addressbookapp.model.Contact;
import com.addressbookapp.util.CSVUtil;

import java.util.List;

public class CSVStorage implements ContactStorage {

    @Override
    public void save(String filePath, List<Contact> contacts) {
        CSVUtil.writeContactsToCSV(filePath, contacts);
    }

    @Override
    public List<Contact> load(String filePath) {
        return CSVUtil.readContactsFromCSV(filePath);
    }
}