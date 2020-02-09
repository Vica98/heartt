package com.example.heartt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.atomic.LongAdder;

public class PaymentActivity extends AppCompatActivity {

    private PaymentsClient paymentsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Wallet.WalletOptions walletOptions =
                new Wallet.WalletOptions.Builder()
                        .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
                        .build();

        paymentsClient = Wallet.getPaymentsClient
                (this, walletOptions);

        setContentView(R.layout.activity_payment);
        Intent intent = getIntent();


        IsReadyToPayRequest readyToPayRequest =
                IsReadyToPayRequest.fromJson(baseConfigurationJson().toString());


        Task<Boolean> task = paymentsClient.isReadyToPay(readyToPayRequest);
        task.addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
            public void onComplete(@NonNull Task<Boolean> completeTask) {
                if (completeTask.isSuccessful()) {
                    showGooglePayButton(completeTask.getResult());
                } else {
                    //whatever else
                }
            }
        });

        private static JSONObject baseConfigurationJson() {
            return new JSONObject()
                    .put("apiVersion", 2)
                    .put("apiVersionMinor", 0)
                    .put("allowedPaymentMethods",
                            new JSONArray().put(getCardPaymentMethod()));
        }

        private void showGooglePayButton(boolean userIsReadyToPay){
            if (userIsReadyToPay) {
                //update ui to show button
                //ex googlePayButton.setVisibility(View.VISIBLE)

            } else {
                //do not show
            }
        }

        final JSONObject paymentRequestJson = baseConfigurationJson();
        paymentRequestJson.put("transactionInfo", new JSONObject()
                .put("totalPrice", "5.99")
                .put("totalPriceStatus", "FINAL")
                .put("currencyCode", "USD"));

        paymentRequestJson.put("merchantInfo", new JSONObject()
                .put("merchantId", "01234567890123456789")
                .put("merchantName", "Example Merchant"));

        private static JSONObject getCardPaymentMethod() {
            final String[] networks = new String[]{"VISA", "AMEX"};
            final String[] authMethods =
                    new String[]{"PAN_ONLY", "CRYPTOGRAM_3DS"};

            JSONObject card = new JSONObject();
            card.put("type", "CARD");
            card.put("tokenizationSpecification", getTokenizationSpec());
            card.put("parameters", new JSONObject()
                    .put("allowedAuthMethods", new JSONArray(authMethods))
                    .put("allowedCardNetworks", new JSONArray(networks)));

            return card;
        }

        final PaymentDataRequest request =
                PaymentDataRequest.fromJson(paymentRequestJson.toString());

        AutoResolveHelper.resolveTask(
                paymentsClient.loadPaymentData(request),
                this, LOAD_PAYMENT_DATA_REQUEST_CODE);

    }
}