package com.chargebee.models;

import com.chargebee.*;
import com.chargebee.internal.*;
import com.chargebee.filters.*;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.internal.HttpUtil.Method;
import com.chargebee.models.enums.*;
import org.json.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class PaymentIntent extends Resource<PaymentIntent> {

    public enum Status {
        INITED,
        IN_PROGRESS,
        AUTHORIZED,
        CONSUMED,
        EXPIRED,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public static class PaymentAttempt extends Resource<PaymentAttempt> {
        public enum Status {
             INITED,REQUIRES_IDENTIFICATION,REQUIRES_CHALLENGE,REQUIRES_REDIRECTION,AUTHORIZED,REFUSED,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public PaymentAttempt(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String id() {
            return optString("id");
        }

        public Status status() {
            return reqEnum("status", Status.class);
        }

        public String idAtGateway() {
            return optString("id_at_gateway");
        }

        public String errorCode() {
            return optString("error_code");
        }

        public String errorText() {
            return optString("error_text");
        }

        public Timestamp createdAt() {
            return reqTimestamp("created_at");
        }

        public Timestamp modifiedAt() {
            return reqTimestamp("modified_at");
        }

    }

    //Constructors
    //============

    public PaymentIntent(String jsonStr) {
        super(jsonStr);
    }

    public PaymentIntent(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String id() {
        return reqString("id");
    }

    public Status status() {
        return reqEnum("status", Status.class);
    }

    public Integer amount() {
        return reqInteger("amount");
    }

    public String gatewayAccountId() {
        return reqString("gateway_account_id");
    }

    public Timestamp expiresAt() {
        return reqTimestamp("expires_at");
    }

    public String referenceId() {
        return optString("reference_id");
    }

    public Timestamp createdAt() {
        return reqTimestamp("created_at");
    }

    public Timestamp modifiedAt() {
        return reqTimestamp("modified_at");
    }

    public String customerId() {
        return reqString("customer_id");
    }

    public String gateway() {
        return optString("gateway");
    }

    public PaymentIntent.PaymentAttempt activePaymentAttempt() {
        return optSubResource("active_payment_attempt", PaymentIntent.PaymentAttempt.class);
    }

    // Operations
    //===========

    public static CreateRequest create() {
        String uri = uri("payment_intents");
        return new CreateRequest(Method.POST, uri);
    }

    public static UpdateRequest update(String id) {
        String uri = uri("payment_intents", nullCheck(id));
        return new UpdateRequest(Method.POST, uri);
    }

    public static Request retrieve(String id) {
        String uri = uri("payment_intents", nullCheck(id));
        return new Request(Method.GET, uri);
    }


    // Operation Request Classes
    //==========================

    public static class CreateRequest extends Request<CreateRequest> {

        private CreateRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public CreateRequest customerId(String customerId) {
            params.addOpt("customer_id", customerId);
            return this;
        }


        public CreateRequest amount(Integer amount) {
            params.add("amount", amount);
            return this;
        }


        public CreateRequest currencyCode(String currencyCode) {
            params.add("currency_code", currencyCode);
            return this;
        }


        public CreateRequest gatewayAccountId(String gatewayAccountId) {
            params.addOpt("gateway_account_id", gatewayAccountId);
            return this;
        }


        public CreateRequest referenceId(String referenceId) {
            params.addOpt("reference_id", referenceId);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class UpdateRequest extends Request<UpdateRequest> {

        private UpdateRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public UpdateRequest amount(Integer amount) {
            params.addOpt("amount", amount);
            return this;
        }


        public UpdateRequest currencyCode(String currencyCode) {
            params.addOpt("currency_code", currencyCode);
            return this;
        }


        public UpdateRequest gatewayAccountId(String gatewayAccountId) {
            params.addOpt("gateway_account_id", gatewayAccountId);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

}
