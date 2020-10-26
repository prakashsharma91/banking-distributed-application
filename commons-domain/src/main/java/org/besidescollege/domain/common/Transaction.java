package org.besidescollege.domain.common;

import java.sql.Date;

public abstract class Transaction {
    String fromAccountId;
    String toAccountId;
    Double amount;
    Date date;
}
