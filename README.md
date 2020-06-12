# SI_lab2_155062


# Втора лабораториска вежба по Софтверско инженерство

Гоце Пачемски, бр.индекс 155062


# Група на код:

Ја добив група 3


# Control Flow Graph

![../../Downloads/Lab02.png](../../Downloads/Lab02.png)


# Цикломатска комплексност
Имаме 31 гранка и 23 јазли и според оваа формула ќе добиеме дека цикоматската комплексност е: 31-23+2=10


# Тест случаи според критериумот Every statement

1.user=null

2.username=null || password=null 

3.username="goce1111" password="GOCE1111"

4.username="goce01" password="goce12"

5.username="goce01" password="goce1234"

6.username="goce01" password="Goce12!@"


# Тест случаи според критериумот Multiple condtition

1.username=null, password="anything"

2.username="anything" password=null

3.username="goce01" password="Goce12!@"

4.username="bilosto" password="12345678"

5.username="bilosto" password="Goceeeee"

6.username="bilosto" password="@@@@##$$" 

7.username="bilosto" password="Goce11@$"


# Објаснување на напишаните unit tests:

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

