package com.dccsh.net.group.one.workplan.config.prop;

import com.mongodb.MongoCredential;

public class MyMongoCredential {
    private String userName;
    private String database;
    private char[] password;

    public String getUserName() {
        return userName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public MongoCredential createMongoCredential() {
        // return MongoCredential.createScramSha1Credential(userName, database,
        // password);
        return MongoCredential.createCredential(userName, database, password);
        // return MongoCredential.createMongoCRCredential(userName, database,
        // password);
    }
}
