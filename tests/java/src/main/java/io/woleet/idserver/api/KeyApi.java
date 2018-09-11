/*
 * Woleet.ID Server
 * This is Woleet.ID Server API documentation.
 *
 * OpenAPI spec version: 1.0.0
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
import io.woleet.idserver.api.model.KeyArray;
import io.woleet.idserver.api.model.KeyBase;
import io.woleet.idserver.api.model.KeyGet;
import io.woleet.idserver.api.model.KeyPost;
import io.woleet.idserver.api.model.KeyPut;
import io.woleet.idserver.api.model.Mnemonics;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyApi {
    private ApiClient apiClient;

    public KeyApi() {
        this(Configuration.getDefaultApiClient());
    }

    public KeyApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createKey
     * @param userId Identifier of the user. (required)
     * @param keyPost Key object to add. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createKeyCall(UUID userId, KeyPost keyPost, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = keyPost;

        // create path and map variables
        String localVarPath = "/user/{userId}/key"
            .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createKeyValidateBeforeCall(UUID userId, KeyPost keyPost, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling createKey(Async)");
        }
        
        // verify the required parameter 'keyPost' is set
        if (keyPost == null) {
            throw new ApiException("Missing the required parameter 'keyPost' when calling createKey(Async)");
        }
        

        com.squareup.okhttp.Call call = createKeyCall(userId, keyPost, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a new key for a user.
     * 
     * @param userId Identifier of the user. (required)
     * @param keyPost Key object to add. (required)
     * @return KeyGet
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public KeyGet createKey(UUID userId, KeyPost keyPost) throws ApiException {
        ApiResponse<KeyGet> resp = createKeyWithHttpInfo(userId, keyPost);
        return resp.getData();
    }

    /**
     * Create a new key for a user.
     * 
     * @param userId Identifier of the user. (required)
     * @param keyPost Key object to add. (required)
     * @return ApiResponse&lt;KeyGet&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<KeyGet> createKeyWithHttpInfo(UUID userId, KeyPost keyPost) throws ApiException {
        com.squareup.okhttp.Call call = createKeyValidateBeforeCall(userId, keyPost, null, null);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new key for a user. (asynchronously)
     * 
     * @param userId Identifier of the user. (required)
     * @param keyPost Key object to add. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createKeyAsync(UUID userId, KeyPost keyPost, final ApiCallback<KeyGet> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createKeyValidateBeforeCall(userId, keyPost, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteKey
     * @param keyId Identifier of the key. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteKeyCall(UUID keyId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/key/{keyId}"
            .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteKeyValidateBeforeCall(UUID keyId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new ApiException("Missing the required parameter 'keyId' when calling deleteKey(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteKeyCall(keyId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete a key.
     * 
     * @param keyId Identifier of the key. (required)
     * @return KeyGet
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public KeyGet deleteKey(UUID keyId) throws ApiException {
        ApiResponse<KeyGet> resp = deleteKeyWithHttpInfo(keyId);
        return resp.getData();
    }

    /**
     * Delete a key.
     * 
     * @param keyId Identifier of the key. (required)
     * @return ApiResponse&lt;KeyGet&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<KeyGet> deleteKeyWithHttpInfo(UUID keyId) throws ApiException {
        com.squareup.okhttp.Call call = deleteKeyValidateBeforeCall(keyId, null, null);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a key. (asynchronously)
     * 
     * @param keyId Identifier of the key. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteKeyAsync(UUID keyId, final ApiCallback<KeyGet> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteKeyValidateBeforeCall(keyId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for exportKey
     * @param keyId Identifier of the key. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call exportKeyCall(UUID keyId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/key/{keyId}/export"
            .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call exportKeyValidateBeforeCall(UUID keyId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new ApiException("Missing the required parameter 'keyId' when calling exportKey(Async)");
        }
        

        com.squareup.okhttp.Call call = exportKeyCall(keyId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the mnemonic words associated to a key.
     * Get the list of mnemonic words that can be used to backup and recover a key.
     * @param keyId Identifier of the key. (required)
     * @return Mnemonics
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Mnemonics exportKey(UUID keyId) throws ApiException {
        ApiResponse<Mnemonics> resp = exportKeyWithHttpInfo(keyId);
        return resp.getData();
    }

    /**
     * Get the mnemonic words associated to a key.
     * Get the list of mnemonic words that can be used to backup and recover a key.
     * @param keyId Identifier of the key. (required)
     * @return ApiResponse&lt;Mnemonics&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Mnemonics> exportKeyWithHttpInfo(UUID keyId) throws ApiException {
        com.squareup.okhttp.Call call = exportKeyValidateBeforeCall(keyId, null, null);
        Type localVarReturnType = new TypeToken<Mnemonics>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the mnemonic words associated to a key. (asynchronously)
     * Get the list of mnemonic words that can be used to backup and recover a key.
     * @param keyId Identifier of the key. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call exportKeyAsync(UUID keyId, final ApiCallback<Mnemonics> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = exportKeyValidateBeforeCall(keyId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Mnemonics>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAllUserKeys
     * @param userId Identifier of the user. (required)
     * @param full Include deleted elements in the returned list. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAllUserKeysCall(UUID userId, Boolean full, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/user/{userId}/key/list"
            .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (full != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("full", full));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAllUserKeysValidateBeforeCall(UUID userId, Boolean full, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling getAllUserKeys(Async)");
        }
        

        com.squareup.okhttp.Call call = getAllUserKeysCall(userId, full, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List all keys of a user.
     * 
     * @param userId Identifier of the user. (required)
     * @param full Include deleted elements in the returned list. (optional)
     * @return KeyArray
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public KeyArray getAllUserKeys(UUID userId, Boolean full) throws ApiException {
        ApiResponse<KeyArray> resp = getAllUserKeysWithHttpInfo(userId, full);
        return resp.getData();
    }

    /**
     * List all keys of a user.
     * 
     * @param userId Identifier of the user. (required)
     * @param full Include deleted elements in the returned list. (optional)
     * @return ApiResponse&lt;KeyArray&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<KeyArray> getAllUserKeysWithHttpInfo(UUID userId, Boolean full) throws ApiException {
        com.squareup.okhttp.Call call = getAllUserKeysValidateBeforeCall(userId, full, null, null);
        Type localVarReturnType = new TypeToken<KeyArray>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List all keys of a user. (asynchronously)
     * 
     * @param userId Identifier of the user. (required)
     * @param full Include deleted elements in the returned list. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAllUserKeysAsync(UUID userId, Boolean full, final ApiCallback<KeyArray> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getAllUserKeysValidateBeforeCall(userId, full, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<KeyArray>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getKeyById
     * @param keyId Identifier of the key. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getKeyByIdCall(UUID keyId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/key/{keyId}"
            .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getKeyByIdValidateBeforeCall(UUID keyId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new ApiException("Missing the required parameter 'keyId' when calling getKeyById(Async)");
        }
        

        com.squareup.okhttp.Call call = getKeyByIdCall(keyId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a key by its identifier.
     * 
     * @param keyId Identifier of the key. (required)
     * @return KeyGet
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public KeyGet getKeyById(UUID keyId) throws ApiException {
        ApiResponse<KeyGet> resp = getKeyByIdWithHttpInfo(keyId);
        return resp.getData();
    }

    /**
     * Get a key by its identifier.
     * 
     * @param keyId Identifier of the key. (required)
     * @return ApiResponse&lt;KeyGet&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<KeyGet> getKeyByIdWithHttpInfo(UUID keyId) throws ApiException {
        com.squareup.okhttp.Call call = getKeyByIdValidateBeforeCall(keyId, null, null);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a key by its identifier. (asynchronously)
     * 
     * @param keyId Identifier of the key. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getKeyByIdAsync(UUID keyId, final ApiCallback<KeyGet> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getKeyByIdValidateBeforeCall(keyId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateKey
     * @param keyId Identifier of the key. (required)
     * @param keyPut Replacement key object. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateKeyCall(UUID keyId, KeyPut keyPut, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = keyPut;

        // create path and map variables
        String localVarPath = "/key/{keyId}"
            .replaceAll("\\{" + "keyId" + "\\}", apiClient.escapeString(keyId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
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

        String[] localVarAuthNames = new String[] { "CookieAuth" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateKeyValidateBeforeCall(UUID keyId, KeyPut keyPut, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'keyId' is set
        if (keyId == null) {
            throw new ApiException("Missing the required parameter 'keyId' when calling updateKey(Async)");
        }
        
        // verify the required parameter 'keyPut' is set
        if (keyPut == null) {
            throw new ApiException("Missing the required parameter 'keyPut' when calling updateKey(Async)");
        }
        

        com.squareup.okhttp.Call call = updateKeyCall(keyId, keyPut, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update a key.
     * 
     * @param keyId Identifier of the key. (required)
     * @param keyPut Replacement key object. (required)
     * @return KeyGet
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public KeyGet updateKey(UUID keyId, KeyPut keyPut) throws ApiException {
        ApiResponse<KeyGet> resp = updateKeyWithHttpInfo(keyId, keyPut);
        return resp.getData();
    }

    /**
     * Update a key.
     * 
     * @param keyId Identifier of the key. (required)
     * @param keyPut Replacement key object. (required)
     * @return ApiResponse&lt;KeyGet&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<KeyGet> updateKeyWithHttpInfo(UUID keyId, KeyPut keyPut) throws ApiException {
        com.squareup.okhttp.Call call = updateKeyValidateBeforeCall(keyId, keyPut, null, null);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a key. (asynchronously)
     * 
     * @param keyId Identifier of the key. (required)
     * @param keyPut Replacement key object. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateKeyAsync(UUID keyId, KeyPut keyPut, final ApiCallback<KeyGet> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateKeyValidateBeforeCall(keyId, keyPut, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<KeyGet>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
