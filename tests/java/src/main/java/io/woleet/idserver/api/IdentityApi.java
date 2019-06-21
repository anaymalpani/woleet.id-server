/*
 * Woleet.ID Server
 * This is Woleet.ID Server API documentation.
 *
 * OpenAPI spec version: 1.1.0
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
import io.woleet.idserver.api.model.IdentityResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdentityApi {
    private ApiClient apiClient;

    public IdentityApi() {
        this(Configuration.getDefaultApiClient());
    }

    public IdentityApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getIdentity
     * @param pubKey Public key to verify. (required)
     * @param leftData Left part of the random data to sign (should be generated randomly). (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getIdentityCall(String pubKey, String leftData, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/identity";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (pubKey != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("pubKey", pubKey));
        }

        if (leftData != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("leftData", leftData));
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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getIdentityValidateBeforeCall(String pubKey, String leftData, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'pubKey' is set
        if (pubKey == null) {
            throw new ApiException("Missing the required parameter 'pubKey' when calling getIdentity(Async)");
        }
        
        // verify the required parameter 'leftData' is set
        if (leftData == null) {
            throw new ApiException("Missing the required parameter 'leftData' when calling getIdentity(Async)");
        }
        

        com.squareup.okhttp.Call call = getIdentityCall(pubKey, leftData, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the identity of a user.
     * Use this endpoint to verify that the server knows a public key and to get the identity of the user associated to that key. &lt;br&gt;If the server controls the associated private key, it also signs some random data using the key pair and returns the produced signature along with the user identity. &lt;br&gt;The random data is built by concatenating the &#x60;leftData&#x60; parameter (provided by the client) and some random data generated by the server (returned in the &#x60;rightData&#x60; field). &lt;br&gt;The caller must verify that the produced signature is valid for the public key (this validate the ownership of the private key by the server). &lt;br&gt;The caller can optionally read the TLS certificate securing this endpoint to get the certified identity of the owner of the server. &lt;br&gt;This endpoint is not protected. It is recommended to expose it publicly. 
     * @param pubKey Public key to verify. (required)
     * @param leftData Left part of the random data to sign (should be generated randomly). (required)
     * @return IdentityResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IdentityResult getIdentity(String pubKey, String leftData) throws ApiException {
        ApiResponse<IdentityResult> resp = getIdentityWithHttpInfo(pubKey, leftData);
        return resp.getData();
    }

    /**
     * Get the identity of a user.
     * Use this endpoint to verify that the server knows a public key and to get the identity of the user associated to that key. &lt;br&gt;If the server controls the associated private key, it also signs some random data using the key pair and returns the produced signature along with the user identity. &lt;br&gt;The random data is built by concatenating the &#x60;leftData&#x60; parameter (provided by the client) and some random data generated by the server (returned in the &#x60;rightData&#x60; field). &lt;br&gt;The caller must verify that the produced signature is valid for the public key (this validate the ownership of the private key by the server). &lt;br&gt;The caller can optionally read the TLS certificate securing this endpoint to get the certified identity of the owner of the server. &lt;br&gt;This endpoint is not protected. It is recommended to expose it publicly. 
     * @param pubKey Public key to verify. (required)
     * @param leftData Left part of the random data to sign (should be generated randomly). (required)
     * @return ApiResponse&lt;IdentityResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IdentityResult> getIdentityWithHttpInfo(String pubKey, String leftData) throws ApiException {
        com.squareup.okhttp.Call call = getIdentityValidateBeforeCall(pubKey, leftData, null, null);
        Type localVarReturnType = new TypeToken<IdentityResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the identity of a user. (asynchronously)
     * Use this endpoint to verify that the server knows a public key and to get the identity of the user associated to that key. &lt;br&gt;If the server controls the associated private key, it also signs some random data using the key pair and returns the produced signature along with the user identity. &lt;br&gt;The random data is built by concatenating the &#x60;leftData&#x60; parameter (provided by the client) and some random data generated by the server (returned in the &#x60;rightData&#x60; field). &lt;br&gt;The caller must verify that the produced signature is valid for the public key (this validate the ownership of the private key by the server). &lt;br&gt;The caller can optionally read the TLS certificate securing this endpoint to get the certified identity of the owner of the server. &lt;br&gt;This endpoint is not protected. It is recommended to expose it publicly. 
     * @param pubKey Public key to verify. (required)
     * @param leftData Left part of the random data to sign (should be generated randomly). (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getIdentityAsync(String pubKey, String leftData, final ApiCallback<IdentityResult> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getIdentityValidateBeforeCall(pubKey, leftData, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IdentityResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
