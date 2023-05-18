package model;

import javafx.beans.property.SimpleStringProperty;

/** class that implements "model" for an MVC application that calculates
 * Shannon's Theorem
 *@version final
 * @author Brijesh Gajera
 */
public class ShannonsTheorem {

    SimpleStringProperty bandwidth = new SimpleStringProperty(this, "bandwidth", null);
    SimpleStringProperty signalToNoiseRatio = new SimpleStringProperty(this, "signalToNoiseRatio", null);

    /** multi-argument constructor
     *
     * @param bandwidth theBandwidth in Hertz
     * @param signalToNoiseRatio SNR in dB
     */
    public ShannonsTheorem(String bandwidth, String signalToNoiseRatio) {
        this.bandwidth.set(bandwidth);
        this.signalToNoiseRatio.set(signalToNoiseRatio);
    }
 
    /**] no-arg constructor sets fields to null
     */
    public ShannonsTheorem() {
        this(null, null);
    }

    /** getters for bandwidth
     * @return the bandWidth
     */
    public String getBandWidth() {
        return bandwidth.get();
    }

    /** settters for bandwidth
     * @param bandWidth the bandWidth to set
     */
    public void setBandWidth(String bandWidth) {
        this.bandwidth.set(bandWidth);
    }
    /** getters for bandwidth property
     * @return bandwidth
     */
    public SimpleStringProperty getBandwidthProperty() {

        return this.bandwidth;
    }
    /** getters for ratio property
     * @return ratio
     */
    public SimpleStringProperty getSignalToNoiseRatioProperty() {
        return this.signalToNoiseRatio;
    }

    /** getters for ratio
     * @return the signalToNoiseRatio
     */
    public String getSignalToNoiseRatio() {
        return signalToNoiseRatio.get();
    }

    /** setters for ratio 
     * @param signalToNoiseRatio the signalToNoiseRatio to set
     */
    public void setSignalToNoiseRatio(String signalToNoiseRatio) {
        this.signalToNoiseRatio.set(signalToNoiseRatio);
    }

    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    /** this method is to calculate the max data rate
     * @param BW the bandwidth
     * @param SNR the signal-to-noise-ratio
     * @return maximum data ratio
     */
    public double maxDataRate(double BW, double SNR) {

        double SN = Math.pow(10, SNR / 10);
        return BW * log2(1 + SN);
    }

    /** this method is to return the max data rate
     * @return maximum data Rate
     */
    public double maxDataRate() {

        return maxDataRate(Double.parseDouble(bandwidth.get()), Double.parseDouble(signalToNoiseRatio.get()));
    }
   
   

}
