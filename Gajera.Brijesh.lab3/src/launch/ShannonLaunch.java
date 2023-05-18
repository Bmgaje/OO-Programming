
package launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import View.ShannonView;
import model.ShannonsTheorem;
import View.ShannonPresenter;
/** this is the main launcher class
 * @author Brijesh Gajera
 * @version final
 */
public class ShannonLaunch extends Application {
    /** main method to launch the application 
     * @param args String
     */
	public static void main(String[] args) {
		Application.launch(args);
	}
        /** overriden method to Start and call the model viewer and presenter
         * @param stage Stages
         */
	@Override
	public void start(Stage stage) {
		ShannonsTheorem model;
                
                model = new model.ShannonsTheorem();
		ShannonView viewer = new ShannonView();

		Scene scene = new Scene(viewer);

		ShannonPresenter presenter = new ShannonPresenter(model, viewer);
		
		stage.setScene(scene);
		stage.setTitle("Shannon Theorem (Lab 3)");
		stage.show();
	}
}
