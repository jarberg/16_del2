package DTU.SWT_grp16.Controller;
import org.junit.jupiter.api.Test;

class GameControllerTest {

    @Test
    void setupGame() {
    }

    @Test
    void playGame() {
    }
}
/*
public class Main {

    public static void main(String[] args) {
        Regnemaskine r = new Regnemaskine();
        System.out.println("Resultat: " + r.sum.add(1,3));
    }
}

public class Regnemaskine {
    Sum sum;
    boolean testtilstand = false;//Hvis du ændrer denne værdi til true,
    //bruger regnemaskinen en stub i stedet
    //for den rigtige Sum
    Regnemaskine (){
        if (testtilstand) sum = new Sum_stub();
        else sum = new Sum();
    }
}

public class Sum_stub extends Sum { //’extends’ betyder at denne klasse
    //arver egenskaber fra Sum-klassen
    //Derfor kan den nu holdes i en
    //variabel af typen Sum
    int add (int a, int b){
        return 1;
    }
}

public class Sum { //Klassen Sum er ikke ændret
    int add(int a, int b) {
        return a+b;
    }
}
*/