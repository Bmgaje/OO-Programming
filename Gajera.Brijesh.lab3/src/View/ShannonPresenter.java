package View;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.ShannonsTheorem;

/**
 * Shannon presentor This class take the values from the user and check weather
 * it is correct or not and bind it for the calculation
 *@version final
 * @author Brijesh Gajera
 */
public class ShannonPresenter {

    private final ShannonsTheorem model;
    private final ShannonView view;
    private final SimpleStringProperty bandwidthInternal = new SimpleStringProperty();
    private final SimpleStringProperty ratioInternal = new SimpleStringProperty();

    /**
     * two arguements constructor that call the method to bind and attact the
     * view event
     *
     * @param model shannonTheorem
     * @param view ShannonView
     */
    public ShannonPresenter(ShannonsTheorem model, ShannonView view) {
        this.model = model;
        this.view = view;
        bindToModel();
        attachViewEvents();
    }

    /**
     * private method to bind the values to the model
     */
    private void bindToModel() {
        bandwidthInternal.bindBidirectional(model.getBandwidthProperty());
        ratioInternal.bindBidirectional(model.getSignalToNoiseRatioProperty());
    }

    /**
     * private method to bind the values to the view event or text that user inputed
     */
    private void attachViewEvents() {
        // could use handlers instead, 
        // but TextField would need mult. for app to work correctly
        view.bandwidthField.textProperty().bindBidirectional(bandwidthInternal);
        view.ratioField.textProperty().bindBidirectional(ratioInternal);
        view.CalculateBTN.setOnAction(e -> checkValue(new ActionEvent()));

    }
    /** this method check for the values and unappropriate or null values this throws an exception
     * @param event InputBandWidth,Ration
     */
    public void checkValue(ActionEvent event) {
        double value = 0;
        try {
            value = calculateMaxDataRate();

        } catch (NumberFormatException | NullPointerException e) {
            Alert alertBox = new Alert(Alert.AlertType.ERROR);
            alertBox.setTitle("Input Error");
            alertBox.setHeaderText("Please Enter Valid Numbers");

            alertBox.setContentText(model.getBandwidthProperty().get() + "\n" + model.getSignalToNoiseRatioProperty().get());

            alertBox.showAndWait();

            view.bandwidthField.setText("");
            view.maxRateField.setText("");
            return;
        }

        view.maxRateField.textProperty().bind(new ReadOnlyStringWrapper(String.format("%s", value)));

    }
    /** method to get the maxdata rate from the model class
     * @return 
     */
    private double calculateMaxDataRate() {
        double result = model.maxDataRate();
        return result;
    }
}
