import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private final SILab2 siLab2= new SILab2();
    @Test
    void everystatmen() {
        RuntimeException exception;
        //koga ke nemame user treba da frli exception so soodvetnata poraka
        exception=assertThrows(RuntimeException.class, () -> siLab2.function(null,null));
        assertTrue(exception.getMessage().contains("The user is not instantiated"));

        //Koga za username ili za password nema da ima vneseno nisto t.e. ke bide null treba da frli exception so soodvetna poraka
        exception=assertThrows(RuntimeException.class, ()-> siLab2.function(new User(null,"goce","goce"),null));
        assertTrue(exception.getMessage().contains("The user is missing some mandatory information"));

        //Koga username i password ke bidat isti no passwordor da bide samo so golemi bukvi treba da vratime false
        assertFalse(siLab2.function(new User("goce1111","GOCE1111","goce@gmail.com"),null));

        //Koga password-ot ke bide pomalku od 8 karakteri da vrati false
        assertFalse(siLab2.function(new User("goce01","goce12","goce@gmail.com"),null));

        //Koga passwordot nema da go ispolni eden od trite kriteriumite t.e da ima golema bukva brojka i znak da vrati false
        assertFalse(siLab2.function(new User("goce01","goce1234","goce@gmail.com"),null));

        //Koga za passwordot ke vneseme da gi ispolnuva site kriteriumi odnosno da ima i golema bukva i brojka i znak i ke vrati true
        assertTrue(siLab2.function(new User("goce01","Goce12!@","goce@gmail.com"),null));




    }

    @Test
    void mutipleconditions(){
        //T || X
        // Koga username ke bide null a passwordot moze da e bilo sto treba da frli exception so soodvetna poraka
        RuntimeException exception;
        exception=assertThrows(RuntimeException.class,
                ()-> siLab2.function(new User(null,"bilosto","bilosto"),null));
        assertTrue(exception.getMessage().contains("The user is missing some mandatory information"));

        //X || T
        //Koga username e bilo sto a passwordot e null ke frli exception so soodvetnata poraka
        exception=assertThrows(RuntimeException.class,
                ()-> siLab2.function(new User("bilosto",null,"bilosto"),null));
        assertTrue(exception.getMessage().contains("The user is missing some mandatory information"));

        // F || F
        //Koga i username i password ke imaat nekoa vrednost i nema da bide ispolnet uslovot vo if-ot
        assertTrue(siLab2.function(new User("goce01","Goce12!@","goce@gmail.com"),null));

        // T || X || X
        //Koga vo passwordot ke nemame cifri a za golema bukva i za znak moze i da ima i da nema sepak ke vrati false bidejki nema cifra
        assertFalse(siLab2.function(new User("goce01","nemaCifra","goce@gmail.com"),null));

        // X || T || X
        //Koga vo passwordot ke nemame golema bukva bez razlika dali imame cifra i znak ke vrati false
        assertFalse(siLab2.function(new User("goce01","nema_golemi_bukvi","goce@gmail.com"),null));

        // X || X || T
        //Koga vo passwordot ke nemame znak bez razlika dali ima golema bukva i cifraa ke vrati false
        assertFalse(siLab2.function(new User("goce01","nemaZnak","goce@gmail.com"),null));

        // F || F || F
        //I koga ke ima i golema bukva i znak i cifra if-ot nema da bide ispolent i nema da vleze vo nego i ke vrati true
        assertTrue(siLab2.function(new User("goce01","Goce11@$","goce@gmail.com"),null));
    }

}