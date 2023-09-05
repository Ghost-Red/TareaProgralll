package cr.ac.una.unaplanilla;

import cr.ac.una.unaplanilla.model.Gasto;
import cr.ac.una.unaplanilla.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;
import cr.ac.una.unaplanilla.model.Gasto;
import cr.ac.una.unaplanilla.model.Salonero;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage,null);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/cr/ac/una/unaplanilla/resources/LogoUNArojo.png")));
        stage.setTitle("UNA PLANILLA");
        FlowController.getInstance().goViewInWindow("LogInView");
    }
    
    Predicate<Salonero> xEdad (Integer edad){
        return x->x.getEdad()>edad;
    }
    Predicate<Salonero> xPropina (double monto){
        return x->x.getPropina().equals(monto);
    }
    Predicate<Salonero> temporal =x->!x.getTemporal();
    public static void main(String[] args) {
        
        /*ArrayList<Gasto>gastosTotales=new ArrayList<>();
        gastosTotales.add(new Gasto(20.0,"comida"));
        gastosTotales.add(new Gasto(5.0,"hotel"));
        Stream<Gasto> stream = gastosTotales.stream();
        double monto= stream.filter(x->x.getMonto()<100).mapToDouble(x->x.getMonto()).sum();
        System.out.println(monto);*/
        /*
        ArrayList<Salonero>saloneros=new ArrayList<>();
        saloneros.add(new Salonero(45, false, 5000.0, 200.0));
        saloneros.add(new Salonero(50, true, 5000.0, 500.0));
        saloneros.add(new Salonero(42, true, 5000.0, 200.0));
        saloneros.add(new Salonero(35, true, 5000.0,200.0));
        Stream montoMin=saloneros.stream();
        double propinaMin= (double)montoMin.min(Comparator.comparing(Salonero::getPropina)).get();*/
        launch();
        
    }
    
    
    
    
    

}