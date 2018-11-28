/*
 * Woleet.ID Server
 * This is Woleet.ID Server API documentation.
 *
 * OpenAPI spec version: 1.0.4
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.woleet.idserver.api;

import io.woleet.idserver.ApiCallback;
import io.woleet.idserver.ApiClient;
import io.woleet.idserver.ApiException;
import io.woleet.idserver.ApiResponse;
import io.woleet.idserver.Configuration;
import io.woleet.idserver.Pair;
import io.woleet.idserver.ProgressRequestBody;
import io.woleet.idserver.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.woleet.idserver.api.model.APIError;
import io.woleet.idserver.api.model.SignatureResult;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignatureApi {
    private ApiClient apiClient;

    public SignatureApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SignatureApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getSignature
     * @param hashToSign SHA256 hash to be signed (a string formatted like [a-f0-9]{64}). (required)
     * @param userId User identifier. (optional)
     * @param customUserId Custom user identifier (ie. &#x60;userId&#x60; field of the user&#39;s identity). (optional)
     * @param pubKey The public key to use to sign. &lt;br&gt;When not provided and a user is provided, the default key of the user is used (if any). &lt;br&gt;When not provided and no user is provided, the default key of the server is used (if any).  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getSignatureCall(String hashToSign, UUID userId, String customUserId, String pubKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/sign";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (hashToSign != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("hashToSign", hashToSign));
        }

        if (userId != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("userId", userId));
        }

        if (customUserId != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("customUserId", customUserId));
        }

        if (pubKey != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("pubKey", pubKey));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "APITokenAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSignatureValidateBeforeCall(String hashToSign, UUID userId, String customUserId, String pubKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'hashToSign' is set
        if (hashToSign == null) {
            throw new ApiException("Missing the required parameter 'hashToSign' when calling getSignature(Async)");
        }
        

        com.squareup.okhttp.Call call = getSignatureCall(hashToSign, userId, customUserId, pubKey, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Sign some data using a key.
     * Use this endpoint to sign some data using one of the keys managed by the server. &lt;br&gt;Provide the SHA256 hash of the data to sign in the &#x60;hashToSign&#x60; parameter. &lt;br&gt;The key to use can be specified using the &#x60;pubKey&#x60;, &#x60;userId&#x60; and &#x60;customUserId&#x60; parameters: &lt;br&gt;- set the &#x60;pubKey&#x60; parameter only: the referred key is used &lt;br&gt;- set the &#x60;userId&#x60; (or the &#x60;customUserId&#x60;) parameter only: the default key of the referred user is used (if any). &lt;br&gt;- set none of the 3 parameters: the default key of the server is used (if any). &lt;br&gt;The signature produced is the signature of the hash using the referred key. &lt;br&gt;This endpoint is protected using an API token. It is recommended not to expose it publicly. 
     * @param hashToSign SHA256 hash to be signed (a string formatted like [a-f0-9]{64}). (required)
     * @param userId User identifier. (optional)
     * @param customUserId Custom user identifier (ie. &#x60;userId&#x60; field of the user&#39;s identity). (optional)
     * @param pubKey The public key to use to sign. &lt;br&gt;When not provided and a user is provided, the default key of the user is used (if any). &lt;br&gt;When not provided and no user is provided, the default key of the server is used (if any).  (optional)
     * @return SignatureResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SignatureResult getSignature(String hashToSign, UUID userId, String customUserId, String pubKey) throws ApiException {
        ApiResponse<SignatureResult> resp = getSignatureWithHttpInfo(hashToSign, userId, customUserId, pubKey);
        return resp.getData();
    }

    /**
     * Sign some data using a key.
     * Use this endpoint to sign some data using one of the keys managed by the server. &lt;br&gt;Provide the SHA256 hash of the data to sign in the &#x60;hashToSign&#x60; parameter. &lt;br&gt;The key to use can be specified using the &#x60;pubKey&#x60;, &#x60;userId&#x60; and &#x60;customUserId&#x60; parameters: &lt;br&gt;- set the &#x60;pubKey&#x60; parameter only: the referred key is used &lt;br&gt;- set the &#x60;userId&#x60; (or the &#x60;customUserId&#x60;) parameter only: the default key of the referred user is used (if any). &lt;br&gt;- set none of the 3 parameters: the default key of the server is used (if any). &lt;br&gt;The signature produced is the signature of the hash using the referred key. &lt;br&gt;This endpoint is protected using an API token. It is recommended not to expose it publicly. 
     * @param hashToSign SHA256 hash to be signed (a string formatted like [a-f0-9]{64}). (required)
     * @param userId User identifier. (optional)
     * @param customUserId Custom user identifier (ie. &#x60;userId&#x60; field of the user&#39;s identity). (optional)
     * @param pubKey The public key to use to sign. &lt;br&gt;When not provided and a user is provided, the default key of the user is used (if any). &lt;br&gt;When not provided and no user is provided, the default key of the server is used (if any).  (optional)
     * @return ApiResponse&lt;SignatureResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SignatureResult> getSignatureWithHttpInfo(String hashToSign, UUID userId, String customUserId, String pubKey) throws ApiException {
        com.squareup.okhttp.Call call = getSignatureValidateBeforeCall(hashToSign, userId, customUserId, pubKey, null, null);
        Type localVarReturnType = new TypeToken<SignatureResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Sign some data using a key. (asynchronously)
     * Use this endpoint to sign some data using one of the keys managed by the server. &lt;br&gt;Provide the SHA256 hash of the data to sign in the &#x60;hashToSign&#x60; parameter. &lt;br&gt;The key to use can be specified using the &#x60;pubKey&#x60;, &#x60;userId&#x60; and &#x60;customUserId&#x60; parameters: &lt;br&gt;- set the &#x60;pubKey&#x60; parameter only: the referred key is used &lt;br&gt;- set the &#x60;userId&#x60; (or the &#x60;customUserId&#x60;) parameter only: the default key of the referred user is used (if any). &lt;br&gt;- set none of the 3 parameters: the default key of the server is used (if any). &lt;br&gt;The signature produced is the signature of the hash using the referred key. &lt;br&gt;This endpoint is protected using an API token. It is recommended not to expose it publicly. 
     * @param hashToSign SHA256 hash to be signed (a string formatted like [a-f0-9]{64}). (required)
     * @param userId User identifier. (optional)
     * @param customUserId Custom user identifier (ie. &#x60;userId&#x60; field of the user&#39;s identity). (optional)
     * @param pubKey The public key to use to sign. &lt;br&gt;When not provided and a user is provided, the default key of the user is used (if any). &lt;br&gt;When not provided and no user is provided, the default key of the server is used (if any).  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSignatureAsync(String hashToSign, UUID userId, String customUserId, String pubKey, final ApiCallback<SignatureResult> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getSignatureValidateBeforeCall(hashToSign, userId, customUserId, pubKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SignatureResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
