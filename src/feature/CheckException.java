package feature;

import exceptions.InvalidDOBException;
import exceptions.InvalidFullNameException;
import exceptions.InvalidPhoneNumberException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckException{
    public void nameException(String name) throws InvalidFullNameException {

    }

    public void doBException(Date date) throws InvalidDOBException{
        try{
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            dateFormat.format(date);
        }catch (Exception e){
            throw new InvalidDOBException("sai ngay thang cmnr");
        }
    }

    public void phoneNumberException(String phoneNumber) throws InvalidPhoneNumberException{
        Pattern pattern = Pattern.compile("^(090|098|091|031|035|038)\\d{7}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if(!(matcher.find() && matcher.group().equals(phoneNumber)))
            throw new InvalidPhoneNumberException("sdt deo hop le");
    }

}
