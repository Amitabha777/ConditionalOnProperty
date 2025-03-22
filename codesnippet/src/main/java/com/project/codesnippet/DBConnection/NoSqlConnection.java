package com.project.codesnippet.DBConnection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
                        prefix= "noSqlConnection",                 //Here Prefix+Value is the Key for configuration in properties file
                        value = "enabled", 
                        havingValue = "true",                    //havingValue is the Value & together they constitute key value pair 
                        matchIfMissing = false)                               // Which we will define/pass values in Properties file                 
public class NoSqlConnection {
    

    /* Note :
     !              havingValue needs a String value not a Boolean so you can give any value instead of true.

     !                          If the String value you put it as "create" instead of "true", If it
     !                                                                       matches with the value in properties file
     ?                              Then it will work without any problem 
     */


    public NoSqlConnection()
    {
        System.out.println("NoSql Connection Initiated");
    }
}
