# gtdorg

A Clojure library designed to ... well, that part is up to you.

## Development setup

### Getting the tools and dependencies

``` shell
$ yarn global add re-natal
$ yarn global add react-native
$ yarn install
```

### Once, or every time you switch up configs

Recompile index.android.js files:

``` shell
$ re-natal use-android-device avd
$ re-natal use-figwheel
```

### Startup emulator with figwheel

- Go into android studio > tools > AVD manager and double click one

or

- Start the simulator programmatically

``` shell
$ cd ~/Library/Android/sdk/tools/
$ ./bin/avdmanager list avd
$ ./emulator -avd PIXEL_XL_API_26
```

- Start the repl

``` shell
$ lein repl
```

- Start figwheel and cljs repl

``` clojure
user=> (start-figwheel "android")
```

- First time installs need to accept licenses.

``` shell
$ cd ~/Library/Android/sdk/tools/
$ ./bin/sdkmanager --licenses
```

- Export the sdk location env variable. If you want use:

``` shell
$ source bin/export
```

- Start the react native process in the avd

``` shell
$ ./node_modules/.bin/react-native run-android
```

- Profit

## Usage

FIXME

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
