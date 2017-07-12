/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.aerogear.android.authentication;

import java.net.URL;
import java.util.Map;

import org.jboss.aerogear.android.core.Callback;
import org.jboss.aerogear.android.pipe.module.PipeModule;
import org.jboss.aerogear.android.pipe.http.HeaderAndBody;
import org.jboss.aerogear.android.pipe.Pipe;

/**
 * A module which can authenticate a user. It also provides the necessary tools
 * to log a user in, out, and modify requests from a {@link Pipe} so they are
 * seen as authenticated.
 */
public interface AuthenticationModule extends PipeModule {

    public URL getBaseURL();

    public String getLoginEndpoint();

    public String getLogoutEndpoint();

    public String getEnrollEndpoint();

    /**
     * Will try to register a user with a service using userData.
     * 
     * It will call the callbacks onSuccess with a parameter of a Map of the
     * values returned by the enroll service or onFailure if there is an error
     * 
     * @param userData a collection of data to be passed to the server.
     * @param callback a callback which will handle the server response.
     */
    public void enroll(Map<String, String> userData,
                       Callback<HeaderAndBody> callback);

    /**
     * Will try to log in a user using username and password.
     *
     * It will call the callbacks onSuccess with a parameter of a Map of the
     * values returned by the enroll service or onFailure if there is an error
     * 
     * @param username the users userName
     * @param password the users Password
     * @param callback a callback which will handle the server response.
     */
    public void login(String username, String password,
                      Callback<HeaderAndBody> callback);

    /**
     * Will try to log in a user
     * 
     * It will call the callbacks onSuccess with a parameter of a Map of the
     * values returned by the enroll service or onFailure if there is an error
     * 
     * @param loginData a map of data which will be passed to the server
     * @param callback a callback which will handle the server response.
     */
    void login(Map<String, String> loginData, Callback<HeaderAndBody> callback);

    /**
     * Performs a logout of the current user.
     *
     * It will call callback.onSuccess with no value on success and
     * callback.onFailure if there is an error.
     * 
     * @param callback a callback which will handle the server response.
     */
    public void logout(Callback<Void> callback);

    /**
     * @return true if the module has been logged in successfully
     */
    public boolean isLoggedIn();


}
