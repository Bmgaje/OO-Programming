
package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
/** Class to Develop the GUI like input the values and error dialog
 * @author spart
 * @version final
 */
public class ShannonView extends GridPane {

	// Labels
	Label bandwidthLabel = new Label("Bandwidth:");
	Label ratioLabel = new Label("Signal to noise ratio:");
        Label maxRateLabel = new Label("Max Data Rate: ");

	// Fields
	TextField bandwidthField = new TextField();
	TextField ratioField = new TextField();
	TextField maxRateField = new TextField();
	
	// Buttons
	Button CalculateBTN = new Button("Calculate");
        /** Default constructor to call the layout form method and btn function method
         */
	public ShannonView() {
            
            layoutForm();
            btnFunction();
	}
        /** private layout method to setup the user dialog box
         */
	private void layoutForm() {
            
                this.maxRateField.setDisable(true);
            
		this.setHgap(10);
		this.setVgap(10);

		this.add(bandwidthLabel, 1, 1);
		this.add(ratioLabel, 1, 2);
                this.add(maxRateLabel, 1, 3);

		this.add(bandwidthField, 2, 1);
		this.add(ratioField, 2, 2);
                this.add(maxRateField,2,3);

		
	}
        /**private method to make the calculate button work
         */
        private void btnFunction(){
            // Add buttons and make them the same width
		VBox buttonBox = new VBox(CalculateBTN);
		CalculateBTN.setMaxWidth(Double.MAX_VALUE);
		this.add(buttonBox, 1, 3, 1, 5);
        }
}
