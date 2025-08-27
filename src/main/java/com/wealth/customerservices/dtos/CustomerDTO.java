package com.wealth.customerservices.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    protected long accountNo;

    protected  String email;

    protected  String password;

    protected  long phoneNumber;

}
