# react-native-clear-cache
Android clear cache handler for react native.

## How to use this module
Add dependencies to package.json
```js
"dependencies": {
  ...
  "react-native-clear-cache": "git+https://github.com/fariswd/react-native-clear-cache.git"
}
```
```
yarn install
```
### Setup Android
Settings.graddle
```
include ':react-native-clear-cache'
project(':react-native-clear-cache').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-clear-cache/android')
```

Build.graddle
```
dependencies {
  ...
  compile project(':react-native-clear-cache')
  ...
}
```
MainApplication.java
```java
import com.fariswd.module.rnclearcache.RNClearCachePackage; // <<< -- add this

import com.facebook.react.ReactNativeHost;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

public class MainApplication extends MultiDexApplication {
  // Needed for `react-native link`
  public List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
        // Add your own packages here!
        // TODO: add cool native modules
        // Needed for `react-native link` text search
        new MainReactPackage(),
        new RNClearCachePackage() // <<< -- and this

    )
  }
}
```

## Use module
```js
import ClearCache from 'react-native-clear-cache'

ClearCache.clear(status => {
  if (!status) {
    console.log('error')
    return
  }
  console.log('success')
})
```

fariswd 2018  
:rocket:
