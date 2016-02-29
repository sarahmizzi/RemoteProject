package com.sarahmizzi.fyp.classes;

import com.sarahmizzi.fyp.kodi.jsonrpc.api.Input;

/**
 * Created by Sarah on 17-Feb-16.
 */
public class Transaction {
    String description;

    public Transaction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
