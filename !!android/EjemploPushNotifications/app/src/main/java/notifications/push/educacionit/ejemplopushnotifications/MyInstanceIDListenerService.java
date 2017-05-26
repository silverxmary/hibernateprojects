/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package notifications.push.educacionit.ejemplopushnotifications;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;

public class MyInstanceIDListenerService extends InstanceIDListenerService {

    private static final String TAG = "MyInstanceIDLS";

    /**
     * Se llama si el token del InstanceId es actualizado, puede ocurrir si la seguridad del token previo
     * fue comprometida, es iniciado por el InstanceID provider.
     */
    @Override
    public void onTokenRefresh() {
        // Busca el token del InstanceID y notifica a nuestra aplicación servidor del cambio.
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}
