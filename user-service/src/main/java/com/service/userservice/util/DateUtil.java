package com.service.userservice.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtil {
    private static Instant i;
    private static ZonedDateTime zonedDateTime;

    //method for return ZonedDateTime in utc deal with javaUtil date
    public static ZonedDateTime getTimeInUTC(Date date){
        i = date.toInstant();
        zonedDateTime = i.atZone(ZoneId.of("UTC"));
        return zonedDateTime;
    }

}
