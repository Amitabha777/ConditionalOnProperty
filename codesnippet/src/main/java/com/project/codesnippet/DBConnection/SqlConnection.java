package com.project.codesnippet.DBConnection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
                        prefix= "sqlConnection",                        //Here Prefix+Value is the Key
                        value = "enabled", 
                        havingValue = "true",                    //havingValue is the Value & together they constitute key value pair 
                        matchIfMissing = true)                               // Which we will define/pass values in Properties file                 
public class SqlConnection {
    

    /* 
     ! matchIfMissing is used to check if the key value pair is declared in Properties file or not

     !                      If its not Declared & matchIfMissing is False,
     
     ?                                      Then it means that as the Property in properties file is Missing,
     ?                                              so Condition Match is False
     
     !                  Which means as Condition is False so Object will Not be Created

     ?      But if matchIfMissing is True,
     ?                                      It means even if property is Missing, Condition is True so Object should be Created
     */



    public SqlConnection()
    {
        System.out.println("SqlConnection Initialized");
    }
}
