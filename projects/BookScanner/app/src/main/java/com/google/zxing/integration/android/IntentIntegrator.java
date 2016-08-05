package com.google.zxing.integration.android;

import android.app.Activity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by audreyeso on 8/5/16.
 */
public class IntentIntegrator {

    public static final int REQUEST_CODE = 0x0000c0de;
    private static final String TAG = IntentIntegrator.class.getSimpleName();

    public static final String DEFAULT_TITLE = "Install Barcode Scanner";
    public static final String DEFAULT_MESSAGE = "This application requires Barcode Scanner."+
            "Would you like to install it?";
    public static final String DEFAULT_YES = "Yes";
    public static final String DEFAULT_NO = "No";

    private static final String SCANNER_PACKAGE ="google.zxing.integration.android";

    //may have to change scannplus package
    private static final String SCANNERPLUS_PACKAGE ="com.srowen.bs.android";

    //supports barcode formats

    public static final Collection<String> PRODUCT_CODE_TYPES = list("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");
    public static final Collection<String> ONE_D_CODE_TYPES =
            list("UPC_A", "UPC_E", "EAN_8", "EAN_13", "CODE_39", "CODE_93", "CODE_128",
                    "ITF", "RSS_14", "RSS_EXPANDED");
    public static final Collection<String> QR_CODE_TYPES = Collections.singleton("QR_CODE");
    public static final Collection<String> DATA_MATRIX_TYPES = Collections.singleton("DATA_MATRIX");
    public static final Collection<String> ALL_CODE_TYPES = null;
    public static final List<String> TARGET_BARCODE_SCANNER_ONLY = Collections.singletonList(SCANNER_PACKAGE);
    public static final List<String> TARGET_ALL_KNOWN = list(
            SCANNER_PACKAGE, // Barcode Scanner
            SCANNERPLUS_PACKAGE, // Barcode Scanner+
            SCANNERPLUS_PACKAGE + ".simple" // Barcode Scanner+ Simple
// What else supports this intent?
    );

    private final Activity activity;
    private String title;
    private String message;
    private String buttonYes;
    private String buttonNo;
    private List<String> targetApplications;
    private final Map<String,Object> moreExtras;

    public IntentIntegrator(Activity activity) {
        this.activity = activity;
        title = DEFAULT_TITLE;
        message = DEFAULT_MESSAGE;
        buttonYes = DEFAULT_YES;
        buttonNo = DEFAULT_NO;
        targetApplications = TARGET_ALL_KNOWN;
        moreExtras = new HashMap<String,Object>(3);

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setTitleByID(int titleID) {
        title = activity.getString(titleID);
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setMessageByID(int messageID) {
        message = activity.getString(messageID);
    }
    public String getButtonYes() {
        return buttonYes;
    }
    public void setButtonYes(String buttonYes) {
        this.buttonYes = buttonYes;
    }
    public void setButtonYesByID(int buttonYesID) {
        buttonYes = activity.getString(buttonYesID);
    }
    public String getButtonNo() {
        return buttonNo;
    }
    public void setButtonNo(String buttonNo) {
        this.buttonNo = buttonNo;
    }
    public void setButtonNoByID(int buttonNoID) {
        buttonNo = activity.getString(buttonNoID);
    }
    }

