package feature;

import exceptions.InvalidDOBException;
import exceptions.InvalidFullNameException;
import exceptions.InvalidPhoneNumberException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckException{
    public void nameException(String name) throws InvalidFullNameException {
        if(name.length() > 50 || name.length() < 10)
            throw new InvalidFullNameException("ten deo dung");
    }

    public void doBException(LocalDate date) throws InvalidDOBException{
        String DATE_FORMAT = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        dateFormat.parse()
        try{
            dateFormat.format(date);
        }catch (Exception e){
            throw new InvalidDOBException("sai ngay thang cmnr");
        }
    }

    public void phoneNumberException(String phoneNumber) throws InvalidPhoneNumberException{
        Pattern pattern = Pattern.compile("090/098/091/031/035/038\\d{10}");
        Matcher matcher = pattern.matcher(phoneNumber);
        if(!(matcher.find() && matcher.group().equals(phoneNumber)))
            throw new InvalidPhoneNumberException("sdt deo hop le");
    }

}
