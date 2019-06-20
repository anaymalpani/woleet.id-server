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
import io.woleet.idserver.api.model.ConfigDisco;
import io.woleet.idserver.api.model.KeyDisco;
import java.util.UUID;
import io.woleet.idserver.api.model.UserDisco;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscoveryApi {
    private ApiClient apiClient;

    public DiscoveryApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DiscoveryApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for discoverConfig
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call discoverConfigCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/discover/config";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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

        String[] localVarAuthNames = new String[] { "APITokenAuth", "OAuthTokenAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call discoverConfigValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = discoverConfigCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the discovery server config.
     * Use this endpoint to get the server config needed for the other discorvery endpoint. 
     * @return ConfigDisco
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConfigDisco discoverConfig() throws ApiException {
        ApiResponse<ConfigDisco> resp = discoverConfigWithHttpInfo();
        return resp.getData();
    }

    /**
     * Get the discovery server config.
     * Use this endpoint to get the server config needed for the other discorvery endpoint. 
     * @return ApiResponse&lt;ConfigDisco&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConfigDisco> discoverConfigWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = discoverConfigValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<ConfigDisco>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the discovery server config. (asynchronously)
     * Use this endpoint to get the server config needed for the other discorvery endpoint. 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call discoverConfigAsync(final ApiCallback<ConfigDisco> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = discoverConfigValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConfigDisco>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for discoverUser
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call discoverUserCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/discover/user";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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

        String[] localVarAuthNames = new String[] { "APITokenAuth", "OAuthTokenAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call discoverUserValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = discoverUserCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get information about the current user.
     * Use this endpoint to get information about the current user. 
     * @return UserDisco
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserDisco discoverUser() throws ApiException {
        ApiResponse<UserDisco> resp = discoverUserWithHttpInfo();
        return resp.getData();
    }

    /**
     * Get information about the current user.
     * Use this endpoint to get information about the current user. 
     * @return ApiResponse&lt;UserDisco&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserDisco> discoverUserWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = discoverUserValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<UserDisco>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get information about the current user. (asynchronously)
     * Use this endpoint to get information about the current user. 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call discoverUserAsync(final ApiCallback<UserDisco> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = discoverUserValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserDisco>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for discoverUserByPubKey
     * @param pubKey Public key (bitcoin address when using BIP39 keys). (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call discoverUserByPubKeyCall(String pubKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/discover/user/{pubKey}"
            .replaceAll("\\{" + "pubKey" + "\\}", apiClient.escapeString(pubKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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

        String[] localVarAuthNames = new String[] { "APITokenAuth", "OAuthTokenAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call discoverUserByPubKeyValidateBeforeCall(String pubKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'pubKey' is set
        if (pubKey == null) {
            throw new ApiException("Missing the required parameter 'pubKey' when calling discoverUserByPubKey(Async)");
        }
        

        com.squareup.okhttp.Call call = discoverUserByPubKeyCall(pubKey, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the user associated to a public key.
     * Use this endpoint to get the user owning a given public key. 
     * @param pubKey Public key (bitcoin address when using BIP39 keys). (required)
     * @return UserDisco
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UserDisco discoverUserByPubKey(String pubKey) throws ApiException {
        ApiResponse<UserDisco> resp = discoverUserByPubKeyWithHttpInfo(pubKey);
        return resp.getData();
    }

    /**
     * Get the user associated to a public key.
     * Use this endpoint to get the user owning a given public key. 
     * @param pubKey Public key (bitcoin address when using BIP39 keys). (required)
     * @return ApiResponse&lt;UserDisco&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UserDisco> discoverUserByPubKeyWithHttpInfo(String pubKey) throws ApiException {
        com.squareup.okhttp.Call call = discoverUserByPubKeyValidateBeforeCall(pubKey, null, null);
        Type localVarReturnType = new TypeToken<UserDisco>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the user associated to a public key. (asynchronously)
     * Use this endpoint to get the user owning a given public key. 
     * @param pubKey Public key (bitcoin address when using BIP39 keys). (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call discoverUserByPubKeyAsync(String pubKey, final ApiCallback<UserDisco> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = discoverUserByPubKeyValidateBeforeCall(pubKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UserDisco>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for discoverUserKeys
     * @param userId Identifier of the user. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call discoverUserKeysCall(UUID userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/discover/keys/{userId}"
            .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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

        String[] localVarAuthNames = new String[] { "APITokenAuth", "OAuthTokenAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call discoverUserKeysValidateBeforeCall(UUID userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling discoverUserKeys(Async)");
        }
        

        com.squareup.okhttp.Call call = discoverUserKeysCall(userId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get all public keys of a user.
     * Use this endpoint to get all public keys owned by a given user. 
     * @param userId Identifier of the user. (required)
     * @return List&lt;KeyDisco&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<KeyDisco> discoverUserKeys(UUID userId) throws ApiException {
        ApiResponse<List<KeyDisco>> resp = discoverUserKeysWithHttpInfo(userId);
        return resp.getData();
    }

    /**
     * Get all public keys of a user.
     * Use this endpoint to get all public keys owned by a given user. 
     * @param userId Identifier of the user. (required)
     * @return ApiResponse&lt;List&lt;KeyDisco&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<KeyDisco>> discoverUserKeysWithHttpInfo(UUID userId) throws ApiException {
        com.squareup.okhttp.Call call = discoverUserKeysValidateBeforeCall(userId, null, null);
        Type localVarReturnType = new TypeToken<List<KeyDisco>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all public keys of a user. (asynchronously)
     * Use this endpoint to get all public keys owned by a given user. 
     * @param userId Identifier of the user. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call discoverUserKeysAsync(UUID userId, final ApiCallback<List<KeyDisco>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = discoverUserKeysValidateBeforeCall(userId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<KeyDisco>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for discoverUsers
     * @param search A string used to search users through the fields &#x60;email&#x60;, &#x60;username&#x60;, &#x60;x500CommonName&#x60;, &#x60;x500Organization&#x60; and &#x60;x500OrganizationalUnit&#x60;. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call discoverUsersCall(String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/discover/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (search != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("search", search));
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

        String[] localVarAuthNames = new String[] { "APITokenAuth", "OAuthTokenAuth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call discoverUsersValidateBeforeCall(String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'search' is set
        if (search == null) {
            throw new ApiException("Missing the required parameter 'search' when calling discoverUsers(Async)");
        }
        

        com.squareup.okhttp.Call call = discoverUsersCall(search, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get all users matching a search string.
     * Use this endpoint to get all users whose &#x60;email&#x60;, &#x60;username&#x60;, &#x60;x500CommonName&#x60;, &#x60;x500Organization&#x60; or &#x60;x500OrganizationalUnit&#x60; contains the search string. 
     * @param search A string used to search users through the fields &#x60;email&#x60;, &#x60;username&#x60;, &#x60;x500CommonName&#x60;, &#x60;x500Organization&#x60; and &#x60;x500OrganizationalUnit&#x60;. (required)
     * @return List&lt;UserDisco&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<UserDisco> discoverUsers(String search) throws ApiException {
        ApiResponse<List<UserDisco>> resp = discoverUsersWithHttpInfo(search);
        return resp.getData();
    }

    /**
     * Get all users matching a search string.
     * Use this endpoint to get all users whose &#x60;email&#x60;, &#x60;username&#x60;, &#x60;x500CommonName&#x60;, &#x60;x500Organization&#x60; or &#x60;x500OrganizationalUnit&#x60; contains the search string. 
     * @param search A string used to search users through the fields &#x60;email&#x60;, &#x60;username&#x60;, &#x60;x500CommonName&#x60;, &#x60;x500Organization&#x60; and &#x60;x500OrganizationalUnit&#x60;. (required)
     * @return ApiResponse&lt;List&lt;UserDisco&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<UserDisco>> discoverUsersWithHttpInfo(String search) throws ApiException {
        com.squareup.okhttp.Call call = discoverUsersValidateBeforeCall(search, null, null);
        Type localVarReturnType = new TypeToken<List<UserDisco>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all users matching a search string. (asynchronously)
     * Use this endpoint to get all users whose &#x60;email&#x60;, &#x60;username&#x60;, &#x60;x500CommonName&#x60;, &#x60;x500Organization&#x60; or &#x60;x500OrganizationalUnit&#x60; contains the search string. 
     * @param search A string used to search users through the fields &#x60;email&#x60;, &#x60;username&#x60;, &#x60;x500CommonName&#x60;, &#x60;x500Organization&#x60; and &#x60;x500OrganizationalUnit&#x60;. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call discoverUsersAsync(String search, final ApiCallback<List<UserDisco>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = discoverUsersValidateBeforeCall(search, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<UserDisco>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
