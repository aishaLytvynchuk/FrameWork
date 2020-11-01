package org.litvinchuk;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ConfigProperties extends Config{

    @Key("validEmail")
    String validEmail();

    @Key("validPassword")
    String validPassword();


    @Key("invalidEmail1")
    String invalidEmail1();

    @Key("invalidEmail2")
    String invalidEmail2();

    @Key("invalidPassword1")
    String invalidPassword1();

    @Key("invalidPassword2")
    String invalidPassword2();

    @Key("emailErrorMessage")
    String emailErrorMessage();

    @Key("credentialsMessageError")
    String credentialsMessageError();

    @Key("firstName")
    String firstName();

    @Key("lastName")
    String lastName();

    @Key("company")
    String company();

    @Key("country")
    String country();

    @Key("state")
    String state();

    @Key("city")
    String city();

    @Key("address1")
    String address1();

    @Key("address2")
    String address2();

    @Key("postalCode")
    String postalCode();

    @Key("phoneNumber")
    String phoneNumber();

    @Key("faxNumber")
    String faxNumber();
}

