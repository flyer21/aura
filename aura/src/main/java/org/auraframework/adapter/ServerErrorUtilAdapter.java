/*
 * Copyright (C) 2013 salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.auraframework.adapter;

import java.util.logging.Level;

import org.auraframework.system.Annotations.AuraEnabled;
import org.auraframework.util.json.JsonSerializable;

/**
 * Wrapper for handling server-side Action errors.
 * Meant to be the single entry point for handling exceptions in
 * {@link AuraEnabled} controller methods.
 */
public interface ServerErrorUtilAdapter extends AuraAdapter {
    /**
     * Provides the default experience for errors.
     * Action error callback will not be invoked.
     * @param message   Error message
     */
    void handleException(String message);

    /**
     * Provides the default experience for errors.
     * Action error callback will not be invoked.
     * @param message   Error message
     * @param thrown    Exception being handled
     */
    void handleException(String message, Throwable thrown);

    /**
     * Provides the default experience for errors.
     * Action error callback will not be invoked.
     * @param message   Error message
     * @param thrown    Exception being handled
     * @param level     Logging level for the exception
     */
    void handleException(String message, Throwable thrown, Level level);

    /**
     * Results in a customized error experienced.
     * Action error callback will be invoked.
     * @param message   Error message
     * @param thrown    Exception being handled
     */
    void handleCustomException(String message, Throwable thrown);

    /**
     * Results in a customized error experienced.
     * Action error callback will be invoked.
     * @param message   Error message
     * @param thrown    Exception being handled
     * @param data      Custom properties for the error, available in the response.
     */
    void handleCustomException(String message, Throwable thrown, JsonSerializable data);

    /**
     * Results in a customized error experienced.
     * Action error callback will be invoked.
     * @param message   Error message
     * @param thrown    Exception being handled
     * @param data      Custom properties for the error, available in the response.
     * @param level     Logging level for the exception 
     */
    void handleCustomException(String message, Throwable thrown, JsonSerializable data, Level level);

    /**
     * Results in a customized error experienced.
     * Action error callback will be invoked.
     * Note that this API should only be used if only custom string is desired in action callback
     * @param message       Error message
     * @param thrown        Exception being handled
     * @param customMessage Custom string for the error, available in the contextMessage property in the response.
     * @param level         Logging level for the exception 
     */
    void handleCustomException(String message, Throwable thrown, String customMessage, Level level);

    /**
     * Results in a customized error experienced.
     * Action error callback will be invoked.
     * Note that this API should only be used if only custom string is desired in action callback
     * @param message                Error message
     * @param thrown                 Exception being handled
     * @param data                   Custom properties for the error, available in the response.
     * @param level                  Logging level for the exception 
     * @param processErrorMessage    String that is passed into processError method for logging
     */
    void handleCustomException(String message, Throwable thrown, JsonSerializable data, Level level,
            String processErrorMessage);

    /**
     * Results in a customized error experienced.
     * Action error callback will be invoked.
     * Note that this API should only be used if only custom string is desired in action callback
     * @param message                Error message
     * @param thrown                 Exception being handled
     * @param customMessage          Custom string for the error, available in the contextMessage property in the response.
     * @param level                  Logging level for the exception 
     * @param processErrorMessage    String that is passed into processError method for logging
     */
    void handleCustomException(String message, Throwable thrown, String customMessage, Level level,
            String processErrorMessage);
}
